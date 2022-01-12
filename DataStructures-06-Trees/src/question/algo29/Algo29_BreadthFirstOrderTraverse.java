package question.algo29;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Algo29_BreadthFirstOrderTraverse {


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

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9),levelOrder(rootNode));

    }

    static List<Integer> levelOrder(TreeNode root) {

        if (root == null) return null;
        List<Integer> list = new ArrayList<>();


        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);

        while (q.size() >0) {

            TreeNode currentNode= q.peek();
            list.add(q.peek().val);

            if (currentNode.left != null) q.add(currentNode.left);

            if (currentNode.right != null) q.add(currentNode.right);


            q.poll();
        }
        return list;
    }

}

/**
 * Question #29
 * Breadth First Traversal of Binary Tree (Level Order)
 * Difficulty :Easy Category :Tree
 * Write a method that takes in a Binary Tree and traverse it in level order. Be ready to talk about the
 * implementation.
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