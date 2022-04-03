package question.algo31;

import org.junit.Test;


import java.util.*;

import static org.junit.Assert.assertEquals;

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

        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9), zigzagLevelOrder2(rootNode));

    }
    @Test
    public void test2() {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);
        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);


        assertEquals(Arrays.asList(3,9,20,15,7), zigzagLevelOrder2(rootNode));

    }
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root){
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int count= 1;
        while (q.size() > 0) {
            List<Integer> innerList = new ArrayList<>();
            int size = q.size();

            for(int i =0; i<size; i++){
                TreeNode current = q.poll();
                innerList.add(current.val);
                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);

            }
            if(count % 2 ==0){
                Collections.reverse(innerList);
            }
            resultList.add(innerList);
            count++;
        }
        return resultList;
    }
    static List<Integer> levelOrder(TreeNode root) {

        if (root == null) return null;
        List<Integer> list = new ArrayList<>();


        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);

        while (q.size() > 0) {

            TreeNode currentNode = q.peek();
            list.add(q.peek().val);

            if (currentNode.left != null) q.add(currentNode.left);

            if (currentNode.right != null) q.add(currentNode.right);


            q.poll();
        }
        return list;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Step 1: Define the result
        List<List<Integer>> result = new ArrayList<>();

        // Step 2: Base Case
        if (root == null) return result;

        // Step 3: Create 2 stacks
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        // Step 4: Push root into stack
        s1.push(root);

        // Step 4: Continue traversing until both stacks are empty
        while (s1.size() > 0 || s2.size() > 0) {

            // Step 5: Create a list to store current level nodes in left-to-right order
            List<Integer> list1 = new ArrayList<>();

            // Step 6: While stack 1 is not empty
            while (s1.size() > 0) {

                // Step 7: Pop the item from stack 1
                TreeNode node = s1.pop();

                // Step 8: Store the value
                list1.add(node.val);

                // Step 9: Push it's left child in stack 2
                if (node.left != null) s2.push(node.left);

                // Step 10: Push it's right child in stack 2
                if (node.right != null) s2.push(node.right);

            }

            // Step 11: Store the current level traversal in result
            if (list1.size() > 0) result.add(list1);

            // Step 12: Create a list to store current level nodes in right-to-left order
            List<Integer> list2 = new ArrayList<>();

            // Step 13: While stack 2 is not empty
            while
            (s2.size() > 0) {

                // Step 14: Pop top node from stack 2
                TreeNode node = s2.pop();

                // Step 15: Save the value
                list2.add(node.val);


                // Step 16: Store right child in stack 1
                if (node.right != null) s1.push(node.right);

                // Step 17: Store left child in stack 1
                if (node.left != null) s1.push(node.left);


            }
            // Step 18: Store the current level traversal in result
            if (list2.size() > 0) result.add(list2);

        }
        return result;


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
 * leetcode #103
 * Given the root of a binary tree,
 * return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * <p>
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 */