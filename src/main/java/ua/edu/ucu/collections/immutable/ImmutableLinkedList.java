package ua.edu.ucu.collections.immutable;


import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private final Node tail;
    private final Node head;
    private final int size;

    public ImmutableLinkedList(Object[] elements) {
        size = elements.length;
        if (size == 0) {
            tail = null;
            head = null;
        } else {
            tail = new Node(elements[0]);
            Node last = tail;
            if (elements.length > 1) {
                Node prev = tail;
                for (int i = 1; i < elements.length; i++) {
                    Node curr = new Node(prev, elements[i]);
                    last = curr;
                    prev.setNext(curr);
                    prev = curr;
                }
            }
            head = last;
        }
    }

    public ImmutableLinkedList() {
        size = 0;
        tail = null;
        head = null;
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] res = new Object[size + 1];
        Node curr = tail;
        for (int i = 0; i < size; i++) {
            res[i] = curr.getValue();
            curr = curr.getNext();
        }
        res[size] = e;
        return new ImmutableLinkedList(res);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] res = new Object[size + 1];
        Node curr = tail;
        res[index] = e;
        for (int i = 0; i < size + 1; i++) {
            if (i != index) {
                res[i] = curr.getValue();
                curr = curr.getNext();
            }
            if (curr == null) {
                break;
            }
        }
        return new ImmutableLinkedList(res);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] res = new Object[size + c.length];
        Node curr = tail;
        for (int i = 0; i < size + c.length; i++) {
            res[i] = curr.getValue();
            curr = curr.getNext();
            if (curr == null) {
                break;
            }
        }
        for (int z = 0; z < c.length; z++) {
            res[size + z] = c[z];
        }
        return new ImmutableLinkedList(res);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] res = new Object[size + c.length];
        Node curr = tail;
        int z = 0;
        for (int i = 0; i < size + c.length; i++) {
            if (i != index) {
                res[i + z] = curr.getValue();
                curr = curr.getNext();
            } else {
                for (; z < c.length; z++) {
                    res[i + z] = c[z];
                }
            }
        }
        return new ImmutableLinkedList(res);
    }

    @Override
    public Object get(int index) {
        Node curr = tail;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return curr.getValue();
            }
        }
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        Node curr = tail;
        Object[] res = new Object[size - 1];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i != index) {
                res[j] = curr.getValue();
                j += 1;
            }
            curr = curr.getNext();
        }
        return new ImmutableLinkedList(res);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        Node curr = tail;
        Object[] res = new Object[size];
        for (int i = 0; i < size; i++) {
            if (i != index) {
                res[i] = curr.getValue();
            } else {
                res[i] = e;
            }
            curr = curr.getNext();
        }
        return new ImmutableLinkedList(res);
    }

    @Override
    public int indexOf(Object e) {
        Node curr = tail;
        for (int i = 0; i < size; i++) {
            if (curr.getValue() == e) {
                return i;
            }
            curr = curr.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] res = new Object[size];
        Node curr = tail;
        for (int i = 0; i < size; i++) {
            res[i] = curr.getValue();
            curr = curr.getNext();
        }
        return res;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return (ImmutableLinkedList) this.add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) this.add(size, e);

    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return tail.getValue();
    }

    public Object getLast() {
        return head.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove(size - 1);
    }
}
