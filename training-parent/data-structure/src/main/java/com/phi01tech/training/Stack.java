package com.phi01tech.training;

public class Stack {
    private final int capacity;
    private final Object[] values;
    private int top = 0;
    private final State behavior;

    public Stack(int capacity) {
        if (!isValidCapacity(capacity))
            throw new IllegalArgumentException("minus capacity [" + capacity + "]");
        // 0 capacity (unmodifiable)
        // with capacity (modifiable)
        // to set the behavior of the stack on construction
        this.capacity = capacity;
        values = new Object[this.capacity];
        this.behavior = capacity == 0 ? new UnmodifiableState() : new ModifiableState();
    }

    public int capacity() {
        return capacity;
    }

    public int size() {
        return top;
    }

    public Object pop() {
        return behavior.pop();
    }

    public void push(Object value) {
        this.behavior.push(value);
    }

    private boolean isEmpty() {
        return top == 0;
    }

    private boolean isFull() {
        return top == capacity;
    }

    private boolean isValidCapacity(int capacity) {
        return capacity >= 0;
    }

    private interface State {

        Object pop();

        void push(Object value);
    }

    private class UnmodifiableState implements State {

        @Override
        public Object pop() {
            throw new UnmodifiableStackException();
        }

        @Override
        public void push(Object value) {
            throw new UnmodifiableStackException();
        }
    }

    private class ModifiableState implements State {

        @Override
        public Object pop() {
            if (isEmpty())
                throw new EmptyStackException();
            return Stack.this.values[--top];
        }

        @Override
        public void push(Object value) {
            if (isFull())
                throw new FullStackException();
            Stack.this.values[top++] = value;
        }
    }
}
