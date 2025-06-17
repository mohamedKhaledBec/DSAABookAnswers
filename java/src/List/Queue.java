package List;

public class Queue {
    protected Node first;
    protected Node last;

    public Queue() {
        first = null;
        last = null;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(Node newNode) {
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    public Node dequeue(){
        Node result = first;
        if (!isEmpty()){
            first = first.getNext();
            if (isEmpty()){
                last = null;
            }
        }
        return result;
    }

    // Q1: Insert element after k'th position (fixed)
    void insertAfterKth(int k, Node newNode){
        if (k < 0 || newNode == null) return;
        if (k == 0){
            newNode.setNext(first);
            first = newNode;
            if (last == null) last = newNode;
            return;
        }
        Node position = first;
        for (int i = 0; i < k - 1 && position != null; i++) {
            position = position.getNext();
        }
        if (position == null) return;
        newNode.setNext(position.getNext());
        position.setNext(newNode);
        if (newNode.getNext() == null) last = newNode;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed edge cases for k=0 and null checks
    }

    // Q3: Return minimum element (fixed)
    int minimum(){
        if (isEmpty()) return Integer.MAX_VALUE;
        int min = first.getData();
        Node current = first.getNext();
        while (current != null){
            if (current.getData() < min) min = current.getData();
            current = current.getNext();
        }
        return min;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed loop to include last node and added empty check
    }

    // Q4: Dequeue second item (fixed)
    Node dequeue2nd(){
        if (first == null || first.getNext() == null) return null;
        Node target = first.getNext();
        first.setNext(target.getNext());
        if (first.getNext() == null) last = first;
        return target;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed null checks and last pointer update
    }

    // Q6: Divide queue, removing even-indexed elements (fixed)
    Queue divideQueue(){
        Queue result = new Queue();
        Node current = first;
        Node previous = null;
        int index = 1;
        while (current != null){
            if (index % 2 == 0){
                Node newNode = new Node(current.getData());
                result.enqueue(newNode);
                if (previous == null){
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                if (current == last) last = previous;
            } else {
                previous = current;
            }
            current = current.getNext();
            index++;
        }
        return result;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed indexing (1-based) and pointer updates
    }

    // Q7: Remove odd-indexed elements (verified)
    void removeOddIndexed(){
        int index = 1;
        Queue queue = new Queue();
        while (!isEmpty()){
            if (index % 2 == 0) queue.enqueue(dequeue());
            else dequeue();
            index++;
        }
        while (!queue.isEmpty()) enqueue(queue.dequeue());
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Verified correct implementation
    }

    // Q8: Dequeue k'th element (fixed)
    Node dequeue(int k){
        if (k < 1 || isEmpty()) return null;
        Node current = first;
        Node prv = null;
        for (int i = 1; i < k && current != null; i++) {
            prv = current;
            current = current.getNext();
        }
        if (current == null) return null;
        if (prv == null){
            first = first.getNext();
            if (first == null) last = null;
        } else {
            prv.setNext(current.getNext());
            if (current == last) last = prv;
        }
        return current;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed null checks and last pointer update
    }

    // Q10: Constructor for concatenating queues
    public Queue(Queue[] list){
        first = null;
        last = null;
        for (Queue queue : list) {
            Node current = queue.first;
            while (current != null) {
                Node newNode = new Node(current.getData());
                enqueue(newNode);
                current = current.getNext();
            }
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added constructor to concatenate queues
    }

    // Q11: Cut and paste elements from p to q to dest (fixed)
    void cutPaste(Queue dest, int p, int q){
        if (p < 1 || q < p || isEmpty()) return;
        Node prvPNode = null;
        Node pNode = first;
        Node qNode = null;
        int index = 1;
        Node current = first;
        while (current != null && index <= q){
            if (index == p - 1) prvPNode = current;
            if (index == p) pNode = current;
            if (index == q) qNode = current;
            current = current.getNext();
            index++;
        }
        if (qNode == null || pNode == null) return;
        if (dest.isEmpty()){
            dest.first = pNode;
            dest.last = qNode;
        } else {
            dest.last.setNext(pNode);
            dest.last = qNode;
        }
        if (prvPNode == null){
            first = qNode.getNext();
        } else {
            prvPNode.setNext(qNode.getNext());
        }
        if (qNode == last) last = prvPNode;
        qNode.setNext(null);
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed pointer updates and edge cases
    }

    // Q12: Divide queue into k equal parts (verified)
    Queue[] divideQueue(int k){
        Queue[] result = new Queue[k];
        for (int i = 0; i < k; i++) {
            result[i] = new Queue();
        }
        Node tmp = first;
        int index = 0;
        while (tmp != null){
            Node newNode = new Node(tmp.getData());
            result[index % k].enqueue(newNode);
            tmp = tmp.getNext();
            index++;
        }
        return result;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Verified correct implementation
    }

    // Q14: Remove all elements from list of queues (fixed from removeAllRetry)
    void removeAll(Queue[] list){
        Node current = first;
        Node prev = null;
        while (current != null){
            boolean remove = false;
            for (Queue q : list){
                Node qCurrent = q.first;
                while (qCurrent != null){
                    if (qCurrent.getData() == current.getData()){
                        remove = true;
                        break;
                    }
                    qCurrent = qCurrent.getNext();
                }
                if (remove) break;
            }
            Node next = current.getNext();
            if (remove){
                if (prev == null){
                    first = next;
                } else {
                    prev.setNext(next);
                }
                if (current == last) last = prev;
            } else {
                prev = current;
            }
            current = next;
        }
        if (first == null) last = null;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed logic from removeAllRetry to correctly remove elements
    }
}