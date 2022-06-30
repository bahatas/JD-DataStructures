package review;

import com.sun.source.util.Trees;

public class Review2 {
    public static void main(String[] args) {
        System.out.println("Tree");


    }

    class TTree {

        private class NNode {
            private NNode leftChild;
            private NNode rightChild;
            private int value;

            public NNode(int value) {
                this.value = value;
            }
        }

        private NNode root;

//        My insert method for Binary Search Tree

        public void insertNode(int value) {
            NNode node = new NNode(value);

            //if tree is empty
            if (root == null) {
                root = node;
                return;
            }

            //if tree is not empty
            NNode current = root;

            while (true) {
//                check if less
                if (value < current.value) {
                    if (current.leftChild == null) {
                        current.leftChild = node;
                        break;

                    }
                    current = current.leftChild;
                } else {
                    if (current.rightChild == null) {
                        current.rightChild = node;
                        break;
                    }
                    current = current.rightChild;
                }
            }
        }

        //traverse Pre order Root - Left - Right
        public void traversePreOrder() {

            traversePreOrder(root);
        }

        private void traversePreOrder(NNode root) {
            if (root == null) return;
            System.out.print(root.value + ",");
            traversePreOrder(root.leftChild);
            traversePreOrder(root.rightChild);

        }


        // traver in order left root right
        public void traverseInOrder() {
            traverseInOrder(root);
        }

        private void traverseInOrder(NNode root) {

            //if root is null
            if(root == null) return;
            traversePreOrder(root.leftChild);
            System.out.println(root.value + ", ");
            traverseInOrder(root.rightChild);

        }

        // traverse PostOrder  left - right child
         public void traversePostOrder(){
            traversePostOrder(root);
         }
         private void traversePostOrder(NNode root){
            if(root == null) return;
            traversePostOrder(root.leftChild);
            traversePostOrder(root.rightChild);
             System.out.println(root.value + ", ");
         }
    }
}