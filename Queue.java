import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;

    private class Node {
        Item item;
        Node next;
    }

    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (first == null) {  // If the queue was empty, update both first and last
            first = last;
        } else {
            oldLast.next = last;  // Link the old last node to the new last node
        }
    }

    public Item dequeue() {
        if (first == null) {  // Handle case where queue is empty
            throw new RuntimeException("Queue underflow");
        }

        Item item = first.item;
        first = first.next;

        if (first == null) {  // If queue becomes empty, set last to null
            last = null;
        }

        return item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new RuntimeException("No more elements");
            }

            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            // Optional, not implemented
        }
    }
}
