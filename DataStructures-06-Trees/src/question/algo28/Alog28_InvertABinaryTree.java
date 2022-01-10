package question.algo28;

import org.junit.Test;

public class Alog28_InvertABinaryTree {
    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(5);
        rootNode.left.left.left = new TreeNode(8);
        rootNode.left.left.right = new TreeNode(9);
        rootNode.right.left = new TreeNode(6);
        rootNode.right.right = new TreeNode(7);


        invertTree(rootNode);
    }

    @Test
    public void test1() {
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(5);
        rootNode.left.left.left = new TreeNode(8);
        rootNode.left.left.right = new TreeNode(9);
        rootNode.right.left = new TreeNode(6);
        rootNode.right.right = new TreeNode(7);


    }

    static TreeNode invertTree(TreeNode root) {


        if(root==null){
            return root;
        }
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;


        invertTree(root.right);
        invertTree(root.left);

        return root;
    }
}


/**
 *
 * LeetCode 226
 * Question #28
 * Invert Binary Tree
 * Difficulty :Medium Category :Tree
 * Write a method that takes in a Binary Tree and inverts it. In other words, the function should swap
 * every left node in the tree for its corresponding right node. Each BinaryTree node has an integer
 * value , a left child node, and a right child node. Children nodes can either be BinaryTree nodes
 * themselves or None / null .
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}