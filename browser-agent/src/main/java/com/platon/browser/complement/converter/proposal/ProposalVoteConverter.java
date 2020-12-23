package com.platon.browser.complement.converter.proposal;

import com.platon.browser.common.complement.cache.NetworkStatCache;
import com.platon.browser.common.complement.dto.ComplementNodeOpt;
import com.platon.browser.common.queue.collection.event.CollectionEvent;
import com.platon.browser.complement.converter.BusinessParamConverter;
import com.platon.browser.complement.dao.mapper.ProposalBusinessMapper;
import com.platon.browser.complement.dao.param.proposal.ProposalVote;
import com.platon.browser.dao.entity.Proposal;
import com.platon.browser.dao.mapper.ProposalMapper;
import com.platon.browser.elasticsearch.dto.NodeOpt;
import com.platon.browser.elasticsearch.dto.Transaction;
import com.platon.browser.exception.BusinessException;
import com.platon.browser.param.ProposalVoteParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Date;

/**
 * @description: 委托业务参数转换器
 * @author: chendongming@matrixelements.com
 * @create: 2019-11-04 17:58:27
 **/
@Slf4j
@Service
public class ProposalVoteConverter extends BusinessParamConverter<NodeOpt> {
	
    @Autowired
    private ProposalBusinessMapper proposalBusinessMapper;
    @Autowired
    private NetworkStatCache networkStatCache;
    @Autowired
    private ProposalMapper proposalMapper;


    @Override
    public NodeOpt convert(CollectionEvent event, Transaction tx) {
        ProposalVoteParam txParam = tx.getTxParam(ProposalVoteParam.class);
        
        String proposalId = "";
        // 查询投票的提案信息
        Proposal proposal = null;
		try {
			proposalId = txParam.getProposalId();
			proposal = proposalMapper.selectByPrimaryKey(proposalId);
	        txParam.setPIDID(proposal.getPipId());
	        txParam.setProposalType(String.valueOf(proposal.getType()));
		} catch (Exception e) {
			//可能存在问题
		}

		if(proposal==null)
			throw new BusinessException("找不到投票提案[proposalId="+txParam.getProposalId()+"], 无法相关信息!");
		
        // 补充节点名称
        updateTxInfo(txParam,tx);
        
        // 失败的交易不分析业务数据
        if(Transaction.StatusEnum.FAILURE.getCode()==tx.getStatus()) return null;

        long startTime = System.currentTimeMillis();

		// 获得参数
        String nodeName = txParam.getNodeName();
        String txHash = tx.getHash();
        Long blockNum = event.getBlock().getNum();
        Date time = tx.getTime();



        // 投票记录
    	ProposalVote businessParam= ProposalVote.builder()
    			.nodeId(txParam.getVerifier())
    			.txHash(txHash)
    			.bNum(BigInteger.valueOf(blockNum))
    			.timestamp(time)
    			.stakingName(nodeName)
    			.proposalHash(txParam.getProposalId())
    			.voteOption(Integer.valueOf(txParam.getOption()))
                .build();

    	proposalBusinessMapper.vote(businessParam);

		String desc = NodeOpt.TypeEnum.VOTE.getTpl()
				.replace("ID",proposal.getPipId())
				.replace("TITLE",proposal.getTopic())
				.replace("OPTION",txParam.getOption())
				.replace("TYPE", String.valueOf(proposal.getType()))
				.replace("VERSION",proposal.getNewVersion()==null?"":proposal.getNewVersion());

		NodeOpt nodeOpt = ComplementNodeOpt.newInstance();
		nodeOpt.setId(networkStatCache.getAndIncrementNodeOptSeq());
		nodeOpt.setNodeId(txParam.getVerifier());
		nodeOpt.setType(Integer.valueOf(NodeOpt.TypeEnum.VOTE.getCode()));
		nodeOpt.setDesc(desc);
		nodeOpt.setTxHash(txHash);
		nodeOpt.setBNum(blockNum);
		nodeOpt.setTime(time);

		log.debug("处理耗时:{} ms",System.currentTimeMillis()-startTime);

        return nodeOpt;
    }
}
