public class QueueProblemsMainApp {
    public static void main(String[] args) {
        MyQueue<Integer> myqueue=new MyQueue<Integer>();

        for(int i=1;i<11;i++) myqueue.enqueue(i);
        for (int i=1;i<11;i++) System.out.print(myqueue.dequeue()+", ");

        // have to fill it again
        for(int i=1;i<11;i++) myqueue.enqueue(i);
        System.out.println();

        System.out.println("First "+ 3 +" elements reversed :");
        ReverseFirstKElementsQueue.reverseFirstK(myqueue,3);
        for (int i=1;i<11;i++) System.out.print(myqueue.dequeue()+", ");

    }
}
