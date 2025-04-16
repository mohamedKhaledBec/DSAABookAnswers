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
    //Q6
    Queue devideQueue(){
        Queue result = new Queue();
        Node current = first;
        Node previous = null;
        int index=0;
        while (current != null){
            if(index%2==0){
                //insert
                Node newNode= new Node (current.getData());
                if(result.first==null){
                    result.first = newNode;
                }
                else result.last.next=newNode;
                result.last=newNode;
                //end of insert
                if(previous == null){first =first.next;}
                else{previous.next=current.next;}
                current=current.next;

            }
            else{previous=current;current=current.getNext();}
            index++;
        }
        return result;
    }
    //Q7
    void removeOddIndexed(){
        int index=1;
        Queue queue = new Queue();
        while(!this.isEmpty()){
            if(index++%2==0)queue.enqueue(this.dequeue());
            else this.dequeue();
        }
        while(!queue.isEmpty()){this.enqueue(queue.dequeue());}
    }
    //Q8
    Node dequeue(int k){
        Node result;
        Node current = first;
        Node prv=null;
        for (int i = 1; i < k; i++) {
            prv=current;
            current=current.next;
        }
        result = current;
        if(prv==null){first=first.next;}
        else{prv.next=current.next;}
        if(current.next==null){last=prv;}
        return result;
    }
    //Q10
    void Queue(Queue[] list){
        for (Queue queue : list) {
            Node current = queue.first;
            while (current != null) {
                Node newNode = new Node (current.getData());
                if(first==null)first=newNode;
                else  last.setNext(newNode);
                last=newNode;
                current=current.next;
            }
        }
    }
//Q11
    void cutPaste(Queue dest, int p , int q){
        Node current = first;
        Node prvPNode = null;
        Node QNode = null;
        int index = 1;
        while (current != null) {
            if (index == p - 1) prvPNode = current;
            if (index++ == q) QNode = current;
            current = current.next;
        }

        Node pNode = prvPNode.next;
        dest.last.next = pNode;
        dest.last = QNode;

        prvPNode.next = QNode.next;
        if (QNode == last) last = prvPNode;
        QNode.next = null;
    }
    //Q12
    Queue[] divideQueue(int k){
        Queue[] result = new Queue[k];
        for (int i = 0; i < k; i++) {
            result[i] = new Queue();
        }
        Node tmp = this.first;
        int index=0;
        while(tmp!=null){
            Node newNode = new Node (tmp.getData());
            if(result[index].first==null)result[index].first = newNode;
            else result[index].last.next=newNode;
            result[index].last=newNode;
            tmp=tmp.next;
            index=(index+1)%k;
        }
        return result;
    }
    //Q14
    void removeAll(Queue[]list){
        for (Queue q : list) {
            Node current = q.first;
            while(current!=null){
                Node tmp = this.first;
                Node prv = null;
                while (tmp != null) {
                    if (current.data == tmp.data) {
                        if (prv == null) {
                            // Removing the first node
                            this.first = this.first.next;
                            if (this.first == null) {
                                this.last = null; //empty queue
                            }
                        } else {
                            prv.next = tmp.next;
                            if (tmp.next == null) {
                                this.last = prv; //last element requires last update
                            }
                        }

                    }
                    else{
                        prv = tmp;
                    }
                    tmp = tmp.next;
                }
                last=prv;
                current= current.next;
            }
        }
    }
}
