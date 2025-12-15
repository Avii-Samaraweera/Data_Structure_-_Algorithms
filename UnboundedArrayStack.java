class UnboundedArrayStack {
    private int[] stack;
    private int top;

    UnboundedArrayStack() {
        stack = new int[2]; // initial size
        top = -1;
    }

    void push(int value) {
        if (top == stack.length - 1)
            resize(stack.length * 2); // double when full

        stack[++top] = value;
    }

    int pop() {
        if (top == -1)
            throw new RuntimeException("Stack is empty");

        return stack[top--]; // no shrinking
    }

    private void resize(int newSize) {
        int[] newStack = new int[newSize];
        for (int i = 0; i <= top; i++)
            newStack[i] = stack[i];
        stack = newStack;
    }

    boolean isEmpty() {
        return top == -1;
    }
}
