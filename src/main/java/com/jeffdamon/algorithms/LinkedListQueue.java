package com.jeffdamon.algorithms;

import java.util.Iterator;

/**
 * Created by jeff on 4/10/16.
 */
public class LinkedListQueue<T> implements Iterable<T> {
    private Node front = null;
    private Node end = null;
    private int size;

    /** Add an item to the end of the queue **/
    public void enqueue(T item)
    {
        Node old = end;
        end = new Node();
        end.item = item;
        end.next = null;
        if(isEmpty())
        {
            front = end;
        }
        else
        {
            old.next = end;
        }

        size++;
    }

    /** Remove the item at the front of the queue **/
    public T dequeue()
    {
        T item = front.item;
        front = front.next;
        size--;
        if(isEmpty())
        {
            end = null;
        }

        return item;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return front == null;
    }

    public Iterator<T> iterator()
    {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<T>
    {
        private Node current = front;
        public boolean hasNext()
        {
            return current != null;
        }

        public T next()
        {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void  remove()
        {
            // Not implemented
            throw new UnsupportedOperationException();
        }
    }

    private class Node{
        T item;
        Node next;
    }

}
