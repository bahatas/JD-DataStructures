package question.algo26;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Algo26_FindLeavesOfBinaryTree {
    public static void main(String[] args) {

        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left =  new Node(4);
        rootNode.left.right= new Node(5);
    }
    @Test
    public void test1(){
        Node rootNode = new Node(1);
        rootNode.left = new Node(2);
        rootNode.right = new Node(3);
        rootNode.left.left =  new Node(4);
        rootNode.left.right= new Node(5);
        Assert.assertEquals(0,Algo26_FindLeavesOfBinaryTree.findLeaves(null));
        Assert.assertEquals(4,Algo26_FindLeavesOfBinaryTree.findLeaves(rootNode));
    }

     static List<List<Integer>> findLeaves(Node root) {

        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        level(root, ans);
        return ans;
    }

     static Integer level(Node root, List<List<Integer>> ans) {

        if (root == null) return -1;
        int level = Math.max(level(root.left,ans),level(root.right,ans))+1;
        if(ans.size() <= level){
          ans.add(new ArrayList<>());
        }
        ans.get(level).add(root.value);
        return level;
    }
}


class Node{

    int value;
    Node left;
    Node right;

    Node(){}

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
