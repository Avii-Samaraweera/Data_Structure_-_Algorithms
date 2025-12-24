public class SinglyLinkedList {

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // 1. ADD FIRST (Beginning) - O(1)
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Added First: " + data);
    }

    // 2. REMOVE FIRST (Beginning) - O(1)
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty, cannot remove first.");
            return;
        }
        System.out.println("Removed First: " + head.data);
        head = head.next;
    }

    // 3. ADD LAST (End) - O(N)
    public void addLast(int data) {
        Node newNode = new Node(data);

        // If list is empty, make this the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        System.out.println("Added Last: " + data);
    }

    // 4. REMOVE LAST (End) - O(N)
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty, cannot remove last.");
            return;
        }

        // Special Case: Only one element exists
        if (head.next == null) {
            System.out.println("Removed Last: " + head.data);
            head = null;
            return;
        }

        // Traverse to the *Second to Last* node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        System.out.println("Removed Last: " + current.next.data);
        // Remove the link to the last node
        current.next = null;
    }

    // 5. REMOVE SPECIFIC NODE (by Value) - O(N)
    public void remove(int key) {
        if (head == null) return;

        // Case: The key is at the head
        if (head.data == key) {
            removeFirst();
            return;
        }

        // Traverse to find the node *before* the one we want to delete
        Node current = head;
        while (current.next != null && current.next.data != key) {
            current = current.next;
        }

        // If current.next is not null, we found the key
        if (current.next != null) {
            System.out.println("Removed Specific: " + current.next.data);
            // Skip over the node to be deleted
            current.next = current.next.next;
        } else {
            System.out.println("Element " + key + " not found.");
        }
    }
