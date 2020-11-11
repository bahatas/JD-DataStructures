import java.util.NoSuchElementException;

public class MyQueue<T> {
    //Node Declarations
        private class Node {
            private T value;
            private Node next;
            public Node(T value) {
                this.value = value;
                this.next=null;
            }
        } // Node class end

    private Node front;
    private Node back;
    private int size;

        //add after last
        public void enqueue(T item) {
            var node = new Node(item);

            if (isEmpty())
                front = back = node;
            else {
                back.next = node;
                back = node;
            }

            size++;
        }

        public  T dequeue() {
            T t;
            if (isEmpty())
                throw new NoSuchElementException();
            // if there is only one item in queue
            if (front == back)
            {t=front.value;
                front = back = null;}
            else {
                t=front.value;
                var second = front.next;
                front.next = null;// break the link
                front = second;
            }
            size--;
            return t;
        }



        private boolean isEmpty() {
            return front == null;
        }

        public int indexOf(T item) {
            int index = 0;
            var current = front;
            while (current != null) {
                if (current.value == item) return index;
                current = current.next;
                index++;
            }
            return -1;
        }

        public boolean contains(T item) {
            return indexOf(item) != -1;
        }

       // not applicable to current problems just keeping for future
        public void addfront(T item) {
            var node = new Node(item);

            if (isEmpty())
                front = back = node;
            else {
                node.next = front;
                front = node;
            }

            size++;
        }
    // not applicable to current problems just keeping for future
        public void removeback() {
            if (isEmpty())
                throw new NoSuchElementException();

            if (front == back)
                front = back = null;
            else {
                var previous = getPrevious(back);
                back = previous;
                back.next = null;
            }
            size--;
        }

        private Node getPrevious(Node node) {
            var current = front;
            while (current != null) {
                if (current.next == node) return current;
                current = current.next;
            }
            return null;
        }

        public int size() {
            return size;
        }



    }


