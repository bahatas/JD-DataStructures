import java.util.NoSuchElementException;

public class MyQueue<T> {

        private class Node {
            private T value;
            private Node next;

            public T getValue() {
                return value;
            }

            public void setValue(T value) {
                this.value = value;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }

            public Node(T value) {
                this.value = value;
            }
        }

        private Node front;
        private Node back;
        private int size;

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

            if (front == back)
            {t=front.value;
                front = back = null;}
            else {
                t=front.value;
                var second = front.next;
                front.next = null;
                front = second;
            }

            size--;return t;
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


