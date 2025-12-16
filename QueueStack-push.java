import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    
    public QueueStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push operation - O(1) time complexity
    public void push(int x) {
        q1.add(x);
    }
    
    // Pop operation - O(n) time complexity
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        // Move all elements except last from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        
        // Get the last element (top of stack)
        int top = q1.remove();
        
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return top;
    }
    
    // Peek operation - O(n) time complexity
    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        
        // Move all elements except last from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        
        // Get the last element without removing
        int top = q1.peek();
        q2.add(q1.remove());
        
        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return top;
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
    
    // Get size of stack
    public int size() {
        return q1.size();
    }
    
    // Display all elements
    public void display() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Stack elements (bottom to top): " + q1);
    }
}
