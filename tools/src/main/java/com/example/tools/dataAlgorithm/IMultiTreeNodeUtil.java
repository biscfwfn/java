package com.example.tools.dataAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 多叉树工具类
 */
public class IMultiTreeNodeUtil {
    private List<IMultiTreeNode> list;

    public IMultiTreeNodeUtil(){
        init();
    }
    public IMultiTreeNodeUtil(List<IMultiTreeNode> treeNodeList){
        init();
        createTree(treeNodeList);
    }
    private void init(){
        if(list == null){
            list = new ArrayList<>();
        }
    }

    /**
     * 生成一棵树
     */
    private void createTree(List<IMultiTreeNode> treeNodeList){
        Map<String,List<IMultiTreeNode>> nodeMap = traverseNodeToMap(treeNodeList);
        relevancyNodeToMap(nodeMap,this.list);
    }

    /**
     * 遍历 nodeList 保存node节点到Map中
     * @return
     */
    private Map<String,List<IMultiTreeNode>> traverseNodeToMap(List<IMultiTreeNode> treeNodeList){
        Map<String,List<IMultiTreeNode>> nodeMap = new HashMap<>();
        List<String> pid = treeNodeList.stream()
                .filter(o -> !isRootNode(o.getParentId()))
                .map(IMultiTreeNode::getParentId).collect(Collectors.toList());
        for(IMultiTreeNode treeNode: treeNodeList){
            if (isRootNode(treeNode.getParentId()) || !pid.contains(treeNode.getId())){
                this.list.add(treeNode);
            }else {
                List<IMultiTreeNode> list = nodeMap.get(treeNode.getParentId());
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(treeNode);
                nodeMap.put(treeNode.getParentId(), list);
            }
        }
        return nodeMap;
    }
    // 判断是否为根节点
    private boolean isRootNode(String id){
        if(id == null || id.equals("") || id.equals("0")){
            return true;
        }
        return false;
    }

    /**
     * 进行父亲孩子节点互相关联
     * @param nodeMap
     */
    private void relevancyNodeToMap(Map<String,List<IMultiTreeNode>> nodeMap,List<IMultiTreeNode> childList){
        for(IMultiTreeNode item: childList){
            if(nodeMap.get(item.getId()) != null){
                item.setChildList(nodeMap.get(item.getId()));
                nodeMap.remove(item.getId());
                relevancyNodeToMap(nodeMap,item.getChildList());
            }
        }
    }

    public List<IMultiTreeNode> getList() {
        return list;
    }
}
