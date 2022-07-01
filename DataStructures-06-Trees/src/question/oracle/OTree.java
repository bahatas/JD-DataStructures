package question.oracle;


public class OTree {

    private static class Tree {
        Node root;


        void insertNode(int value) {
            Node tobeInserted = new Node(value);
            Node current = root;
            if (root == null) {
                root = tobeInserted;
                return;

            }
            while (true) {
                if (value > current.value) {
                    if (current.rightChild == null) {
                        current.rightChild = tobeInserted;
                        break;
                    }
                    current = current.rightChild;

                } else {
                    if (current.leftChild == null) {
                        current.leftChild = tobeInserted;
                        break;
                    }
                    current = current.leftChild;
                }
            }

        }

        void insertRecursive(int value) {


            root = insertRecursive(root,value);


        }

        /* A recursive function to
       insert a new key in BST */
        private Node insertRecursive(Node root,int value)  {

        /* If the tree is empty,
           return a new node */

            if (root == null) {
                root = new Node(value);
                return root;

            }
            /*Orherwise , recur down the tree */

            if (value < root.value) {
                root.leftChild = insertRecursive(root.leftChild,value);
            }else if (value> root.value){
                root.rightChild = insertRecursive(root.rightChild,value);
            }
            /* return thr unchanged node pointer  */
            return root;
        }

    }

    private static class Node {

        Node leftChild;
        Node rightChild;
        int value;

        public Node(int value) {
            this.value = value;
        }

        public Node() {
        }
    }

    private static class Solution {
        public static void main(String[] args) {
            Tree tree = new Tree();
            tree.insertRecursive(50);
            tree.insertRecursive(30);
            tree.insertRecursive(20);
            tree.insertRecursive(40);
            tree.insertRecursive(70);
            tree.insertRecursive(60);
            tree.insertRecursive(80);
        }
    }

}
