package ua.edu.ucu.collections.immutable;

public class Node {
    private Node previous;
    private Node next;
    private Object value;

    public Node() {
    }

    public Node(Node previous, Node next, Object value) {
        this.previous = previous;
        this.next = next;
        this.value = value;
    }

    public Node(Node previous, Object value) {
        this.previous = previous;
        this.value = value;
    }

    public Node(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }


    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node prev) {
        previous = prev;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object val) {
        value = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node ne) {
        next = ne;
    }
}

