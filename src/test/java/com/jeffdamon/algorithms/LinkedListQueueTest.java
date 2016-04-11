package com.jeffdamon.algorithms;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Created by jeff on 4/10/16.
 */
public class LinkedListQueueTest {
    @Test
    public void testQueue() throws Exception {
        LinkedListQueue<Integer> q = new LinkedListQueue<Integer>();
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());

        q.enqueue(21);
        q.enqueue(3);

        assertEquals(2, q.size());
        assertFalse(q.isEmpty());

        assertEquals(new Integer(21), q.dequeue());
        assertEquals(new Integer(3), q.dequeue());
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());
    }

    @Test
    public void testIteration() throws Exception{
        LinkedListQueue<String> q = new LinkedListQueue<String>();
        q.enqueue("Hello");
        q.enqueue("World");

        Iterator<String> i = q.iterator();
        assertTrue(i.hasNext());
        assertEquals("Hello", i.next());
        assertTrue(i.hasNext());
        assertEquals("World", i.next());
        assertFalse(i.hasNext());
    }
}