public class LinkedListMain {
    public static void main(String[] args) {
      LinkedList head =new LinkedList(0);
      head.next=new LinkedList(1);
      head.next.next=new LinkedList(2);
      head.next.next.next=new LinkedList(3);
        LinkedList loop=head.next.next.next.next=new LinkedList(4);
        head.next.next.next.next.next=new LinkedList(5);
        head.next.next.next.next.next.next=new LinkedList(6);
        head.next.next.next.next.next.next.next=loop;
        System.out.println(FindLoop.findLoop(head).value);
    }
}
