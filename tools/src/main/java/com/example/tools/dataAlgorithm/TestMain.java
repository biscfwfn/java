package com.example.tools.dataAlgorithm;

import com.example.tools.entity.RegionEntity;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
    public static void main(String[] args){
        log("二叉树");
        // 1、获取业务list数据
        List<RegionEntity> listAll = new ArrayList<>();
        RegionEntity r = new RegionEntity();
        r.setCode("12");
        r.setName("123");
        listAll.add(r);
        // 2、new一个list保存全部节点
        List<IMultiTreeNode> listNode = new ArrayList<>();

        //2、必须初始化一个root节点，保证根的唯一性
        IMultiTreeNode rootNode = new IMultiTreeNode();

        //3、循环遍历所有
        for (int j = 0; j < listAll.size(); j++) {
            RegionEntity sysDeptEntity = listAll.get(j);
            IMultiTreeNode treeNode = new IMultiTreeNode();
            treeNode.setParentId(sysDeptEntity.getParentCode());
            treeNode.setId(sysDeptEntity.getCode());
            treeNode.setName(sysDeptEntity.getName());
            listNode.add(treeNode);
        }

        //4、绑定父节点跟子节点的关系
        IMultiTreeNodeUtil treeHelper = new IMultiTreeNodeUtil(listNode);
        //获取树形
        log(treeHelper.getList());
    }
    private static void log(Object str){
        System.out.println(str);
    }
}
