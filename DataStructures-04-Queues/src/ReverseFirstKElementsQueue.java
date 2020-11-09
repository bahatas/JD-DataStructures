public class ReverseFirstKElementsQueue {
    public static MyQueue reverseFirstK(MyQueue myQueue, int k) {

        if (k < 0 || k > myQueue.size())
            throw new IllegalArgumentException();

        MyStack<Integer> stack = new MyStack<Integer>();

        // Dequeue the first K elements from the queue
        // and push them onto the stack
        for (int i = 0; i < k; i++)
            stack.push((Integer) myQueue.dequeue());

        // Enqueue the content of the stack at the
        // back of the queue
        while (!stack.isEmpty())
            myQueue.enqueue(stack.pop());

        // Add the remaining items in the queue (items
        // after the first K elements) to the back of the
        // queue and remove them from the beginning of the queue
        for (int i = 0; i < myQueue.size()- k; i++)
            myQueue.enqueue(myQueue.dequeue());
        return myQueue;
    }
}

