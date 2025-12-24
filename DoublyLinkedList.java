public class DoublyLinkedList {

    private class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail; // Keeps track of the end for O(1) operations

    // 1. ADD FIRST - O(1)
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Added First: " + data);
    }

    // 2. ADD LAST - O(1)
    public void addLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; // Update tail reference
        }
        System.out.println("Added Last: " + data);
    }

    // 3. REMOVE FIRST - O(1)
    public void removeFirst() {
        if (head == null) return;

        System.out.println("Removed First: " + head.data);

        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null; // Clean up the back reference
        }
    }

    // 4. REMOVE LAST - O(1)
    public void removeLast() {
        if (tail == null) return;

        System.out.println("Removed Last: " + tail.data);

        if (head == tail) { // Only one element
            head = null;
            tail = null;
        } else {
            tail = tail.prev; // Move tail back one step
            tail.next = null; // Remove the link to the old last node
        }
    }

    // 5. REMOVE SPECIFIC - O(N)
    public void remove(int key) {
        if (head == null) return;

        Node current = head;

        // Search for the node
        while (current != null && current.data != key) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element " + key + " not found.");
            return;
        }

        // Case 1: Removing the head
        if (current == head) {
            removeFirst();
            return;
        }

        // Case 2: Removing the tail
        if (current == tail) {
            removeLast();
            return;
        }

        // Case 3: Removing a middle node
        // We link the previous node directly to the next node
        current.prev.next = current.next;
        current.next.prev = current.prev;
        System.out.println("Removed Specific: " + key);
    }
