package chapterOne.sectionThree;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * FIFO Queue
 */
public class ResizingArrayQueueOfStrings<Item> implements Iterable {
    // initial capacity of underlying resizing array
    private static final int INIT_CAPACITY = 8;

    private Item[] q;       // queue elements
    private int n;          // number of elements on queue
    private int first;      // index of first element of queue
    private int last;       // index of next available slot

    /**
     * Initializes an empty queue.
     */
    public ResizingArrayQueueOfStrings() {
        //Type cast the object array collection into the generic data type specified for the collection instance
        q = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
        first = 0;
        last = 0;
    }

    /**
     * Is this queue empty?
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this queue.
     * @return the number of items in this queue
     */
    public int size() {
        return n;
    }

    // resize the underlying array
    private void resize(int capacity) {
        //Ensure the new capacity will accommodate all existing elements
        assert capacity >= n;
        Item[] copy = (Item[]) new Object[capacity];
        
        //Only iterate the number of elements in the array, regardless of capacity. Reducing unnecessary iteration
        for (int i = 0; i < n; i++) {
            //We begin at the first index and proceed from there.
            //If the q'th iteration is beyond the array length then we go to the 0'th index and continue iteration until iterating n times.
            copy[i] = q[(first + i) % q.length];
        }
        //Copy local collection to the new resized collection.
        q = copy;
        //First is reset to the 0th index again since the first element we copied was at the "first" index.
        first = 0;
        last  = n;
    }

    /**
     * Adds the item to this queue.
     * Always enqueue starting from the "last" index, preserving the continuity of the enqueued items 
     * @param item the item to add
     */
    public void enqueue(Item item) {
        // double size of array if necessary and recopy to front of array
        if (n == q.length) resize(2*q.length);   // double size of array if necessary
        q[last++] = item;                        // add item after the previous last index, then increment last
        if (last == q.length) last = 0;          
        // wrap-around; set last to the beginning  of the array if the "last" index is at the end of the array
        n++; //increment collection item count
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * @return the item on this queue that was least recently added
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        Item item = q[first];
        q[first] = null;                            // to avoid loitering
        n--;
        first++;
        //If we dequeued the last element in the array, then wrap around and make the first element the "first"
        if (first == q.length) first = 0;           // wrap-around
        // shrink size of array if necessary
        if (n > 0 && n == q.length/4) resize(q.length/2);
        return item;
    }

    /**
     * Returns the item least recently added to this queue.
     * @return the item least recently added to this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        return q[first];
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * @return an iterator that iterates over the items in this queue in FIFO order.
     */
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    // an array iterator, from first to last-1
    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            //Return 
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }

    }

   /**
     * Unit tests the {@code ResizingArrayQueue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings<String> queue = new ResizingArrayQueueOfStrings<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
