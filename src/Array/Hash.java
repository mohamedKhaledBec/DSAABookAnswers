package Array;

public class Hash {

    private Element[] table;

    private boolean[] deleted;

    private int N;

    public Hash(int N){
        table = new Element[N];
        deleted = new boolean[N];
        this.N = N;
    }

    private int hashFunction(int value){
        return value % N;
    }

    public Element search(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null){
            if (!deleted[address] && table[address].getData() == value){
                break;
            }
            address = (address + 1) % N;
        }
        return table[address];
    }
    public void insert(int value){
        int address;
        address = hashFunction(value);
        while (table[address] != null && !deleted[address]){
            address = (address + 1) % N;
        }
        if (table[address] != null){
            deleted[address] = false;
        }
        table[address] = new Element(value);
    }
//    //Q5
//    public boolean anyDuplicates(int[] array){
//        for (int i:array){
//            if(this.search(i)!=null){
//                return true;
//            }
//            this.insert(i);
//        }
//        return false;
//    }
   // Q6
    public Hash simplify(){
        Hash result=new Hash(N);
        for (int i = 0; i < N; i++){
            if(table[i] != null && !deleted[i]){// if it exsits in table and not duplicate
                if (result.search(table[i].getData())==null){
                    result.insert(table[i].getData());
                }
            }
        }
        return result;
    }
    //Q1
    boolean jollyJumper(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }

        int n = sequence.length;
        // Create a hash table to store differences
        Hash hashTable = new Hash(n); // Size n is sufficient

        // Compute and insert absolute differences
        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(sequence[i] - sequence[i + 1]);
            if (diff == 0 || diff >= n) {
                return false; // Invalid difference
            }
            hashTable.insert(diff);
        }

        // Check if all values from 1 to n-1 are present
        for (int i = 1; i <= n - 1; i++) {
            if (hashTable.search(i) == null) {
                return false; // Missing a required difference
            }
        }

        return true;
    }
    //Q2
    int numberOfEmptySlots(){
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (deleted[i]||table[i]==null) {count++;}
        }
        return count;
    }
    //Q3
    void delete(int X){
        int address = hashFunction(X);
        while(table[address]!=null){
            if(table[address].getData()==X&& !deleted[address]){break;}
            address = (address + 1) % N;
        }
        deleted[address] = true;
    }
    //Q4
    int hashfunctionSelf(){
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += table[i].getData();
        }
        return hashFunction(sum);
    }
    //Q5
    static boolean anyDuplicates(int[] array){
        Hash hashTable = new Hash(array.length);
        for (int i : array) {
            if (hashTable.search(i)==null) {hashTable.insert(i);}
            else {return true;}
        }
        return false;
    }
    //Q7
    int numberOFClusters(){
        int count = 0;
        boolean khara3aolcay=false;
       for (int i = 0; i < N; i++) {
           if(table[i]!=null&&!khara3aolcay){
               count++;
               khara3aolcay=true;
           }
           if(table[i]==null&&  khara3aolcay){
               khara3aolcay=false;
           }
       }
        return count;
    }

}
