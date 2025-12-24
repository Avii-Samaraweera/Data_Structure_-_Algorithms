public class CircularQueue {
    private int[] arr; //create a empty array
    private int front; //create front of the queue
    private int rear; //create rear of the queue
    private int capacity; // size of the array

  //constructor
    public CircularQueue(int size) {
        this.capacity = size; //give a size
        this.arr = new int[capacity]; // define a array
        this.front = -1; // define front
        this.rear = -1; // define rear
      // the array is empty, thats why front and rear got same value
    }

    // Check if the queue is full
    public boolean isFull() {
        // This is a circular one, if rear position + 1 = front position means, array is full
        return (rear + 1) % capacity == front;
      // % is modulas division. example - 10%3 = 1, 10%4 = 2
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1;
      // front is -1 means no elements in the queue, means empty
    }

    // Enqueue: Add element to the rear
    public void enqueue(int x) {
      // if queue full can not add new elements, so first check
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + x);
            return;
        }

        // If queue is empty front and rear goes from -1 to 0. beacause only one element in queue after insert a element to emplty qeue and start and end are same
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            // If array is not empty increase the rear value by one and devide it by size, because of the circular factor
            rear = (rear + 1) % capacity;
        }

      // next add the value to rear element
        arr[rear] = x;
        System.out.println("Enqueued: " + x);
    }

    // Dequeue: Remove element from the front
    public int dequeue() {
      //if the queue is empty nothing to remove
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue.");
            return -1;
        }

        int data = arr[front];

        // Front = rear means there is only one element in queue. so simply 
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            // increase the front by 1 to remove the element from the queue
            front = (front + 1) % capacity;
        }

        return data;
    }

    // Peek: Get the front element without removing it
    public int peek() {
      //if the queue empty, nothing to see
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
      // else show the first element of array 
        return arr[front];
    }
