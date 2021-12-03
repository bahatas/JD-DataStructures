public class DoubleLinkListApp {
    public static void main(String[] args) {
        DoublyLinkedList myDoubleLinkList=new DoublyLinkedList();
        myDoubleLinkList.insert(1);
        myDoubleLinkList.insert(2);
        myDoubleLinkList.insert(3);
        myDoubleLinkList.printNodes();

        myDoubleLinkList.insertAtPosition(2,5);
        myDoubleLinkList.printNodes();
    }
}
