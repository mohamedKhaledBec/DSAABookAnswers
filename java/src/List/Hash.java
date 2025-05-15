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
    //Q8
    boolean perfecMap(){
        for (int i = 0; i < N; i++){
            int count=0;
            Node current = table[i].getHead();
            while (current!=null){
                count++;
                current=current.getNext();
            }
            if(count>1){return false;}
        }
        return true;
    }
    //Q9
    static int numberOfExtras(int[] array){
        int count = 0;
        Hash hash = new Hash(array.length);
        for (int i:array){
            if(hash.search(i)!=null){count++;}
            else{hash.insert(i);}
        }
        return count;
    }
    //Q10
    static int[] sortByHashing(int[] array){
        int max = array[0];
        int min = array[0];
        Hash hash = new Hash(array.length);
        int[] result = new int[array.length];
        for (int i:array){
            if(i>max){max=i;}
            if(i<min){min=i;}
            hash.insert(i);
        }
        int index=0;
        for (int i = min; i<max; i++){
            if(hash.search(i)!=null){result[index++]=i;}
        }
        return result;
    }
    //q12
    static boolean sumOfTwoK(int[] array, int k){
        Hash hash = new Hash(array.length);
        for (int i:array){
            hash.insert(i);
        }
        for (int i:array){
            int remaining = k-array[i];
            if(hash.search(remaining)!=null){return true;}
        }
        return false;
    }
    //q13 //review
    boolean isValid(){
        for (int i = 0; i <N; i++){
            boolean rFlag=false;
            int counter=1;
            Node current = table[i].getHead();
            Node prv=null;
            while (current.next!=null){
                prv=current;
                current=current.next;
                if(prv.data==current.data){
                    if(!rFlag){rFlag=true;}
                    counter+=1;
                }
                else {
                    if (rFlag) {
                        if (counter == 2) {return false;}
                        else{rFlag=false;}
                    }
                }
            }
        }
        return true;
    }
    //Q14
   static boolean sumOfFourK(int[] array, int k){
        Hash sums = new Hash(array.length);

        int index=0;
        for (int i=0;i<array.length-1;i++){
            for (int j=0;j<array.length;j++){
                sums.insert(array[i]+array[j]);

            }
        }
        int checkIndex=0;
        for(int i=0; i<array.length;i++){
            for (int j=0;j<array.length;j++){
                int sum = array[i]+array[j];
                int remaining=k-sum;
                if(sums.search(sum)!=null){return true;}
            }
        }
        return false;
    }
}
