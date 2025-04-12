package List;

public class Hash {

    private LinkedList[] table;

    private int N;

    public Hash(int N){
        table = new LinkedList[N];
        for (int i = 0; i < N; i++){
            table[i] = new LinkedList();
        }
        this.N = N;
    }

    public Node search(int value){
        int address;
        address = hashFunction(value);
        return table[address].search(value);
    }

    public void insert(int value){
        int address;
        address = hashFunction(value);
        table[address].insertFirst(new Node(value));
    }

    private int hashFunction(int value){
        return value % N;
    }

//Q5
    public boolean anyDuplicates(int[] array){
        for (int i:array){
            if(this.search(i)!=null){
                return true;
            }
            this.insert(i);
        }
        return false;
    }
//Q6
    public Hash simplify(){
        Hash result=new Hash(N);
        for (int i = 0; i < N; i++){
            Node current = table[i].getHead();
            while(current!=null){
                if(result.search(current.data)==null){
                    result.insert(current.data);
                }
                current=current.getNext();
            }
        }
        return result;
    }
    //Q11
    public int[] intersaction(int[] array1, int[] array2){
        int[]result;
        for (int i:array1){
            insert(i);
        }
        int counter=0;
        for (int i:array2){
            if(search(i)!=null){
                counter++;
            }
        }
        result = new int[counter];
        int index=0;
        for (int i:array2){
            if(search(i)!=null){
                result[index++]=i;
            }
        }
        return result;
    }
    //Q2
    int numberOfEmptySlots(){
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (table[i]==null) {count++;}
        }
        return count;
    }
    //Q3
    void delete(int X){
        int address = hashFunction(X);
        Node current = table[address].getHead();
        Node prev = null;
        while (current!=null){
            if(current.data==X){
                if(prev==null){table[address].head=current.next;}
                else{prev.next=current.next;}
                current=current.getNext();
            }
            else{
                prev = current;
                current = current.getNext();
            }
        }
    }

}
