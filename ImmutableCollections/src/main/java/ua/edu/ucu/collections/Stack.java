package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList content;

    public Stack(){
        this.content = new ImmutableLinkedList();
    }

    public void push(Object e) {
        content = content.addLast(e);
    }

    public Object pop() {
        Object res = peek();
        content = content.removeLast();
        return res;
    }

    public Object peek() {
        return content.getLast();
    }
}
