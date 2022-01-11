
package synthesizer;
import java.nio.Buffer;
import java.util.Iterator;


public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {

        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[])new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
         if (isFull()){
             throw new IllegalArgumentException("Ring buffer overflow");
         }else{
         rb[last] = x;
         last ++;
         fillCount ++;
         if (last == capacity){
             last = 0;
         }
         }
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (fillCount == 0){
            throw new RuntimeException("Ring buffer underflow");
        }
        T delated = rb[first];
        rb[first] = null;
        first ++;
        fillCount --;
        if (first == capacity){
            first = 0;
        }
        return delated;
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update 
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }else {
        return rb[first];
        }
        // TODO: Return the first item. None of your instance variables should change.
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    public Iterator<T> iterator(){
        return new BufferIterator();
    }
    private class BufferIterator implements Iterator<T>{
            private int pos;

            public BufferIterator() {
                pos = 0;
            }

            public boolean hasNext() {
                return pos < fillCount;
            }

            public T next() {
                T item = rb[pos];
                pos++;
                return item;
            }
        }

}
