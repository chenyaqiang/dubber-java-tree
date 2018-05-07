package com.dubber.tree;

/**
 * Created on 2018/5/7.
 *
 * @author dubber
 */
public class TreeNode {

    public Object data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Object data){
        this.data = data;
    }

    public TreeNode(Object data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
