import java.util.Stack;

public class QueueStackPopFriendly {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation 
    public void enqueue(int x) {

        // Move all elements from stack1 to stack2
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        // Push new element into stack1
        stack1.push(x);

        // Move elements back to stack1
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        System.out.println(x + " enqueued");
    }

    // Dequeue operation 
    public int dequeue() {

        if (stack1.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return stack1.pop();
    }
