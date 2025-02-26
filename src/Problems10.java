import List.DoublyLinkedList;
import List.DoublyNode;
import List.LinkedList;
import List.Node;

public class Problems10 {

    //Ex 30
    //Personal Notes: I forgot to set the tmp which makes me go into an infinte look; when
    //interchanging in doublyNodes use tmp to keep track of the old value
    void reverse (DoublyLinkedList dlist1){
        DoublyNode currnet = dlist1.getHead();
        DoublyNode tmp = null;

        while(currnet != null){
            tmp = currnet.getNext();
            currnet.setNext(currnet.getPrevious());
            currnet.setPrevious(tmp);
            currnet = tmp;
        }
        tmp = dlist1.getHead();
        dlist1.setHead(dlist1.getTail());
        dlist1.setTail(tmp);

    }
    //Ex29
    boolean containsOnlyTriplicates (DoublyLinkedList dlist){
        DoublyNode current1 = dlist.getHead();
        if(current1 == null){return false;}
        while(current1 != null){
            DoublyNode current2=dlist.getHead();
            int counter=0;
            while(current2 != null){
                if(current2.getData() == current1.getData()){
                    counter++;
                }
                current2=current2.getNext();
            }
            if(counter != 3){return false;}
            current1=current1.getNext();
        }

        return true;
    }
    // EX28
    static LinkedList difference (LinkedList list1, LinkedList list2)
    {
        LinkedList resultLL = new LinkedList();
        Node tmp1 = list1.getHead();
        Node tmp2 = list2.getHead();
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.getData() > tmp2.getData()) {
                tmp2 = tmp2.getNext();
            }
            else if (tmp1.getData() < tmp2.getData()) {
                if(resultLL.getHead() != tmp1){resultLL.insertFirst(tmp1);}
                tmp1 = tmp1.getNext();
            }
            else if (tmp1.getData() == tmp2.getData()) {
                tmp1 = tmp1.getNext();
                tmp2 = tmp2.getNext();
            }
        }
        return resultLL;
    }
