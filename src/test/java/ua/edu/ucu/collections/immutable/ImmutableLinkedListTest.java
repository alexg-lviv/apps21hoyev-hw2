package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList list;
    private Object[] arr;

    @Before
    public void setUp() {
        list = new ImmutableLinkedList(new Object[]{1, 2, 3});
        arr = new Object[]{1, 2};
    }

    @Test
    public void testAdd() {
        assertArrayEquals(new Object[]{1, 2, 3, 4}, list.add(4).toArray());
    }

    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[]{1, 2, 3, 1, 2}, list.addAll(arr).toArray());
    }

    @Test
    public void testGet() {
        assertEquals(1, list.get(0));
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{1, 2}, list.remove(2).toArray());
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Object[]{1, 2, 4}, list.set(2, 4).toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(2, list.indexOf(3));
    }

    @Test
    public void testSize() {
        assertEquals(3, list.size());
    }

    @Test
    public void testClear() {
        assertArrayEquals(new Object[]{}, list.clear().toArray());
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true, list.clear().isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Object[]{1, 2, 3}, list.toArray());
    }

    @Test
    public void testAddFirst() {
        assertArrayEquals(new Object[]{5, 1, 2, 3}, list.addFirst(5).toArray());
    }

    @Test
    public void testAddLast() {
        assertArrayEquals(new Object[]{1, 2, 3, 5}, list.addLast(5).toArray());
    }

    @Test
    public void testGetHead() {
        assertEquals(3, list.getHead().getValue());
    }

    @Test
    public void testGetTail() {
        assertEquals(1, list.getTail().getValue());
    }

    @Test
    public void testGetFirst() {
        assertEquals(1, list.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(3, list.getLast());
    }

    @Test
    public void testRemoveFirst() {
        assertArrayEquals(new Object[]{2, 3}, list.removeFirst().toArray());
    }

    @Test
    public void testRemoveLast() {
        assertArrayEquals(new Object[]{1, 2}, list.removeLast().toArray());
    }
}