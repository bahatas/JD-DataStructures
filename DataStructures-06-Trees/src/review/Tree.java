package review;

class Tree {

    //Nested Node class


class Node {
    private Node leftChild;
    private Node rightChild;
    private int value;

    Node(int value) {
        this.value = value;
    }

}
    private Node root;

    //My insert method
    public void insert(int value) {

        Node node = new Node(value);

        //if tree is empty
        if (root == null) {
            root = node;
            return;
        }

        //if tree is not empty
        Node current = root;

        while (true) {
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

    /**
     * PRE ORDER
     * Root -> Left -> Right
     */

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {

        if (root == null )return;
        System.out.println("root.value = " + root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);

    }


    /**
     * IN ORDER
     * LEFT -> ROOT -> RIGHT
     */

    public void traverseInOrder(){
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root){
        if(root == null ) return;
        traverseInOrder(root.leftChild);
        System.out.print(root.value + ",");
        traverseInOrder(root.rightChild);
    }

}
