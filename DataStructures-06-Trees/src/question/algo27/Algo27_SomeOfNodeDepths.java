package question.algo27;


import static question.algo27.Algo27_SomeOfNodeDepths.TreeNode.newNode;

public class Algo27_SomeOfNodeDepths {
    public static void main(String[] args) {

        // Given Tree
        TreeNode root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.left.left.left = newNode(8);
        root.left.left.right = newNode(9);

        //Call
        System.out.println(sumOfDepths(root));
    }


    static class TreeNode {
        int data;
        TreeNode left, right;

        static TreeNode newNode(int data) {
            TreeNode Node = new TreeNode();
            Node.data = data;
            Node.left = Node.right = null;
            return (Node);
        }
    }
    static int sumOfDepths(TreeNode root){

        return depth(root,0);

    }

    static int depth(TreeNode node, int sum){
        if(node==null){
            return 0;
        }
        return sum + depth(node.left,sum+1)+depth(node.right,sum+1);
    }
    private static int height(TreeNode root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(
                height(root.left),
                height(root.right));
    }
    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right== null;

    }
}
/**
 * The distance between a node in a Binary Tree and the tree's root is called the node's depth. Write a
 * function that takes in a Binary Tree and returns the sum of its nodes' depths. Each BinaryTree node has an
 * integer value , a left child node, and a right child node. Children nodes can either be BinaryTree nodes
 * themselves or None / null
 * Tree. =
 *                                   1
 *                                 /  \
 *                               2     3
 *                              / \   / \
 *                             4   5 6   7
 *                            / \
 *                           8   9
 * Sample Output
 * 16
 */