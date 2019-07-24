package com.platon.browser.service;

import com.platon.browser.dao.entity.NodeRanking;
import com.platon.browser.dto.NodeRespPage;
import com.platon.browser.dto.block.BlockListItem;
import com.platon.browser.dto.node.NodeDetail;
import com.platon.browser.dto.node.NodeListItem;
import com.platon.browser.dto.node.NodePushItem;
import com.platon.browser.req.block.BlockListReq;
import com.platon.browser.req.node.NodeDetailReq;
import com.platon.browser.req.node.NodePageReq;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface NodeService {
    NodeRespPage<NodeListItem> getPage(NodePageReq req);
    NodeDetail getDetail(NodeDetailReq req);
    void updatePushData(String chainId, Set<NodeRanking> data);
    void clearPushCache(String chainId);
    List<NodePushItem> getPushCache(String chainId);
    List<BlockListItem> getBlockList(BlockListReq req);
    Map<String,String> getNodeNameMap(String chainId, List<String> nodeIds);

    void updateLocalNodeCache(String chainId);
}