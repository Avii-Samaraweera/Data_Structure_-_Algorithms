import java.util.Stack;

public class StackQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public StackQueue() {
        s1 = new Stack<>(); // create stack 01
        s2 = new Stack<>(); // create stack 02
    }

    //ENQUEUE OPERATION
    public void enqueue(int x) {
        
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        } //pop elements from s1 and push all of them to s2 until s1 get empty

        //after s1 empty, push new element to s1
        s1.push(x);

        //Then pop all elements from s2 and push them back to s1 until s2 get empty
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        
        System.out.println("Enqueued: " + x);
    }

    //DEQUEUE OPERATION
    public int dequeue() {
        //Exception to check S1 is empty. because if s1 is empty nothing to remove
        if (s1.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int removed = s1.pop();
        return removed;
    }

    // PEEK OPERATION
    public int peek() {
      //Exception - if the S1 is empty nothing to see
        if (s1.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return s1.peek();
    }

  //IS EMPTY OPERATION
    public boolean isEmpty() {
        return s1.isEmpty();
    }
