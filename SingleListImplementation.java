package todo;

public class SingleListImplementation {
    
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static class LinkedList {
        Node head;

        // 1. Inserting a Node at Any Given Position
        public void insertAtPostion(int data, int position) {
            Node newNode = new Node(data);
            if (position == 1) {
                newNode.next = head;
                head = newNode;
                return;
            }
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("Out of range");
                return;
            }
            newNode.next = current.next;
            current.next = newNode;
        }

        // 2. Deleting a Node at Any Given Position 
        public void deleteAtPosition(int position) {
            if (head == null) {
                System.out.println("empty list");
                return;
            }
            if (position == 1) {
                head = head.next;
                return;
            }
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null || current.next == null) {
                System.out.println("Out of range");
                return;
            }
            current.next = current.next.next;
        }

        // 3. Deleting a Node After a Given Node 
        public void deleteAfterNode(int data) {
            if (head == null || head.next == null) {
                System.out.println("List is either empty or has only one node inside it ");
                return;
            }
            Node current = head;
            while (current.data != data && current.next != null) {
                current = current.next;
            }
            if (current.next == null) {
                System.out.println("Node with value " + data + " not found");
                return;
            }
            current.next = current.next.next;
        }

        // 4. Searching a Node 
        public boolean searchNode(int data) {
            Node current = head;
            while (current != null) {
                if (current.data == data) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        // 5. Implementing Stack Using Linked List
        static class Stack {
            Node top;

            void push(int data) {
                Node newNode = new Node(data);
                newNode.next = top;
                top = newNode;
            }

            int pop() {
                if (top == null) {
                    System.out.println("Stack is empty");
                    return -1;
                }
                int data = top.data;
                top = top.next;
                return data;
            }

            int peek() {
                if (top == null) {
                    System.out.println("Stack is empty");
                    return -1;
                }
                return top.data;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtPostion(1, 1);
        list.insertAtPostion(2, 2);
        list.insertAtPostion(3, 1);
        list.deleteAtPosition(2);
        list.deleteAfterNode(2);
        System.out.println("Searching for node with value of 1: " + list.searchNode(1));
        LinkedList.Stack stack = new LinkedList.Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("trying to peek " + stack.peek());
        System.out.println("Popping the stack " + stack.pop());
        System.out.println("trying to peek " + stack.peek());
    }
}