
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListFIFOQueue {
    private Node front;
    private Node rear;
    private int size;
    
    // Constructor
    public LinkedListFIFOQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }
    
    // Enqueue: Add element to the rear
    public void enqueue(int data) {
        Node newNode = new Node(data);
        
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + data);
    }
    
    // Dequeue: Remove and return front element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Queue is empty.");
            return -1;
        }
        
        int dequeuedData = front.data;
        front = front.next;
        
        // If queue becomes empty, set rear to null too
        if (front == null) {
            rear = null;
        }
        
        size--;
        return dequeuedData;
    }
    
    // Peek/Front: View front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return front.data;
    }
    
    // Get rear element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return rear.data;
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }
    
    // Get size of queue
    public int size() {
        return size;
    }
    
    // Display queue contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" <- ");
            }
            current = current.next;
        }
        System.out.println();
    }
