package review;

import com.sun.source.util.Trees;

public class Review2 {
    public static void main(String[] args) {
        System.out.println("Tree");


    }

    class TTree{

        private class NNode{
            private NNode leftChild;
            private NNode rightChild;
            private int value;

            public NNode( int value) {
                this.value = value;
            }
        }

        private NNode root;

//        My insert method for Binary Search Tree

        public void insertNode(int value){
            NNode node = new NNode(value);

            //if tree is empty
            if(root==null){
                root = node;
                return;
            }





            //if tree is not empty

        }
    }
}
