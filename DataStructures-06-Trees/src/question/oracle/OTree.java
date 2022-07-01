package question.oracle;


public class OTree {

    private class Tree {
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
            Node node = new Node(value);

            insertRecursive(node,value);


        }

        /* A recursive function to
       insert a new key in BST */
        private Node insertRecursive(Node node,int value)  {

        /* If the tree is empty,
           return a new node */

            if (root == null) {
                root = node;
                return node;

            }
            /*Orherwise , recur down the tree */

            if (value < current.value) {
                current.leftChild = insertRecursive(root.leftChild,value);
            }else if (value> current.value){
                current.rightChild = insertRecursive(current.rightChild,value);
            }

            /* return thr unchanged node pointer  */
            return node;
        }

    }

    private class Node {

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

        }
    }

}
