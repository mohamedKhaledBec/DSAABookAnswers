package List;

public class Stack {
    private Node top;

    public Stack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public Node peek(){
        return top;
    }

    public void push(Node node){
        node.setNext(top);
        top = node;
    }

    public Node pop(){
        Node topNode = top;
        if (top != null) {
            top = top.getNext();
        }
        return topNode;
    }

    // Ex 6: Multiply last two popped elements (linked list implementation)
    int multiply(){
        if (top == null || top.getNext() == null) return 0;
        int a = pop().getData();
        int b = pop().getData();
        return a * b;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to multiply top two elements
    }

    // Ex 8: Return a copy of the stack (linked list implementation)
    Stack copy(){
        Stack newStack = new Stack();
        Node current = top;
        Stack temp = new Stack();
        while (current != null) {
            temp.push(new Node(current.getData()));
            current = current.getNext();
        }
        while (!temp.isEmpty()) {
            newStack.push(new Node(temp.pop().getData()));
        }
        return newStack;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to copy stack using temporary stack
    }

    // Ex 12: Doubly linked list stack implementation
    static class DoubleStack {
        private DoublyNode head;

        public DoubleStack(){
            head = null;
        }

        boolean isEmpty(){
            return head == null;
        }

        DoublyNode pop(){
            DoublyNode topNode = head;
            if (head != null) {
                head = (DoublyNode) head.next;
                if (head != null) {
                    head.setPrevious(null)  ;
                }
            }
            return topNode;
        }

        void push(DoublyNode newNode){
            newNode.next = head;
            if (head != null) {
                head.setPrevious(newNode);
            }
            newNode.setPrevious(null);
            head = newNode;
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added doubly linked list stack implementation
    }

    // Ex 14: Pop k'th element from top (linked list implementation)
    Node pop(int k){
        if (top == null || k < 1) return null;
        Node current = top;
        Node prev = null;
        for (int i = 1; i < k && current != null; i++) {
            prev = current;
            current = current.getNext();
        }
        if (current == null) return null;
        if (prev == null) {
            top = current.getNext();
        } else {
            prev.setNext(current.getNext());
        }
        return current;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to pop k'th element
    }

    // Ex 16: Push data as k'th element from top (linked list implementation)
    void push(int k, int data){
        if (k < 1) return;
        Node newNode = new Node(data);
        if (k == 1) {
            newNode.setNext(top);
            top = newNode;
            return;
        }
        Node current = top;
        Node prev = null;
        for (int i = 1; i < k && current != null; i++) {
            prev = current;
            current = current.getNext();
        }
        if (prev == null) return;
        newNode.setNext(current);
        prev.setNext(newNode);
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to push data as k'th element
    }

    // Ex 18: Pop k bottom elements and return as LinkedList (fixed)
    LinkedList popBottomK(int k){
        LinkedList list = new LinkedList();
        if (top == null || k < 1) return list;
        Stack temp = new Stack();
        int size = 0;
        Node current = top;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        if (k > size) return list;
        int target = size - k;
        while (!isEmpty()) {
            temp.push(pop());
        }
        current = null;
        Node prev = null;
        int index = 0;
        while (!temp.isEmpty()) {
            Node node = temp.pop();
            if (index >= target) {
                if (list.head == null) {
                    list.head = node;
                } else {
                    prev.setNext(node);
                }
                prev = node;
            } else {
                push(node);
            }
            index++;
        }
        if (prev != null) {
            prev.setNext(null);
            list.tail = prev;
        }
        return list;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed logic to correctly pop k bottom elements and return as LinkedList
    }

    // Ex 20: Add elements from p to q from stack s to top (fixed)
    void addToStack(Stack s, int p, int q){
        Stack temp = s.copy();
        int index = 1;
        while (!temp.isEmpty()) {
            Node node = temp.pop();
            if (index >= p && index <= q) {
                push(new Node(node.getData()));
            }
            index++;
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed logic to add elements in correct order using copy
    }

    // Ex 22: Remove odd-indexed elements (fixed)
    void removeOddIndexed(){
        Stack temp = new Stack();
        int index = 1;
        while (!isEmpty()) {
            temp.push(pop());
        }
        while (!temp.isEmpty()) {
            if (index % 2 == 0) {
                push(temp.pop());
            } else {
                temp.pop();
            }
            index++;
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Simplified logic and fixed stack flipping
    }
}