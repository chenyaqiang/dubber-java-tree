package com.dubber.tree;

/**
 * Created on 2018/5/7.
 *
 * @author dubber
 *         <p>
 *         二叉树的二叉链表存储
 */
public class BinaryTree<E> {

    public TreeNode root;


    // 已默认构造器创建二叉树
    public BinaryTree() {
        this.root = new TreeNode();
    }

    // 以指定根元素创建二叉树
    public BinaryTree(E data) {
        this.root = new TreeNode(data);
    }


    /**
     * 为指定节点添加子节点
     *
     * @param parentNode 需要添加子节点的父节点的索引
     * @param data       新子节点的数据
     * @param isLeft     是否为左节点
     * @return
     */
    public TreeNode addTreeNode(TreeNode parentNode, E data, boolean isLeft) {
        if (parentNode == null)
            throw new RuntimeException("parentNode 节点为null,无法添加子节点");

        if (isLeft && parentNode.left != null)
            throw new RuntimeException("parentNode 已经有左节点,无法添加左节点");

        if (!isLeft && parentNode.right != null)
            throw new RuntimeException("parentNode 已经有右节点,无法添加右节点");

        TreeNode newNode = new TreeNode(data);
        if (isLeft)
            parentNode.left = newNode;
        else
            parentNode.right = newNode;

        return newNode;
    }


    /**
     * 判断二叉树是否为空
     *
     * @return
     */
    public boolean empty() {
        return root.data == null;
    }

    /**
     * 返回根节点
     */
    public TreeNode root() {
        if (empty())
            throw new RuntimeException("树为空，无法返回根节点");

        return root;
    }

    /**
     * 返回指定节点（非根节点）的父节点
     */
    public E parent(TreeNode node) {

        //TODO
        return null;
    }


    /**
     * 返回指点节点（非叶子节点）的左节点
     *
     * @param parentNode
     * @return
     */
    public E leftChild(TreeNode parentNode) {
        if (parentNode == null)
            throw new RuntimeException("指定节点为Null");

        return parentNode.left == null ? null : (E) parentNode.left.data;
    }

    /**
     * 返回指点节点（非叶子节点）的右节点
     *
     * @param parentNode
     * @return
     */
    public E rightChild(TreeNode parentNode) {
        if (parentNode == null)
            throw new RuntimeException("指定节点为Null");

        return parentNode.right == null ? null : (E) parentNode.right.data;
    }


    /**
     * 求此树的深度
     * 调用 deep(TreeNode) 方法，循环得到树的总深度
     *
     * @return
     */
    public int deep() {
        return deep(root);
    }

    /**
     * 以指定节点为根节点的树的深度
     * 递归： 每一个子节点进行求深度
     *
     * @param node
     * @return
     */
    public int deep(TreeNode node) {
        if (node == null)
            return 0;

        int leftDeep = deep(node.left);
        int rightDeep = deep(node.right);
        int maxDeep = leftDeep >= rightDeep ? leftDeep : rightDeep;
        return maxDeep + 1;
    }


    /**
     * 前序遍历 根 -- 左 -- 右
     * 中序遍历 左 -- 根 -- 右
     * 后序遍历 左 -- 右 -- 根
     *
     * @param node
     * @param type
     * @return
     */

    /**
     * 前序遍历 根 -- 左 -- 右
     * 中序遍历 左 -- 根 -- 右
     * 后序遍历 左 -- 右 -- 根
     *
     * @param binaryTree 指定遍历的tree
     * @param type       遍历类型 （）
     * @return
     */
    public String orderTraversal(BinaryTree binaryTree, String type) {
        TreeNode broot = binaryTree.root();
        if (broot == null)
            throw new RuntimeException("空树，遍历个毛线！");
        else
            return treeRecursive(broot,type);
    }

    /**
     * 递归 遍历
     *
     * @param node
     * @return
     */
    public String treeRecursive(TreeNode node,String type) {
        if (node == null) {
            return "";
        }

        if(type.equals("pre"))
            return getPreString(node, type);

        if(type.equals("infix"))
            return getInfixString(node, type);

        if(type.equals("after"))
            return getAfterString(node, type);

        return "";
    }

    private String getPreString(TreeNode node, String type) {
        String result= "";
        result += node.data;
        result += treeRecursive(node.left,type);
        result += treeRecursive(node.right,type);
        return result;
    }

    private String getInfixString(TreeNode node, String type) {
        String result= "";
        result += treeRecursive(node.left,type);
        result += node.data;
        result += treeRecursive(node.right,type);
        return result;
    }

    private String getAfterString(TreeNode node, String type) {
        String result= "";
        result += treeRecursive(node.left,type);
        result += treeRecursive(node.right,type);
        result += node.data;
        return result;
    }

}
