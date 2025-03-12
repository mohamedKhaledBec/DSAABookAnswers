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
        top = top.next;
        return topNode;
    }
    //Ex

//Ex18
    LinkedList popBottom(int k){
        LinkedList list = new LinkedList();
        int size=0;
        Node current = top;
        Node prev = null;
        Node topNode = top;
        while(topNode!=null){
            size++;
            topNode = topNode.next;
        }
        int target = size-k;
        for (int i=0; i<target; i++){prev = current;current=current.next;}
        list.head=current;
        if(prev!=null){prev.next=null;}
        while (current!=null){
            prev = current;
            current=current.next;
        }
        list.tail=prev;
        return list;
    }

    //EX 20
    void addToStack (Stack s, int p,int q ){
        Node tmp = s.top;
        int index=1;
        while (tmp != null){
            if(index<= p && index >= q){
                Node newNode=new Node(tmp.data);
                newNode.next=top;
                top=newNode;
            }
            tmp = tmp.next;
            index++;
        }
    }
    //Ex22
    void removeOddIndexed() {
        Stack stack = new Stack();
        while (top != null) {//flip stack first
            Node tmp = top;
            stack.push(top);
            pop();
        }
        int index=1;
        while(!stack.isEmpty()){
            if(index%2==0) {
                top = stack.pop();
                push(top);
            }
            else{
                stack.pop();
            }
            index++;
        }
    }

}
