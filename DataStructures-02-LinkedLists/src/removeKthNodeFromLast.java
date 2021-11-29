
public class removeKthNodeFromLast {
    public static void main(String[] args) {

        var myLinkedList= new MyLinkedList();

        for(int j=0; j<10;j++) myLinkedList.addLast(j);
        myLinkedList.printLinkedList();
        System.out.println(myLinkedList.size);
        myLinkedList.removeKthNodeFromEnd(10);
        myLinkedList.printLinkedList();
        System.out.println(myLinkedList.size);
    }
}


