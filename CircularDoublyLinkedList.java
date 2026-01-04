class Node {
    int data;
    Node next;
    Node prev;
    
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class CircularDoublyLinkedList {
    private Node head;
    
    // Insert at the beginning
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;
            
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
    }
    
    // Insert at the end
    public void insertLast(int data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            newNode.next = newNode;
            newNode.prev = newNode;
            head = newNode;
        } else {
            Node tail = head.prev;
            
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
        }
    }
    
    // Insert at specific position (0-indexed)
    public void insertAt(int data, int position) {
        if (position == 0) {
            insertFirst(data);
            return;
        }
        
        if (head == null) {
            System.out.println("List is empty. Cannot insert at position " + position);
            return;
        }
        
        Node current = head;
        int count = 0;
        
        do {
            if (count == position - 1) {
                Node newNode = new Node(data);
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
                return;
            }
            current = current.next;
            count++;
        } while (current != head);
        
        System.out.println("Position " + position + " is out of bounds");
    }
    
    // Delete first node
    public void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }
    
    // Delete last node
    public void deleteLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            Node newTail = tail.prev;
            newTail.next = head;
            head.prev = newTail;
        }
    }
    
    // Delete node at specific position (0-indexed)
    public void deleteAt(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        if (position == 0) {
            deleteFirst();
            return;
        }
        
        Node current = head;
        int count = 0;
        
        do {
            if (count == position) {
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return;
            }
            current = current.next;
            count++;
        } while (current != head);
        
        System.out.println("Position " + position + " is out of bounds");
    }
    
    // Delete node by value (first occurrence)
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        
        do {
            if (current.data == value) {
                if (current == head && current.next == head) {
                    head = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current == head) {
                        head = current.next;
                    }
                }
                return;
            }
            current = current.next;
        } while (current != head);
        
        System.out.println("Value " + value + " not found");
    }
