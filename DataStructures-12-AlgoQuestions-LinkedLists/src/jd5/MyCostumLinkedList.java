package jd5;



public class MyCostumLinkedList {

    MyNode head;
    MyNode tail;
    int size = 0;

    public static void main(String[] args) {
        MyNode n1 = new MyNode(1);
        MyNode n2 = new MyNode(2);
        MyNode n3 = new MyNode(3);
        MyNode n4 = new MyNode(4);
        MyNode n5 = new MyNode(5);
        MyNode n8 = new MyNode(0);

        MyCostumLinkedList myCostumLinkedList = new MyCostumLinkedList();
        myCostumLinkedList.insertNode(5);
        myCostumLinkedList.insertNode(6);

        myCostumLinkedList.print();


    }

    public void insertNode(int val) {
        MyNode node = new MyNode();
        if (head == null && tail == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }


    }

    public void print() {
        MyNode current = head;
        while (current.next!= null) {
            System.out.print(current.val + " ->");
            current = current.next;
        }

    }

}