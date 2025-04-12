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
            if(table[i] != null && !deleted[i]){// if it exsits in table and not duplicate
                if (result.search(table[i].getData())==null){
                    result.insert(table[i].getData());
                }
            }
        }
        return result;
    }
}
