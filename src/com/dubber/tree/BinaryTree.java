package com.dubber.tree;

import sun.reflect.generics.tree.Tree;

/**
 * Created on 2018/5/7.
 *
 * @author dubber
 *
 * 实现二叉树
 */
public class BinaryTree<E> {

    private TreeNode root;


    // 已默认构造器创建二叉树
    public BinaryTree() {
        this.root = new TreeNode();
    }

    // 以指定根元素创建二叉树
    public BinaryTree(E data){
        this.root = new TreeNode(data);
    }



    public TreeNode addTreeNode(TreeNode parentNode,E data,boolean isLeft){
        if(parentNode == null)
            throw new RuntimeException("parentNode 节点为null,无法添加子节点");

        if(isLeft && parentNode.left != null)
            throw new RuntimeException("parentNode 已经有左节点,无法添加左节点");


        TreeNode newNode = new TreeNode(data);
        if(isLeft)
            parentNode.left = newNode;
        else
            parentNode.right = newNode;

        return newNode;
    }




}
