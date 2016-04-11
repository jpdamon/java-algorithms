package com.jeffdamon.algorithms;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LIFO stack implementation.
 */
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] a = (T[]) new Object[1];
    private int n = 0;

    /**
     * Add an item to the top of the stack.
     *
     * If the backing array is full, it will be doubled in size.
     */
    public void push(T t)
    {
        if(n == a.length) resize(2*a.length);
        a[n++] = t;
    }

    /**
     * Remove and get the last item added to the stack .
     *
     * If the remaining elements use up 1/4 of the array capacity,
     * it's size will be halved.
     */
    public T pop()
    {
        T t = a[--n];
        a[n] = null; // Remove reference for GC
        if(n > 0 && n == a.length/4) resize(a.length/2);
        return t;
    }

    /** True if stack contains no items **/
    public boolean isEmpty()
    {
        return n == 0;
    }

    /** Returns an iterator from the last element of the stack to the first. **/
    public Iterator<T> iterator()
    {
        return new ReverseArrayIterator();
    }

    /** Copy backing array to new array of given capacity **/
    private void resize(int capacity)
    {
        T[] temp = (T[])new Object[capacity];
        for(int i = 0; i < n; i++)
        {
            temp[i] = a[i];
        }

        a = temp;
    }

    private class ReverseArrayIterator implements Iterator<T>
    {
        private int i = n;

        public boolean hasNext(){return i > 0;}

        public T next()
        {
            if(--i < 0) throw new NoSuchElementException();
            return a[i];
        }

        public void remove(){
            // Not implemented
            throw new UnsupportedOperationException();
        }
    }

}
