public class DoublyLinkedList {
        public Node head;
        public Node tail;
        public void setHead(Node node) {
            // Write your code here.
        }
        public void setTail(Node node) {
            // Write your code here.
        }
        public void insertBefore(Node node, Node nodeToInsert) {
            // Write your code here.
        }
        public void insertAfter(Node node, Node nodeToInsert) {
            // Write your code here.
        }
        public void insertAfterValue(Node node, int value) {
        // Write your code here.
        }
        public void insertAtPosition(int position, Node nodeToInsert) {
            // Write your code here.
        }
        public void removeNodesWithValue(int value) {
            // Write your code here.
        }
        public void remove(Node node) {
            // Write your code here.
        }

        public int indexOf(int value) {
             // Write your code here.
              return -1;
        }
        public boolean containsNodeWithValue(int value) {
            // Write your code here.
            return false;
        }
    }
    // Do not edit the class below.
class Node {
        public int value;
        public Node prev;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

