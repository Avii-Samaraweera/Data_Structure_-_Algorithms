import java.util.LinkedList;
import java.util.Queue;

class StackQueue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    void push(int x) {
        q1.add(x); // enqueue-friendly
    }

    int pop() {
        if (q1.isEmpty()) return -1;

        while (q1.size() > 1) {
            q2.add(q1.poll());
        }

        int val = q1.poll();

        // swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return val;
    }

    boolean isEmpty() {
        return q1.isEmpty();
    }
}
