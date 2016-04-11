package com.jeffdamon.algorithms;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by jeff on 4/10/16.
 */
public class LinkedListStackTest {
    @Test
    public void testStack() throws Exception {
        LinkedListStack<Integer> q = new LinkedListStack<Integer>();
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());

        q.push(21);
        q.push(3);

        assertEquals(2, q.size());
        assertFalse(q.isEmpty());

        assertEquals(new Integer(3), q.pop());
        assertEquals(new Integer(21), q.pop());
        assertEquals(0, q.size());
        assertTrue(q.isEmpty());
    }

    @Test
    public void testIteration() throws Exception{
        LinkedListStack<String> q = new LinkedListStack<String>();
        q.push("Hello");
        q.push("World");

        Iterator<String> i = q.iterator();
        assertTrue(i.hasNext());
        assertEquals("World", i.next());
        assertTrue(i.hasNext());
        assertEquals("Hello", i.next());
        assertFalse(i.hasNext());
    }
}
