package List;

public class LinkedList {
    protected Node head;
    protected Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void insertFirst(Node newNode) {
        if (isEmpty()) {
            tail = newNode;
        }
        newNode.setNext(head);
        head = newNode;
    }

    public Node search(int value) {
        Node tmp = head;
        while (tmp != null) {
            if (value == tmp.getData()) {
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    public void deleteFirst() {
        head = head.getNext();
        if (isEmpty()) {
            tail = null;
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        Node tmp = head;
        while (tmp != null) {
            result.append(tmp).append(" ");
            tmp = tmp.getNext();
        }
        return result.toString();
    }

    // 2.9 Exercise 1: Find the smallest number in a singly linked list
    // [AI Answer]
    int smallest() {
        Node current = head;
        if (current == null) return -1; // Assuming -1 for empty list
        int min = current.getData();
        while (current != null) {
            if (current.getData() < min) min = current.getData();
            current = current.getNext();
        }
        return min;
    }

    // 2.9 Exercise 2: Delete the second node from a singly linked list
    // [AI Answer]
    void deleteSecond() {
        if (head == null || head.getNext() == null) return;
        head.setNext(head.getNext().getNext());
        if (head.getNext() == null) tail = head;
    }

    // 2.9 Exercise 3: Add a new node before the last node
    // [AI Answer]
    void insertBeforeLast(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else if (head == tail) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            current.setNext(newNode);
            newNode.setNext(tail);
        }
    }

    // 2.9 Exercise 4: Add a new integer to a sorted linked list
    // [AI Answer]
    void AddToSortedList(int x) {
        Node newNode = new Node(x);
        if (head == null || head.getData() >= x) {
            newNode.setNext(head);
            head = newNode;
            if (tail == null) tail = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null && current.getNext().getData() < x) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) tail = newNode;
        }
    }

    // 2.9 Exercise 5: Delete the k'th node from a singly linked list
    // [AI Answer]
    void deleteKth(int k) {
        if (head == null || k < 1) return;
        if (k == 1) {
            head = head.getNext();
            if (head == null) tail = null;
            return;
        }
        Node current = head;
        for (int i = 1; i < k - 1 && current != null; i++) {
            current = current.getNext();
        }
        if (current == null || current.getNext() == null) return;
        current.setNext(current.getNext().getNext());
        if (current.getNext() == null) tail = current;
    }

    // 2.9 Exercise 11: Delete all nodes divisible by N and return them
    // [AI Answer]
    LinkedList removeDivisibleByN(int N) {
        LinkedList removed = new LinkedList();
        Node current = head;
        Node prv = null;
        while (current != null) {
            if (current.getData() % N == 0) {
                Node newNode = new Node(current.getData());
                if (removed.getHead() == null) {
                    removed.setHead(newNode);
                    removed.setTail(newNode);
                } else {
                    removed.getTail().setNext(newNode);
                    removed.setTail(newNode);
                }
                if (prv == null) {
                    head = current.getNext();
                } else {
                    prv.setNext(current.getNext());
                }
                if (current == tail) tail = prv;
                current = current.getNext();
            } else {
                prv = current;
                current = current.getNext();
            }
        }
        return removed;
    }

    // 2.9 Exercise 15: Remove the node before the last node
    // [AI Answer]
    void removeBeforeLast() {
        if (head == null || head == tail || head.getNext() == tail) return;
        Node current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        if (current == head) {
            head = tail;
        } else {
            Node prv = current;
            while (prv.getNext() != current) {
                prv = prv.getNext();
            }
            prv.setNext(tail);
        }
    }

    // 2.10 Problem 1: Fibonacci numbers between A and B
    // [Mohamed Khaled Becetti solved and AI corrected]
    static LinkedList fibonacci(int A, int B) {
        LinkedList result = new LinkedList();
        Node fn = new Node(0);
        Node fn1 = new Node(1);
        if (A <= 0 && B >= 0) result.insertFirst(fn);
        if (A <= 1 && B >= 1) result.insertFirst(fn1);
        int fnVal = 1;
        int fn1Val = 1;
        while (fnVal <= B) {
            fnVal = fn.getData() + fn1.getData();
            fn = fn1;
            fn1 = new Node(fnVal);
            if (fnVal >= A && fnVal <= B) {
                result.insertFirst(fn1);
            }
        }
        return result;
    }
    // Feedback: Original had confusing logic and potential infinite loop.
    // Corrected to generate Fibonacci numbers properly between A and B.

    // 2.10 Problem 2: Remove duplicates from a sorted linked list
    // [Mohamed Khaled Becetti solved and AI corrected]
    static void removeDuplicates(LinkedList list) {
        Node tmp1 = list.getHead();
        if (tmp1 == null) return;
        while (tmp1 != null && tmp1.getNext() != null) {
            if (tmp1.getData() == tmp1.getNext().getData()) {
                tmp1.setNext(tmp1.getNext().getNext());
                if (tmp1.getNext() == null) list.setTail(tmp1);
            } else {
                tmp1 = tmp1.getNext();
            }
        }
    }
    // Feedback: Original was inefficient for sorted list. Corrected to leverage sorted property.

    // 2.10 Problem 4: Intersection of two sorted linked lists
    // [Mohamed Khaled Becetti solved and AI corrected]
    static LinkedList intersection(LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        Node tmp1 = list1.getHead();
        Node tmp2 = list2.getHead();
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.getData() == tmp2.getData()) {
                Node newNode = new Node(tmp1.getData());
                if (result.getHead() == null) {
                    result.setHead(newNode);
                    result.setTail(newNode);
                } else {
                    result.getTail().setNext(newNode);
                    result.setTail(newNode);
                }
                tmp1 = tmp1.getNext();
                tmp2 = tmp2.getNext();
            } else if (tmp1.getData() < tmp2.getData()) {
                tmp1 = tmp1.getNext();
            } else {
                tmp2 = tmp2.getNext();
            }
        }
        return result;
    }
    // Feedback: Original had null pointer risks. Corrected to match sorted intersection algorithm.

    // 2.10 Problem 5: Delete all nodes with value X
    // [Mohamed Khaled Becetti solved and AI corrected]
    static void deleteAll(LinkedList list, int X) {
        Node current = list.getHead();
        Node prv = null;
        while (current != null) {
            if (current.getData() == X) {
                if (prv == null) {
                    list.setHead(current.getNext());
                } else {
                    prv.setNext(current.getNext());
                }
                if (current == list.getTail()) list.setTail(prv);
                current = current.getNext();
            } else {
                prv = current;
                current = current.getNext();
            }
        }
    }
    // Feedback: Original had infinite loop risk. Corrected for proper deletion.

    // 2.10 Problem 6: Check if list contains sublist in order
    // [AI Answer]
    boolean subList(LinkedList sub) {
        Node main = head;
        Node subCurrent = sub.getHead();
        if (subCurrent == null) return true;
        while (main != null) {
            if (main.getData() == subCurrent.getData()) {
                Node m = main;
                Node s = subCurrent;
                while (m != null && s != null && m.getData() == s.getData()) {
                    m = m.getNext();
                    s = s.getNext();
                }
                if (s == null) return true;
            }
            main = main.getNext();
        }
        return false;
    }

    // 2.10 Problem 7: Remove single elements from a sorted linked list
    // [Mohamed Khaled Becetti solved and AI corrected]
    static void removeSingles(LinkedList list) {
        Node current = list.getHead();
        Node prv = null;
        while (current != null && current.getNext() != null) {
            int count = 0;
            Node tmp = current;
            while (tmp != null && tmp.getData() == current.getData()) {
                count++;
                tmp = tmp.getNext();
            }
            if (count == 1) {
                if (prv == null) {
                    list.setHead(current.getNext());
                } else {
                    prv.setNext(current.getNext());
                }
                if (current == list.getTail()) list.setTail(prv);
                current = current.getNext();
            } else {
                prv = current;
                current = tmp;
            }
        }
        // Check last element if single
        if (current != null && prv != null && current.getData() != prv.getData()) {
            prv.setNext(null);
            list.setTail(prv);
        }
    }
    // Feedback: Original had errors and didn’t leverage sorted property efficiently.
    // Corrected to count consecutive duplicates in sorted list.

    // 2.10 Problem 8: Delete odd-indexed elements and return them
    // [Mohamed Khaled Becetti solved and AI corrected]
    static LinkedList oddIndexedElements(LinkedList list) {
        LinkedList result = new LinkedList();
        Node current = list.getHead();
        int index = 1;
        while (current != null) {
            if (index % 2 == 1) {
                Node newNode = new Node(current.getData());
                if (result.getHead() == null) {
                    result.setHead(newNode);
                    result.setTail(newNode);
                } else {
                    result.getTail().setNext(newNode);
                    result.setTail(newNode);
                }
            }
            current = current.getNext();
            index++;
        }
        return result;
    }
    // Feedback: Original was incomplete. Corrected to return odd-indexed elements.

    // 2.10 Problem 9: Delete even-indexed elements
    // [AI Answer]
    void deleteEvenIndexed() {
        if (head == null) return;
        Node current = head;
        Node prv = null;
        int index = 1;
        while (current != null) {
            if (index % 2 == 0) {
                if (prv != null) {
                    prv.setNext(current.getNext());
                }
                if (current == tail) tail = prv;
                current = current.getNext();
            } else {
                prv = current;
                current = current.getNext();
            }
            index++;
        }
    }

    // 2.10 Problem 10: Print contents in reverse order
    // [AI Answer]
    void printReverse() {
        printReverseHelper(head);
    }
    private void printReverseHelper(Node current) {
        if (current == null) return;
        printReverseHelper(current.getNext());
        System.out.print(current.getData() + " ");
    }

    // 2.10 Problem 11: Add new node after each node
    // [AI Answer]
    void addAfterEachNode(Node newNodeTemplate) {
        Node current = head;
        while (current != null) {
            Node newNode = new Node(newNodeTemplate.getData());
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            if (newNode.getNext() == null) tail = newNode;
            current = newNode.getNext();
        }
    }

    // 2.10 Problem 12: Print odd-indexed nodes
    // [AI Answer]
    void printOddNodes() {
        Node current = head;
        int index = 1;
        while (current != null) {
            if (index % 2 == 1) {
                System.out.print(current.getData() + " ");
            }
            current = current.getNext();
            index++;
        }
    }

    // 2.10 Problem 13: Delete all prime nodes
    // [Mohamed Khaled Becetti's Answer]
    void deletePrimes() {
        Node current = head;
        Node prv = null;
        while (current != null) {
            boolean isPrime = true;
            for (int i = 2; i < current.getData(); i++) {
                if (current.getData() % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && current.getData() > 1) {
                if (prv == null) {
                    head = current.getNext();
                } else {
                    prv.setNext(current.getNext());
                }
                if (current == tail) tail = prv;
                current = current.getNext();
            } else {
                prv = current;
                current = current.getNext();
            }
        }
    }
    // Feedback: Original was mostly correct but didn’t handle 1 as non-prime explicitly.
    // Adjusted to ensure 1 is not considered prime.

    // 2.10 Problem 14: Delete nodes between p and q
    // [Mohamed Khaled Becetti solved and AI corrected]
    void deleteBetween(int p, int q) {
        int index = 0;
        Node current = head;
        Node prv = null;
        Node p1 = null;
        Node p2 = null;
        while (current != null) {
            if (index == p) p1 = prv;
            if (index == q) p2 = current.getNext();
            prv = current;
            current = current.getNext();
            index++;
        }
        if (p1 == null) head = p2;
        else if (p2 == null) {
            tail = p1;
            p1.setNext(null);
        } else {
            p1.setNext(p2);
        }
    }
    // Feedback: Original had infinite loop due to missing index increment.
    // Corrected to properly track and delete range.

    // 2.10 Problem 18: Return prime divisors of N
    // [Mohamed Khaled Becetti solved and AI corrected]
    LinkedList primeDivisors(int N) {
        LinkedList tmplist = new LinkedList();
        if (N < 2) return tmplist;
        int num = N;
        for (int i = 2; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                Node newNode = new Node(i);
                if (tmplist.getHead() == null) {
                    tmplist.setHead(newNode);
                    tmplist.setTail(newNode);
                } else {
                    tmplist.getTail().setNext(newNode);
                    tmplist.setTail(newNode);
                }
            }
        }
        LinkedList result = new LinkedList();
        Node p = tmplist.getHead();
        while (num > 1) {
            if (num % p.getData() == 0) {
                Node newNode = new Node(p.getData());
                if (result.getHead() == null) {
                    result.setHead(newNode);
                    result.setTail(newNode);
                } else {
                    result.getTail().setNext(newNode);
                    result.setTail(newNode);
                }
                num /= p.getData();
            } else {
                p = p.getNext();
            }
        }
        return result;
    }
    // Feedback: Original had broken loop structure. Corrected to compute prime factors efficiently.

    // 2.10 Problem 22: Intersection of two sorted linked lists
    // [Mohamed Khaled Becetti's Answer]
    LinkedList intersec(LinkedList list1, LinkedList list2) {
        Node p1 = list1.getHead();
        Node p2 = list2.getHead();
        LinkedList result = new LinkedList();
        while (p1 != null && p2 != null) {
            if (p1.getData() == p2.getData()) {
                Node newNode = new Node(p1.getData());
                if (result.getHead() == null) {
                    result.setHead(newNode);
                    result.setTail(newNode);
                } else {
                    result.getTail().setNext(newNode);
                    result.setTail(newNode);
                }
                p1 = p1.getNext();
                p2 = p2.getNext();
            } else if (p1.getData() > p2.getData()) {
                p2 = p2.getNext();
            } else {
                p1 = p1.getNext();
            }
        }
        return result;
    }
    // Feedback: Correct and matches book requirement perfectly.

    // 2.10 Problem 25: Delete nodes with even values
    // [Mohamed Khaled Becetti solved and AI corrected]
    void deleteEven() {
        Node current = head;
        Node prv = null;
        while (current != null) {
            if (current.getData() % 2 == 0) {
                if (prv == null) {
                    head = current.getNext();
                } else {
                    prv.setNext(current.getNext());
                }
                if (current == tail) tail = prv;
                current = current.getNext();
            } else {
                prv = current;
                current = current.getNext();
            }
        }
    }
    // Feedback: Original risked infinite loop due to missing current advance.
    // Corrected to ensure proper traversal.

    // 2.10 Problem 28: Difference of two sorted linked lists
    // [Mohamed Khaled Becetti solved and AI corrected]
    static LinkedList difference(LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        Node tmp1 = list1.getHead();
        Node tmp2 = list2.getHead();
        while (tmp1 != null) {
            while (tmp2 != null && tmp2.getData() < tmp1.getData()) {
                tmp2 = tmp2.getNext();
            }
            if (tmp2 == null || tmp1.getData() != tmp2.getData()) {
                Node newNode = new Node(tmp1.getData());
                if (result.getHead() == null) {
                    result.setHead(newNode);
                    result.setTail(newNode);
                } else {
                    result.getTail().setNext(newNode);
                    result.setTail(newNode);
                }
            }
            tmp1 = tmp1.getNext();
        }
        return result;
    }
    // Feedback: Original didn’t build result correctly. Corrected to include only elements in list1 not in list2.
}