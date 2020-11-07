import java.util.NoSuchElementException;

public class MyStack<T> {

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

        private Node bottom;
        private Node top;
        private int size;

        public void push (T item) {
            var node = new Node(item);

            if (isEmpty())
                bottom = top = node;
            else {
                top.next = node;
                top = node;
            }

            size++;
        }



        public boolean isEmpty() {
            return bottom == null;
        }

        public T peek() {
            return top.value;
        }

        public T pop() {
            Node peekNode;
            if (isEmpty())
                throw new NoSuchElementException();

            if (top == bottom)
            {peekNode=bottom;
                bottom = top = null;}
            else {
                peekNode=top;
                var previous = getPrevious(top);
                top= previous;
                top.next = null;
            }

            size--;
            return peekNode.value;
        }

        private Node getPrevious(Node node) {
            var current = bottom;
            while (current != null) {
                if (current.next == node) return current;
                current = current.next;
            }
            return null;
        }

        public int size() {
            return size;
        }

        public char[] toArray() {
            char[] array = new char[size];
            var current = bottom;
            var index = 0;
            while (current != null) {
                array[index++] = (char)current.value;
                current = current.next;
            }

            return array;
        }


    }


