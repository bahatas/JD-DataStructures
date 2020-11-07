public class PrintTheMiddleNodes {
    public static void main(String[] args) {

        var myLinkedList= new MyLinkedList();
        for(int j=1; j<=11;j++) myLinkedList.addLast(j);
        System.out.println("Linked List---------:");
        myLinkedList.printLinkedList();
        System.out.println("Middle Node/Nodes of Linked Lists");
        myLinkedList.printMiddle();
    }

}
