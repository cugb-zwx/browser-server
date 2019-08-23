package com.platon.browser.engine.stage;

import com.platon.browser.dao.entity.Proposal;
import com.platon.browser.dao.entity.Vote;
import com.platon.browser.dto.CustomVote;
import lombok.Data;

import java.util.*;

/**
 * @Auther: Chendongming
 * @Date: 2019/8/10 16:47
 * @Description:
 */
@Data
public class ProposalStage {
    // 插入或更新数据
    private Set<Proposal> proposalInsertStage = new HashSet<>();
    private Set<Proposal> proposalUpdateStage = new HashSet<>();
    private Set<Vote> voteInsertStage = new HashSet<>();
    private Set<Vote> voteUpdateStage = new HashSet<>();
    public void clear() {
        proposalInsertStage.clear();
        proposalUpdateStage.clear();
        voteInsertStage.clear();
        voteUpdateStage.clear();
    }

    public void insertProposal( Proposal proposal){
        proposalInsertStage.add(proposal);
    }
    public void updateProposal( Proposal proposal){
        proposalUpdateStage.add(proposal);
    }

    public void insertVote( Vote vote){
        voteInsertStage.add(vote);
    }
    public void updateVote( Vote vote){
        voteUpdateStage.add(vote);
    }

}
