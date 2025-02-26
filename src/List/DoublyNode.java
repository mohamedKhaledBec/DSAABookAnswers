package List;

public class DoublyNode extends Node{

    private DoublyNode previous;

    public DoublyNode(int data) {
        super(data);
        previous = null;
    }

    public DoublyNode getPrevious(){
        return previous;
    }
    public DoublyNode getNext(){return (DoublyNode) next;}

    public void setPrevious(DoublyNode node){
        previous = node;
    }
}
