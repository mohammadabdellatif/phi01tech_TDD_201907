package com.phi01tech.training;

public class Stack {
    private final int capacity;

    public Stack(int capacity) {
        if (!isValidCapacity(capacity))
            throw new IllegalArgumentException("minus capacity [" + capacity + "]");
        this.capacity = capacity;
    }


    public int capacity() {
        return capacity;
    }

    public int size() {
        return 0;
    }

    private boolean isValidCapacity(int capacity) {
        return capacity >= 0;
    }

    public Object pop() {
        return null;
    }

    public void push(Object value) {

    }
}
