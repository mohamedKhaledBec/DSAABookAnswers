package List;

public class DoublyLinkedList extends LinkedList{

    public void insertLast(DoublyNode newNode) {
        if (head == null) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        newNode.setPrevious((DoublyNode) tail);
        tail = newNode;
    }

    public void deleteLast(){
        tail = ((DoublyNode)tail).getPrevious();
        if (tail != null){
            tail.setNext(null);
        } else {
            head = null;
        }
    }

    @Override
    public DoublyNode getHead() {
        return this.getHead();
    }
    public DoublyNode getTail() {return getTail();}
    public void setHead(DoublyNode newNode) {this.head = newNode;}
    public void setTail(DoublyNode newNode) {this.tail = newNode;}
}
