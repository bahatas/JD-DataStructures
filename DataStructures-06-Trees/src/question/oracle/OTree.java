package question.oracle;


import java.util.ArrayList;
import java.util.List;

public class OTree {
    private static class Solution {

        public static void main(String[] args) {

            Tree tree = new Tree();
            tree.insertRecursive(3);
            tree.insertRecursive(1);
            tree.insertRecursive(5);
            tree.insertRecursive(0);
            tree.insertRecursive(2);
            tree.insertRecursive(4);
            tree.insertRecursive(6);
            tree.insertRecursive(8);
            tree.insertRecursive(7);



            System.out.println("tree.lca(4,7) = " + tree.lca(4, 7));
            System.out.println("tree.lca2(4,7) = " + tree.lca2(tree.root,4, 7));

//            System.out.println("tree.getPathToNode(7) = " + tree.getPathToNode(7));
//            System.out.println("tree.getPathToNode(4) = " + tree.getPathToNode(4));
            System.out.println("tree.getPathToNode2(7) = " + tree.getPathToNode2(tree.root, 7));
        }
    }

    private static class Tree {
        Node root;

        /**
         * basic impl of insert node method
         * @param value
         */
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

        /**
         * A recursive function to insert a new key in BST
         * @param root
         * @param value
         * @return
         */
        private Node insertRecursive(Node root,int value)  {

        /* If the tree is empty, return a new node */
            if (root == null) {
                root = new Node(value);
                return root;

            }
            /*Orherwise , recur down the tree */
            if (value < root.value) {
                root.leftChild = insertRecursive(root.leftChild, value);
            } else if (value > root.value) {
                root.rightChild = insertRecursive(root.rightChild, value);
            }
            /* return thr unchanged node pointer  */
            return root;
        }

        /**
         * lca solution
         * @param p
         * @param q
         * @return
         */
        private int lca(int p, int q) {
            Node current = root;
            while (current != null) {
                if (p > current.value && q > current.value) {
                    //traverse right of sub tree
                    current = current.rightChild;
                } else if (p < current.value && q < current.value) {
                    //traverse left subtree
                    current = current.leftChild;
                } else {
                    return current.value;
                }
            }
            return -1;
        }

        /**
         *
         * @param root
         * @param p
         * @param q
         * @return
         *
         * recursive solution of lca
         */
        private int lca2(Node root, int p, int q) {

            int rootValue = root.value;
            if (p > rootValue && q > rootValue) {
                return lca2(root.rightChild, p, q);
            } else if (p < rootValue && q < rootValue) {
                return lca2(root.leftChild, p, q);
            } else {
                return root.value;
            }
        }

        /**
         * regular version of find path
         * @param value
         * @return
         */
        public List<Integer> getPathToNode(int value){

            List<Integer> result = new ArrayList<>();
            if(root== null){
                return result;
            }
            while(root.value != value){
                if(value> root.value){
                    result.add(root.value);
                    root= root.rightChild;
                }else if(value< root.value){
                    result.add(root.value);
                    root = root.leftChild;
                }
                    
            }
            result.add(value);
            return  result;
        }

        /**
         * recurseive version of find path of node
         * @param current
         * @param value
         * @return
         */
        public List<Integer> getPathToNode2(Node current, int value){
            List<Integer> result = new ArrayList<>();

            if(root == null){
                return  result;
            }
            getPath(result,current,value);
            return result;
        }
        private boolean getPath(List<Integer> result , Node node, int value){
            if(node == null){
                return false;
            }
            result.add(node.value);
            if(node.value == value){
                return true;
            }
            if(getPath(result,node.leftChild,value) || getPath(result, node.rightChild, value)){
                return true;
            }
            result.remove(result.size()-1);
            return false;
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


}
