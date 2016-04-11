package com.jeffdamon.algorithms;

import java.util.Iterator;

/**
 * LIFO stack implemented using a singly-linked list.
 */
public class LinkedListStack<T>  implements  Iterable<T>{
    private Node first = null;
    private int size;

    /** Push a new item onto the stack **/
    public void push(T item)
    {
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
        size++;
    }

    /** Get and remove the last item added to the stack **/
    public T pop()
    {
        T t = first.item;
        first = first.next;
        size--;
        return t;
    }

    /** True if stack is empty **/
    public boolean isEmpty()
    {
        return first == null;
    }

    /** Items in the stack **/
    public int size()
    {
        return size;
    }

    /** Returns an iterator from the last item added to the stack to the first **/
    public Iterator<T> iterator()
    {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T>
    {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            // not implemented
            throw new UnsupportedOperationException();
        }
    }

    private class Node
    {
        T item;
        Node next;
    }
}
