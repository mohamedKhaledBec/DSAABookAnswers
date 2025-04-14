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
        } else {
            last.setNext(newNode);
        }
        last = newNode;
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
    void removeAll(Queue[] list){
        Node current = first;
    }
    //Q1
    void insertAfterKth (int k,Node newNode){
        Node position = first;
        for (int i = 0; i < k; i++) {
            position = position.getNext();
        }
        newNode.next=position.next;
        position.next=newNode;
    }
    //Q3
    int minimum(){
        int min=first.getData();
        Node current = first;
        while (current != last){
            current = current.getNext();
            if(current.data<min){min=current.data;}
        }
        return min;
    }
    //Q4
    Node dequeue2nd(){
        Node target = first.next;
        if(target.next==null){
            last=first;
        }
        first.next=target.next;
        return target;
    }
}
