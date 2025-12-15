import java.util.Stack;

//use two Stacks to push and pop 
class QueueUsingStack {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Enqueue- push friendly, easy to enqueue
    void enqueue(int x) {
        s1.push(x);
    }

    // Dequeue- hard to dequeue
    int dequeue() { 
        if (s2.isEmpty()) { // check s2 is empty  
            while (!s1.isEmpty()) { 
                s2.push(s1.pop());
            //pop from s1 and push it to s2 until s1 is empty 
            }
        }
        return s2.pop(); 
    }
}