//Ex27
    void removeKthBeforeLast (DoublyLinkedList dlist, int k){
        DoublyNode current1 = dlist.getTail();
        for (int i=k;i>1;i--){
            current1 = current1.getPrevious();
        }

        if(current1.getNext() == null){
            current1.getPrevious().setNext(null);
            dlist.setTail(current1.getPrevious());
        }
        else if(current1.getPrevious() == null){
            current1.getNext().setPrevious(null);
            dlist.setHead(current1.getNext());
        }
        else{
            current1.getNext().setPrevious(current1.getPrevious());
            current1.getPrevious().setNext(current1.getNext());
        }
    }
    //Ex26
    LinkedList getIndexedList (LinkedList olist, LinkedList ilist){
        LinkedList result = new LinkedList();
        Node index = ilist.getHead();
        while(index != null){
            Node listCurrent = olist.getHead();
            for(int i=1;i<index.getData();i++){
                listCurrent=listCurrent.getNext();
            }


            if(result.getHead() == null){
                result.setHead(listCurrent);
            }
            else{
                result.getTail().setNext(listCurrent);

            }
            result.setTail(listCurrent);
            index=index.getNext();
                }
        return result;
    }
    //EX25
    void deleteEven(LinkedList list){
        Node current = list.getHead();
        Node prv = null;
        while(current != null){
            if(current.getData() % 2 == 0){
                if(prv == null){
                    list.setHead(current.getNext());
                }
                else if (current.getNext() == null){
                    list.setTail(prv);
                    prv.setNext(null);
                }
                else {
                    prv.setNext(current.getNext());
                }

            }
            else {
                prv = current;
            }
            current = current.getNext();
        }
    }
    //Ex24
    void remove (LinkedList olist, LinkedList list2){
        Node current = olist.getHead();
        Node prv = null;
        while(current != null){
            Node current2 = list2.getHead();

            while(current2 != null){
                if (current2.getData() == current.getData()){
                    if( prv== null){
                       olist.setHead(current.getNext());
                    }
                    else if (current.getNext() == null){
                        olist.setTail(prv);
                        prv.setNext(null);
                    }
                    else{
                        prv.setNext(current.getNext());
                    }
                    break;

                }
                else {
                    prv = current;
                }

                current2 = current2.getNext();
            }

            current=current.getNext();

        }
    }
    //Ex23
    boolean isPalindrome (DoublyLinkedList dlist){
        DoublyNode p1 = dlist.getHead();
        DoublyNode p2 = dlist.getTail();
        DoublyNode tmp=p1;


        while (p1!=p2 && p1.getNext()!=p2){
            if(p1.getData() == p2.getData()){
                p1=p1.getNext();
                p2=p2.getPrevious();
            }
            else{return false;}
        }
        if(p1==p2 || p1.getNext()==p2){return true;}
        return false;
    }
    //Ex22
    LinkedList intersec (LinkedList list1 , LinkedList list2 ){
        Node p1 = list1.getHead();
        Node p2 = list2.getHead();
        LinkedList result = new LinkedList();
        while (p1 != null && p2 != null){
            if(p1.getData() == p2.getData()){
                Node NewNode=new Node(p1.getData());
                if (result.getHead() == null){
                    result.setHead(NewNode);
                    result.setTail(NewNode);
                }
                else{
                    result.getTail().setNext(NewNode);
                    result.setTail(NewNode);
                }

                p1=p1.getNext();
                p2=p2.getNext();

            }
            else if (p1.getData()>p2.getData()){
                p2=p2.getNext();
            }
            else{
                p1=p1.getNext();
            }
        }
        return result;
    }
    //EX21
    boolean evenOddSorted(LinkedList list){
        Node pEven = list.getHead();
        Node prvEven=null;
        Node pOdd = list.getHead().getNext();
        Node prvOdd=null;
        int index=0;
        while (pEven != null || pOdd != null){
            if (index % 2 == 0){//even index check decending order
                if(prvEven == null){
                    prvEven=pEven;
                    if (pEven.getNext() == null){
                        prvEven=null;
                    }
                    else{pEven=pEven.getNext().getNext();}

                }
                else if (prvEven.getData() <= pOdd.getData()){
                    prvEven=pEven;
                    if (pEven.getNext() == null){
                        prvEven=null;
                    }
                    else{pEven=pEven.getNext().getNext();}
                }
                else {return false;}
            }
            else{
                if(prvOdd == null){
                    prvOdd=pOdd;
                    if (pOdd.getNext() == null){pOdd=null;}
                    else{pOdd=pOdd.getNext().getNext();}

                }
                else if (prvOdd.getData() >= pEven.getData()){
                    prvOdd=pOdd;
                    if (pOdd.getNext() == null){pOdd=null;}
                    else{pOdd=pOdd.getNext().getNext();}
                }
                else {return false;}
            }
        }
        return true;
    }
    //Ex20
    DoublyLinkedList sortElements(DoublyLinkedList list){
        DoublyLinkedList sortedList = new DoublyLinkedList();
        DoublyNode p1 = list.getHead();
        int biggestNumber = 0;
        while (p1 != null){//find the biggest N once
            if(p1.getPrevious() == null){biggestNumber=p1.getData();}
            else if (p1.getData()>biggestNumber){biggestNumber=p1.getData();}
            p1=p1.getNext();
        }
        p1=list.getHead();
        boolean calcultedAccurances=false;
        while (p1 != null){//serch for how many times it happent or new biggest number according to the order of instruction
            if(!calcultedAccurances){//didnt calculate accurences so calculate
                //calculate how many biggestNumber we have if it is not in the result list

                DoublyNode p2 = list.getHead();
                int count=0;

                if(sortedList.getHead()==null ||sortedList.getHead().getData()>biggestNumber){//we can add to result list
                    while(p2!=null){//calculate accurances
                        if(p2.getData()==biggestNumber){count++;}
                        p2=p2.getNext();
                    }
                    //add to result list now
                    for (int i=0;i<count;i++){
                        DoublyNode tmp = new DoublyNode(biggestNumber);
                        if(sortedList.getHead()==null){

                            sortedList.setTail(tmp);
                            sortedList.setHead(tmp);
                        }
                        else{

                            sortedList.getHead().setPrevious(tmp);
                            tmp.setNext(sortedList.getHead());
                            sortedList.setHead(tmp);
                        }
                    }
                }

                calcultedAccurances=true;
            }
            else{//find new biggest N
                DoublyNode p2 = list.getHead() ;
                int currentBiggestNumber = p2.getData();
                while(p2!=null){
                    if(p2.getData()<biggestNumber &&p2.getData()>currentBiggestNumber){currentBiggestNumber=p2.getData();}

                    p2=p2.getNext();
                }
                if(biggestNumber==currentBiggestNumber){break;}
                biggestNumber=currentBiggestNumber;

                calcultedAccurances=false;
            }

        }
        return sortedList;
    }
    //Ex19




    
