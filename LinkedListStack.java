class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListStack {
    private Node top;
    private int size;
    
    // Constructor
    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }
    
    // Push: Add element to the top
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
        System.out.println("Pushed: " + data);
    }
    
    // Pop: Remove and return top element
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Stack is empty.");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        size--;
        return poppedData;
    }
    
    // Peek: View top element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }
    
    // Get size of stack
    public int size() {
        return size;
    }
    
    // Display stack contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
