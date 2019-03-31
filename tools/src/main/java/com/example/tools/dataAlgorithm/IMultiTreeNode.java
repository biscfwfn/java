package com.example.tools.dataAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 多叉树节点类
 */
public class IMultiTreeNode {
    private String id;
    private String name;
    private String parentId;
    private List<IMultiTreeNode> childList;

    public IMultiTreeNode(){
        if(this.childList == null){
            this.childList = new ArrayList<>();
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<IMultiTreeNode> getChildList() {
        return childList;
    }

    public void setChildList(List<IMultiTreeNode> childList) {
        this.childList = childList;
    }
}
