package List;

public class DoublyLinkedList extends LinkedList {
    public void insertLast(DoublyNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        newNode.setPrevious((DoublyNode) tail);
        tail = newNode;
    }

    public void deleteLast() {
        tail = ((DoublyNode) tail).getPrevious();
        if (tail != null) {
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    @Override
    public DoublyNode getHead() {
        return (DoublyNode) this.head;
    }

    public DoublyNode getTail() {
        return (DoublyNode) this.tail;
    }

    public void setHead(DoublyNode newNode) {
        this.head = newNode;
    }

    public void setTail(DoublyNode newNode) {
        this.tail = newNode;
    }

    // 2.9 Exercise 8: Find the middle node of a doubly linked list
    // [AI Answer]
    DoublyNode middle() {
        if (head == null) return null;
        DoublyNode slow = (DoublyNode) head;
        DoublyNode fast = (DoublyNode) head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    // 2.9 Exercise 14: Double each node in the list
    // [AI Answer]
    void doubleList() {
        DoublyNode current = (DoublyNode) head;
        while (current != null) {
            DoublyNode newNode = new DoublyNode(current.getData());
            newNode.setNext(current.getNext());
            newNode.setPrevious(current);
            if (current.getNext() != null) {
                current.getNext().setPrevious(newNode);
            } else {
                tail = newNode;
            }
            current.setNext(newNode);
            current = newNode.getNext();
        }
    }

    // 2.10 Problem 3: Cut and paste part of the list
    // [Mohamed Khaled Becetti solved and AI corrected]
    void cutPaste(DoublyNode first, DoublyNode last, DoublyNode paste) {
        if (first == null || last == null || paste == null) return;
        if (first.getPrevious() != null) {
            first.getPrevious().setNext(last.getNext());
        } else {
            head = last.getNext();
        }
        if (last.getNext() != null) {
            last.getNext().setPrevious(first.getPrevious());
        } else {
            tail = first.getPrevious();
        }
        last.setNext(paste.getNext());
        if (paste.getNext() != null) {
            paste.getNext().setPrevious(last);
        } else {
            tail = last;
        }
        paste.setNext(first);
        first.setPrevious(paste);
    }
    // Feedback: Original didn’t update head/tail correctly. Corrected to handle all cases.

    // 2.10 Problem 16: Return even-indexed nodes as new list
    // [Mohamed Khaled Becetti's Answer]
    DoublyLinkedList getEvenOnes() {
        DoublyLinkedList resultList = new DoublyLinkedList();
        int index = 1;
        DoublyNode current = (DoublyNode) head;
        while (current != null) {
            if (index % 2 == 0) {
                DoublyNode newNode = new DoublyNode(current.getData());
                if (resultList.getHead() == null) {
                    resultList.setHead(newNode);
                } else {
                    resultList.getTail().setNext(newNode);
                    newNode.setPrevious(resultList.getTail());
                }
                resultList.setTail(newNode);
            }
            index++;
            current = current.getNext();
        }
        return resultList;
    }
    // Feedback: Correct but could explicitly handle empty list. No correction needed.

    // 2.10 Problem 20: Sort elements in a new doubly linked list
    // [Mohamed Khaled Becetti solved and AI corrected]
    DoublyLinkedList sortElements() {
        DoublyLinkedList sortedList = new DoublyLinkedList();
        if (head == null) return sortedList;
        DoublyNode p1 = (DoublyNode) head;
        int max = p1.getData();
        while (p1 != null) {
            if (p1.getData() > max) max = p1.getData();
            p1 = p1.getNext();
        }
        for (int i = 1; i <= max; i++) {
            p1 = (DoublyNode) head;
            int count = 0;
            while (p1 != null) {
                if (p1.getData() == i) count++;
                p1 = p1.getNext();
            }
            for (int j = 0; j < count; j++) {
                DoublyNode newNode = new DoublyNode(i);
                if (sortedList.getHead() == null) {
                    sortedList.setHead(newNode);
                    sortedList.setTail(newNode);
                } else {
                    sortedList.getTail().setNext(newNode);
                    newNode.setPrevious(sortedList.getTail());
                    sortedList.setTail(newNode);
                }
            }
        }
        return sortedList;
    }
    // Feedback: Original was overly complex and inefficient. Simplified to count and insert in order.

    // 2.10 Problem 23: Check if the list is a palindrome
    // [Mohamed Khaled Becetti's Answer]
    boolean isPalindrome() {
        DoublyNode p1 = (DoublyNode) head;
        DoublyNode p2 = (DoublyNode) tail;
        while (p1 != p2 && p1.getNext() != p2) {
            if (p1.getData() == p2.getData()) {
                p1 = p1.getNext();
                p2 = p2.getPrevious();
            } else {
                return false;
            }
        }
        return true;
    }
    // Feedback: Correct and matches book requirement perfectly.

    // 2.10 Problem 27: Remove k'th element from the end
    // [Mohamed Khaled Becetti's Answer]
    void removeKthBeforeLast(int k) {
        DoublyNode current = (DoublyNode) tail;
        for (int i = k; i > 1; i--) {
            current = current.getPrevious();
        }
        if (current.getNext() == null) {
            current.getPrevious().setNext(null);
            setTail(current.getPrevious());
        } else if (current.getPrevious() == null) {
            current.getNext().setPrevious(null);
            setHead(current.getNext());
        } else {
            current.getNext().setPrevious(current.getPrevious());
            current.getPrevious().setNext(current.getNext());
        }
    }
    // Feedback: Correct and handles edge cases well. No correction needed.

    // 2.10 Problem 30: Reverse the doubly linked list
    // [Mohamed Khaled Becetti's Answer]
    void reverse() {
        DoublyNode current = (DoublyNode) head;
        DoublyNode tmp = null;
        while (current != null) {
            tmp = current.getNext();
            current.setNext(current.getPrevious());
            current.setPrevious(tmp);
            current = tmp;
        }
        tmp = (DoublyNode) head;
        setHead((DoublyNode) tail);
        setTail((DoublyNode) tmp);
    }
    // Feedback: Correct and efficient. No correction needed.
}