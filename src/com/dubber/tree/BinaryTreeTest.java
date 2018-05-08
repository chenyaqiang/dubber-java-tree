package com.dubber.tree;

/**
 * Created on 2018/5/8.
 *
 * @author dubber
 */
public class BinaryTreeTest {
    public static void main(String[] args) {

        String rootData = "A";
        BinaryTree<String> binaryTree = new BinaryTree<>(rootData);
        //添加子节点
        addNode(binaryTree);
        //求数深度
        System.out.println(binaryTree.deep());
        //tree 前序遍历
        System.out.println("前序遍历：");
        System.out.println(binaryTree.orderTraversal(binaryTree,"pre"));

        //tree 中序遍历
        System.out.println("中序遍历：");
        System.out.println(binaryTree.orderTraversal(binaryTree,"infix"));

        //tree 后序遍历
        System.out.println("后序遍历：");
        System.out.println(binaryTree.orderTraversal(binaryTree,"after"));

    }


    private static void addNode(BinaryTree<String> binaryTree) {
        TreeNode root = binaryTree.root;
        TreeNode Bnode = binaryTree.addTreeNode(root, "B", true);
        TreeNode Enode = binaryTree.addTreeNode(root, "E", false);

        TreeNode Cnode = binaryTree.addTreeNode(Bnode, "C", true);
        TreeNode Dnode = binaryTree.addTreeNode(Bnode, "D", false);

        TreeNode Fnode = binaryTree.addTreeNode(Enode, "F", false);
        TreeNode Gnode = binaryTree.addTreeNode(Fnode, "G", false);
    }
}
