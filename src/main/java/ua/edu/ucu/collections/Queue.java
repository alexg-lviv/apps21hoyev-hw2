package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList content;

    public Queue() {
        this.content = new ImmutableLinkedList();
    }

    public Object peek() {
        return content.getFirst();
    }

    public Object dequeue() {
        Object first = peek();
        content = content.removeFirst();
        return first;
    }

    public void enqueue(Object e) {
        content = content.addLast(e);
    }
}
