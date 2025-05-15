package Array;

import List.Node;

public class Stack {
    private Element[] array;
    private int top;
    private int N;

    public Stack(int N){
        this.N = N;
        array = new Element[N];
        top = -1;
    }

    boolean isFull(){
        return top == N - 1;
    }

    boolean isEmpty(){
        return top == -1;
    }

    Element peek(){
        return array[top];
    }

    void push(Element element){
        if (!isFull()){
            top++;
            array[top] = element;
        }
    }

    Element pop(){
        if (!isEmpty()){
            top--;
            return array[top + 1];
        }
        return null;
    }
    //Ex 13
    void removeOddIndexed(){
        Stack stack = new Stack(9999);
        int index= 1;
        while(!isEmpty()){
            stack.push(pop());
        }
        while(!stack.isEmpty()){
            if(index%2==0){
                stack.pop();
            }
            else{push(stack.pop());}
            index++;
        }
    }

    //Ex14
    Element pop(int k){
        int popIndex = top-k+1;
        Element poped = array[popIndex];
        //remove above elements
        for(int i = popIndex;i<top;i++){
            array[i] = array[i+1];
        }
        top--;
        return poped;
    }
    //Ex15
    void compress(){
        Stack stack = new Stack(N);
        int prevPoped=pop().getData();
        stack.push(new Element(prevPoped));
        while (!isEmpty()){
            Element poped = pop();
            if(prevPoped!=poped.getData()){
                stack.push(poped);
            }

            prevPoped=poped.getData();
        }
        while (!stack.isEmpty()){
            push(stack.pop());
        }
    }
    //Ex16
    void push (int k, int data){

        for (int i=top; i>=top-k;i--){
            array[i] = array[i-1];
        }
        array[top-k]=new Element(data);
    }

    //Ex17
    void removeEvenIndexed(){
        int counter=1;
        Element sp = pop();

        List.Stack stack = new List.Stack();
        stack.push(new Node(sp.getData()));
       while(!isEmpty()){//reverse the order
           stack.push(new Node(pop().getData()));
       }
       while(!stack.isEmpty()){
           if(counter%2==0){stack.pop();}
           else{push(new Element (stack.pop().getData()));}
           counter++;
       }
    }

    //Ex19
     boolean isBalanced(int[] a){

        int pos = 0;
        for(int i : a){
            if(i<10){
                push(new Element(i));
            }
            else if(i>10){
                if(isEmpty()){return false;}
                if(pop().getData() !=i){return false;}
            }
        }
        return true;
    }



    //Ex21
    void insertAfterLargest(int s){
        int Largest=0;
        for(Element element : array){//find the largest
            if(element.getData()>Largest){
                Largest=element.getData();
            }
        }
        for (int i=top; i>=0; i--){
            if(array[i].getData()==Largest){
                for (int j=i+1; j<array.length; j++){
                    array[j-1] = array[j];
                }
                array[i]=new Element(Largest) ;
            }
        }
    }



}
