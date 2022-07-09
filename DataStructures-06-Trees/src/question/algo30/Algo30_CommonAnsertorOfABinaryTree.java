package question.algo30;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class Algo30_CommonAnsertorOfABinaryTree {


    @Test
    public void test1() {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(5);
        rootNode.right = new TreeNode(1);
        rootNode.left.left = new TreeNode(6);
        rootNode.left.right = new TreeNode(2);
        rootNode.right.left = new TreeNode(0);
        rootNode.right.right = new TreeNode(8);
        rootNode.left.rigt.left = new TreeNode(7);
        rootNode.left.right.right = new TreeNode(4);

        assertEquals(rootNode,lowestAnscestor(rootNode, rootNode.left, rootNode.right ));

    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {



        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;

        return list;
    }

}

/**
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 *
 Given a binary tree, find the lowest common ancestor (LCA) of two given nod
 According to the definition of LCA on Wikipedia: "The lowest common ancest
 between two nodes p and q as the lowest node in T that has both p and q as
 we allow a node to be a descendant of itself)."
 Example 1:
 3
 [1,2], p = 1, q = 2
 5
 6
 7
 2
 o
 8
 4
 Input: root = [3,5,1,6,2,O,8,null,null,7,4], p -
 Output: 3

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