import java.util.Stack;

public class StackQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    public StackQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    // Enqueue operation - O(1) time complexity
    public void enqueue(int x) {
        s1.push(x);
    }
    
    // Dequeue operation - O(n) worst case, O(1) amortized
    public int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        // If s2 is empty, transfer all elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        
        return s2.pop();
    }
    
    // Peek operation - O(n) worst case, O(1) amortized
    public int peek() {
        if (s1.isEmpty() && s2.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        
        // If s2 is empty, transfer all elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        
        return s2.peek();
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
    // Get size of queue
    public int size() {
        return s1.size() + s2.size();
    }
    
    // Display all elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Queue elements - s2 (front): " + s2 + " | s1 (back): " + s1);
    }
}
