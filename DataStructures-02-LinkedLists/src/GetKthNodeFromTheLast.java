public class GetKthNodeFromTheLast {
    public static void main(String[] args) {

        var myLinkedList= new MyLinkedList();
        System.out.println("myLinkedList address :   " + myLinkedList);
        for(int j=1; j<=10;j++) myLinkedList.addLast(j);
        myLinkedList.printLinkedList();
        System.out.println("myLinkedList First Node address:   " + myLinkedList.first);
        System.out.println("myLinkedList First Node Value:   " + myLinkedList.first.value);
        var current = myLinkedList.first;
        System.out.println("Current Node Value :   " + current.value);
        current=current.next;
        System.out.println("New Current Node Value :   " + current.value);


        //System.out.println(5+"th Node from the last is :" );
       // System.out.println(myLinkedList.getKthFromTheEnd(5));
    }
}
