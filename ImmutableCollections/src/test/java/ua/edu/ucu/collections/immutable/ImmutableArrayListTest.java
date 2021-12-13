package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ImmutableArrayListTest{
    private ImmutableArrayList list;
    private Object[] arr;
    @Before
    public void setUp() {
        list = new ImmutableArrayList(new Object[]{1, 2, 3, 4});
        arr = new Object[]{1, 2};
    }

    @Test
    public void testAdd() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 5}, list.add(5).toArray());
    }
    @Test
    public void testTestAdd() {
        list = new ImmutableArrayList();
        assertArrayEquals(new Object[]{5}, list.add(5).toArray());
    }
    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[]{1, 2, 3, 4, 1, 2}, list.addAll(arr).toArray());
    }
    @Test
    public void testTestAddAll() {
        list = new ImmutableArrayList(new Object[]{});
        assertArrayEquals(new Object[]{1, 2}, list.addAll(arr).toArray());
    }
    @Test
    public void testGet() {
        assertEquals(2, list.get(1));
    }
    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{1, 2, 3}, list.remove(3).toArray());
    }
    @Test
    public void testSet() {
        assertArrayEquals(new Object[]{1, 2, 3, 3}, list.set(3, 3).toArray());
    }
    @Test
    public void testIndexOf() {
        assertEquals(2, list.indexOf(3));
    }
    @Test
    public void testSize() {
        assertEquals(4, list.size());
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
        assertArrayEquals(new Object[]{1, 2, 3, 4}, list.toArray());
    }
}