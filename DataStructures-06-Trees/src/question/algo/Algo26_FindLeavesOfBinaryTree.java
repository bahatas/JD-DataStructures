package question.algo;


import org.junit.Assert;
import org.junit.Test;

public class Algo26_FindLeavesOfBinaryTree {
    public static void main(String[] args) {

    }
    @Test
    public void test1(){

        Assert.assertEquals(null,Algo26_FindLeavesOfBinaryTree.findLeaves(null));
    }

    public static Node findLeaves(Node root){


        return null;
    }
}


class Node{

    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
