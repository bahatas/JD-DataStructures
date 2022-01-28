package question.algo31;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinarTreeZigzagLevelOrderTraversal {

    @Test
    public void test1() {
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(3);
        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(5);
        rootNode.right.left = new TreeNode(6);
        rootNode.right.right = new TreeNode(7);
        rootNode.left.left.left = new TreeNode(8);
        rootNode.left.left.right = new TreeNode(9);



    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<Integer> innerList = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();





        return null;
    }
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

}
/**
 * Given the root of a binary tree,
 * return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).


Input: root = [3,9,20,null,null,15,7]
        Output: [[3],[20,9],[15,7]]

 */