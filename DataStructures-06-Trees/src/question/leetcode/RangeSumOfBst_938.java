package question.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RangeSumOfBst_938 {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);


    }

    @Test
    public void test1() {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        Assert.assertEquals("Sum", 32, RangeSumOfBst_938.rangeSumBST(root, 7, 15));
        Assert.assertEquals("Second One", 32, RangeSumOfBst_938.rangeSumBST2(root, 7, 15));
    }

    static int rangeSumBST(TreeNode root, int low, int high) {

        inorder(root);
        return nums.stream().filter(e->e>=low && e<=high).reduce(0,(a,b)->a+b).intValue();

    }

    static List<Integer> nums = new ArrayList<>();

    static void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        nums.add(root.val);
        inorder(root.right);

    }

    /**
     * This is the solution
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    static int rangeSumBST2(TreeNode root, int low, int high) {
        if(root==null){
            return 0;
        }
        if(root.val<low){
            return rangeSumBST(root.right,low,high);
        }
        else if(root.val>high){
            return rangeSumBST(root.left,low,high);
        }
        else{
            return rangeSumBST(root.left,low,high)+ rangeSumBST(root.right,low,high)+root.val;
        }
    }


}

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 * <p>
 * Given the root node of a binary search tree and two integers low and high,
 * return the sum of values of all nodes with a value in the inclusive range [low, high].
 * <p>
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 */


// class TreeNode {
//    int data;
//    TreeNode left, right;
//
//    static TreeNode newNode(int data) {
//        TreeNode Node = new TreeNode();
//        Node.data = data;
//        Node.left = Node.right = null;
//        return (Node);
//    }
//}
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
