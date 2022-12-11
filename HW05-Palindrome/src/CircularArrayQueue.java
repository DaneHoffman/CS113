package src;



import java.util.*;

/**
 * CircularArrayQueue: Stores data using the abstract data type of a queue, implements all the methods
 * of the java.util.Queue class
 *
 * @param <E> data type of elements to be stored in the arrayList
 *
 */
public class CircularArrayQueue<E> implements Queue {




    /**
     * Initializes an array using the abstract data type queue.
     *
     * @param maxSize the size of the array
     */



    /**
     * Inserts the specified element into this queue if it is possible to do
     * so immediately without violating capacity restrictions.
     * When using a capacity-restricted queue, this method is generally
     * preferable to {@link #add}, which can fail to insert an element only
     * by throwing an exception.
     *
     * @param o the element to add
     * @return {@code true} if the element was added to this queue, else
     *         {@code false}
     * @throws NullPointerException if the specified element is null.
     */



    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning
     * {@code true} upon success and throwing an {@code IllegalStateException}
     * if no space is currently available.
     *
     * @param o the element to add
     * @return {@code true} (as specified by {@link Collection#add})
     * @throws IllegalStateException if the element cannot be added at this
     *         time due to capacity restrictions
     */




    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */



    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll() poll()} only in that it throws an exception if
     * this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */



    /**
     * Retrieves, but does not remove, the head of this queue.  This method
     * differs from {@link #peek peek} only in that it throws an exception
     * if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */


    /**
     * Returns the element at the head of the queue. Returns null if
     * the queue is empty.
     *
     * @return element at the head of the queue.
     */


    /**
     * Helper method that creates an array twice the size of the
     * original array.
     */







    /**
     * The following methods were inherited from java.util.Collectoins and
     * were not implemented in this homework assignment.
     * size(), isEmpty(), contatins(Object o), iterator(), toArray(), toAarray(Object[] a), remove(Object o), addAll(Collection c), clear(), retainAll(Collection c), removeAll(Collection c), containsAll(Collection c)
     */

}
