public class RemoveDuplicates {

    public static void main(String[] args) {
        MyLinkedList myLinkedList= new MyLinkedList();




        myLinkedList.insertInOrder(1);
        myLinkedList.insertInOrder(1);
        myLinkedList.insertInOrder(3);
        myLinkedList.insertInOrder(4);
        myLinkedList.insertInOrder(4);
        myLinkedList.insertInOrder(4);
        myLinkedList.insertInOrder(5);
        myLinkedList.insertInOrder(6);
        myLinkedList.insertInOrder(6);

        myLinkedList.printLinkedList();
        myLinkedList.removeDuplicates();
        myLinkedList.printLinkedList();

    }

}