// EX8
// static LinkedList oddIndexedElements(LinkedList){
//     return
// }

    // EX7
    static void removeSingles(LinkedList list) {
        Node tmp = list.getHead();
        Node prv = null;
        int counter = 0;
        int counter1 = 0;
        int cValue;
        if (tmp.getData() != tmp.getNext().getData()){
            list.setHead(tmp.getNext());
            cValue = tmp.getNext().getData();
        }
        else {counter ++; counter1++; cValue = tmp.getNext().getData();}
        prv = tmp;
        tmp = tmp.getNext();
        while (tmp != null) {
            // Value changed
            if(tmp.getData() != cValue){
                counter1 = 0;
                if(tmp.getNext() == null){
                    prv.setNext(null);
                    list.setTail(prv);
                }
                if(counter < 1){
                    cValue = tmp.getData();
                    counter = 0;
                }
                else {
                    prv.setNext(tmp.getNext());
                    prv = tmp;
                    tmp = tmp.getNext();
                    cValue = tmp.getNext().getData();
                }
            }
            else {
                counter++;
                prv = tmp;
                tmp = tmp.getNext();
            }
        }
    }

    // EX5
    static void deleteAll(LinkedList list, int X) {
        Node tmp = list.getHead();
        while (tmp != null) {
            if (tmp.getData() == X) {
                if (tmp.getNext() != null) {
                    list.setHead(null);
                    list.setTail(null);
                }
                list.setHead(tmp.getNext());
                tmp = tmp.getNext();
            }
            if (tmp.getNext().getData() == X) {
                if (tmp.getNext().getNext() == null){
                    tmp.setNext(null);
                    list.setTail(tmp);
                }
                tmp.setNext(tmp.getNext().getNext());
                tmp = tmp.getNext().getNext();
            }
            else {
                tmp = tmp.getNext();
            }
        }
    }

    // EX4
    static LinkedList intersection (LinkedList list1, LinkedList list2) {
        LinkedList result = new LinkedList();
        Node tmp1 = list1.getHead();
        Node tmp2 = list2.getHead();
        while (tmp1 != null || tmp2 != null) {
            if (tmp1.getData() == tmp2.getData()) {
                result.insertFirst(tmp1);
                tmp1 = tmp1.getNext();
                tmp2 = tmp2.getNext();
            }
            else if (tmp1.getData() < tmp2.getData()) {
                tmp2 = tmp2.getNext();
            }
            else if (tmp1.getData() > tmp2.getData()) {
                tmp1 = tmp1.getNext();
            }
        }
        return result;
    }

// EX3 (Doubly Linked List)
    void cutPaste(DoublyNode first, DoublyNode last, DoublyNode paste){

        if(paste.getNext() == null){last.setNext(null);}
        else{paste.getNext().setPrevious(last);last.setNext(paste.getNext());}
        paste.setNext(first);

        first.setPrevious(paste);
    }
    // EX2
    static void removeDuplicates (LinkedList list) {
        Node tmp1 = list.getHead();
        while (tmp1 != null) {
            Node tmp2 = tmp1.getNext();
            Node prv = null;
            while (tmp2 != null) {
                if (tmp2.getData() == tmp1.getData()){
                    if (prv == null){
                        prv = tmp1;
                    }
                    prv.setNext(tmp2.getNext());
                }
                prv = tmp2;
                tmp2 = tmp2.getNext();
            }
            tmp1 = tmp1.getNext();
        }
    }

    // EX1
    static LinkedList fibonacci (int A, int B) {
        int FN = 0, FN1 = 1;
        LinkedList result = new LinkedList();
        while (FN < B || FN1 < A) {
            FN = FN + FN1;
            FN1 = FN + FN1;
            Node FNN = new Node(FN);
            Node FNN1 = new Node(FN1);
            if (FN > A || FN1 < B){
                if (FN1 > B && FN < B){
                    result.insertFirst(FNN);
                }
                else if (FN < A && FN1 > A){
                    result.insertFirst(FNN1);
                }
                else if (FN1 < B && FN < B) {
                    result.insertFirst(FNN);
                    result.insertFirst(FNN1);
                }
            }
        }
        return result;
    }

}
