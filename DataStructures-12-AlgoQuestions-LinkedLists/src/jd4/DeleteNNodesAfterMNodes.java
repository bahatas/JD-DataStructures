package jd4;

import org.jetbrains.annotations.Contract;

import java.util.List;

public class DeleteNNodesAfterMNodes {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15};
//        ListNode node = arrayToListNode(arr);
        Node node = Node.arrayToListNode(arr);
        print(node);
        System.out.println();
//        print(deleteNAfterMNodes(node,1,1));
        print(deleteNNodesAfterMNodes2(node,2,6));
        System.out.println();
        System.out.println("***********");
        print(deleteNode(node,1,1));
        System.out.println();
        System.out.println("***********");
        Node node7 = new Node(7);
        Node node6 = new Node(6);
        Node node5 = new Node(5);
        Node node4 = new Node(4);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node1 = new Node(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next= node7;

       print(deleteNode3(node1,1,1));
    }
    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }
    static Node deleteNode3(Node node, int m, int n) {

        Node current = node;
        Node keep = node;

        while (current!= null) {

            for (int i = 0; i < m && current != null; i++) {
                keep = current;
                current = current.next;
            }
            for (int i = 0; i < n && current != null; i++) {

                current = current.next;
            }
            keep.next=current;
        }

        return node;
    }

    static Node deleteNode(Node node, int m, int n) {

        Node current = node;

        while (current != null) {
            for (int i = 1; i < m && current != null; i++) {
                current = current.next;
            }
            Node lastNode = current;
            for (int i = 1; i < n && current != null; i++) {
                current = current.next;
            }
            lastNode.next = current.next;
            current.next = null;
            current = lastNode.next;
        }
        return node;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


//    public static void print(ListNode node) {
//        while (node != null) {
//            System.out.print(node.val + ", ");
//            node = node.next;
//        }
//    }

//    public static ListNode arrayToListNode(int[] arr) {
//        ListNode nodeToAdd = new ListNode(arr[0]);
//        ListNode head = nodeToAdd;
//        for (int i = 1; i < arr.length; i++) {
//            nodeToAdd.next = new ListNode(arr[i]);
//            nodeToAdd = nodeToAdd.next;
//        }
//        return head;
//    }

    public static  Node deleteNAfterMNodes(Node head, int m, int n) {


        Node current = head;
        Node lastMNode = head;
        while (current != null) {
            // initialize mCount to m and nCount to n
            int mCount = m, nCount = n;
            // jump m nodes
            while (current != null && mCount != 0) {
                lastMNode = current;
                current = current.next;
                mCount--;
            }
            // jump n nodes to remove
            while (current != null && nCount != 0) {
                current = current.next;
                nCount--;
            }
            // delete n nodes
            lastMNode.next = current;
        }//end while
        return head;
    }
    public static Node deleteNNodesAfterMNodes2(Node head, int m, int n) {
        Node pointer1 = head;
        Node pointer2;
        while (pointer1 != null) {
            for (int i = 1;pointer1.next != null &&  i < m ; i++) {
                pointer1 = pointer1.next;
            }
            pointer2 = pointer1.next;
            for (int i = 1; i <= n && pointer2 != null; i++) {
                pointer2 = pointer2.next;
            }
            pointer1.next = pointer2;
            pointer1 = pointer2;
        }
        return head;
    }

}


class Node {
    int val;
    Node next;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
    public static void print(Node node) {
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    public static Node arrayToListNode(int[] arr) {
        Node nodeToAdd = new Node(arr[0]);
        Node head = nodeToAdd;
        for (int i = 1; i < arr.length; i++) {
            nodeToAdd.next = new Node(arr[i]);
            nodeToAdd = nodeToAdd.next;
        }
        return head;
    }
    static void getLisT(List<Integer> list) {
        list = List.of(1, 2, 3, 4, 5, 6, 7);

        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                System.out.println("j = " + j);
                i++;

            }
        }
    }

    @Contract("null -> fail")
    public static void printLinkedList2(Node first) {
        if (first==null)
            throw new IllegalStateException();
        Node cur = first;
        while (cur!= null) {
            System.out.println("Value :  "+cur.next.val);
            cur=cur.next;
        }
    }
    public static Node keepMRemoveN2(Node myList, int m, int n) {
        Node newHead = new Node();
        Node head = myList;
        newHead.val =head.val;
//        Node newHead= newList.head; ?
        int counter = 1;
        int k =m+n;

// 1,2,3,4,5,6,7,8,9,  hold 3 skip 2, mode 5, 1%5<=3 2%5<=3 3%5<=3 4%5>3 5%5=0 6%5=1<=3
        while (head != null) {
            counter++;
            head = head.next;
            if ((counter % k) <= m && (counter % k != 0)) {
                newHead.next = head;
                newHead=newHead.next;

            }

            System.out.println("counter is  "+counter+" newHead.value is "+newHead.val+" if cond = "+((counter % k) <= m && (counter % k != 0)));

        }


        return newHead;

    }

}
/**
 * You are given the head of a linked list and two integers m and n.
 * Traverse the linked list and remove some nodes in the following way:
 * • Start with the head as the current node.
 * • Keep the first m nodes starting with the current node.
 * • Remove the next n nodes
 * • Keep repeating steps 2 and 3 until you reach the end of the list.
 * Return the head of the modified list after removing the mentioned nodes.
 */