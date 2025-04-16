package Array;

import List.Node;

public class Queue {

    private Element array[];

    private int first;

    private int last;

    private int N;
    private int srcSize;

    public Queue(int N){
        this.N = N;
        array = new Element[N];
        first = 0;
        last = 0;
    }

    boolean isFull(){
        return (last + 1) % N == first;
    }

    public boolean isEmpty(){
        return first == last;
    }

    public void enqueue(Element element){
        if (!isFull()){
            array[last] = element;
            last = (last + 1) % N;
        }
    }

    public Element dequeue(){
        if (!isEmpty()){
            Element tmp = array[first];
            first = (first + 1) % N;
            return tmp;
        }
        return null;
    }
    //Q1
    void insertAfterKth(int k , Element element){
        int position = first;
        for (int i=0; i<k; i++){
            position=(position+1) % N;
        }
        int current=last;
        while (current!=position){
            int prv=(current-1)%N;
            array[current]=array[prv];
            current=prv;
        }
        array[position] = element;
    }
    //Q2
    void deleteKth(int K){
        int position = first;
        for (int i=0; i<K; i++){
            position=(position+1) % N;
        }
        int current=position;
        while (current!=last){
            int next=(current+1)%N;
            array[current]=array[next];
            current=next;
        }
        array[last]=null;
        last=(last-1)%N;
    }
    //Q3
    int minimum(){
        int index = (first+1)%N;
        int min=array[first].getData();
        while (index != last){
            if(min>array[index].getData()){min=array[index].getData();}
            index = (index+1)%N;
        }
        return min;
    }
    //Q4
    Element dequeue2nd(){
        int targetIndex=(first+1)%N;
        Element tmp = array[targetIndex];
        array[targetIndex]=array[first];
        first=(first+1)%N;
        return tmp;
    }
    //Q5 //currently before make it after
     void insertAfterLargest(int data){
        int max=array[first].getData();
        int tmp=first;
        int maxIndex=first;
        while (tmp != last){
            tmp=(tmp+1)%N;
            if(array[tmp].getData()>max){max=array[tmp].getData();maxIndex=tmp;}
        }
        int tmpIndex=(last+1)%N;
        while (tmpIndex != (maxIndex+1)%N){
            int prev=tmpIndex;
            tmpIndex=(tmpIndex-1+N)%N;
            array[prev]=array[tmpIndex];
        }
        array[(maxIndex+1)%N]=new Element(data);
        last=(last+1)%N;
     }
    //Q6
    Queue devideQueue(){
        Queue result = new Queue(N);
        int position = first;
        while (position != last){
            if(position%2==0){
                //enqueue to result
                Element element=new Element(this.array[position].getData());
                result.array[result.last] = element;
                result.last = (result.last + 1) % result.N;
                //end of enqueueing
                // Start deleting
                int tmp = position;
                while (tmp != last){
                    this.array[tmp]=this.array[(tmp+1)%N];
                    tmp=(tmp+1)%N;
                }
                this.last=(this.last-1+N)%N;
                //End of deleting
            }
            position=(position+1)%N;
        }
        return result;
    }
    //Q8
    Element dequeue(int k){
        Element result= new Element(this.array[k].getData());
        int index = (first+k-1)%N;//***//
        for (int i = index; i!=last; i = (i + 1) % N){//***//
            array[i]=array[(i + 1) % N];
        }
        last = (last -1+N)%N;
        return result;
    }
    //Q9
    void copyPaste(Queue src, int index){
        int srcSize = 0;
        for (int i = src.first; i != src.last; i = (i + 1) % src.N) {
            srcSize++;
        }

        for (int j = (last - 1 + N) % N; j != (index - 1 + N) % N; j = (j - 1 + N) % N) {
            array[(j + srcSize) % N] = array[j];
        }

        for (int k = 0; k < srcSize; k++) {
            array[(index + k) % N] = new Element(src.array[(src.first + k) % src.N].getData());
        }

        last = (last + srcSize) % N;
    }

}
