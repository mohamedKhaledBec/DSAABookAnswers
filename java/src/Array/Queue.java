package Array;

public class Queue {

    private Element array[];
    private int first;
    private int last;
    private int N;

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

    // Q1: Insert element after k'th position (verified)
    void insertAfterKth(int k, Element element){
        int position = first;
        for (int i = 0; i < k; i++){
            position = (position + 1) % N;
        }
        int current = last;
        while (current != position){
            int prv = (current - 1 + N) % N;
            array[current] = array[prv];
            current = prv;
        }
        array[position] = element;
        last = (last + 1) % N;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Verified and fixed last increment
    }

    // Q2: Delete k'th element (verified)
    void deleteKth(int k){
        int position = first;
        for (int i = 0; i < k; i++){
            position = (position + 1) % N;
        }
        int current = position;
        while (current != last){
            int next = (current + 1) % N;
            array[current] = array[next];
            current = next;
        }
        last = (last - 1 + N) % N;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Verified correct implementation
    }

    // Q3: Return minimum element (fixed)
    int minimum(){
        if (isEmpty()) return Integer.MAX_VALUE;
        int min = array[first].getData();
        int index = (first + 1) % N;
        while (index != last){
            if (min > array[index].getData()) min = array[index].getData();
            index = (index + 1) % N;
        }
        return min;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added edge case for empty queue
    }

    // Q4: Dequeue second item (verified)
    Element dequeue2nd(){
        if ((first + 1) % N == last || isEmpty()) return null;
        int targetIndex = (first + 1) % N;
        Element tmp = array[targetIndex];
        for (int i = targetIndex; i != first; i = (i - 1 + N) % N){
            array[i] = array[(i - 1 + N) % N];
        }
        array[first] = null;
        first = (first + 1) % N;
        return tmp;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed logic to shift elements correctly
    }

    // Q5: Insert after largest element (fixed)
    void insertAfterLargest(int data){
        if (isEmpty() || isFull()) return;
        int max = array[first].getData();
        int maxIndex = first;
        int tmp = (first + 1) % N;
        while (tmp != last){
            if (array[tmp].getData() > max){
                max = array[tmp].getData();
                maxIndex = tmp;
            }
            tmp = (tmp + 1) % N;
        }
        int current = last;
        while (current != (maxIndex + 1) % N){
            int prev = (current - 1 + N) % N;
            array[current] = array[prev];
            current = prev;
        }
        array[(maxIndex + 1) % N] = new Element(data);
        last = (last + 1) % N;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed loop bounds and edge cases
    }

    // Q6: Divide queue, removing even-indexed elements (fixed)
    Queue divideQueue(){
        Queue result = new Queue(N);
        int index = 1;
        int position = first;
        while (position != last){
            if (index % 2 == 0){
                result.array[result.last] = new Element(array[position].getData());
                result.last = (result.last + 1) % result.N;
                int current = position;
                while (current != last){
                    int next = (current + 1) % N;
                    array[current] = array[next];
                    current = next;
                }
                last = (last - 1 + N) % N;
            } else {
                position = (position + 1) % N;
            }
            index++;
        }
        return result;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed indexing and simplified deletion logic
    }

    // Q7: Remove odd-indexed elements
    void removeOddIndexed(){
        Queue temp = new Queue(N);
        int index = 1;
        while (!isEmpty()){
            Element e = dequeue();
            if (index % 2 == 0){
                temp.enqueue(e);
            }
            index++;
        }
        while (!temp.isEmpty()){
            enqueue(temp.dequeue());
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to remove odd-indexed elements
    }

    // Q8: Dequeue k'th element (fixed)
    Element dequeue(int k){
        if (k < 1 || isEmpty()) return null;
        int index = first;
        for (int i = 1; i < k; i++){
            index = (index + 1) % N;
            if (index == last) return null;
        }
        Element result = array[index];
        while (index != last){
            int next = (index + 1) % N;
            array[index] = array[next];
            index = next;
        }
        last = (last - 1 + N) % N;
        return result;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed indexing and edge cases
    }

    // Q9: Copy and paste elements from src at index (verified)
    void copyPaste(Queue src, int index){
        int srcSize = 0;
        for (int i = src.first; i != src.last; i = (i + 1) % src.N){
            srcSize++;
        }
        for (int j = (last - 1 + N) % N; j != (index - 1 + N) % N; j = (j - 1 + N) % N){
            array[(j + srcSize) % N] = array[j];
        }
        for (int k = 0; k < srcSize; k++){
            array[(index + k) % N] = new Element(src.array[(src.first + k) % src.N].getData());
        }
        last = (last + srcSize) % N;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Verified correct implementation
    }

    // Q10: Constructor for concatenating queues (array-based, fixed from Q9)
    public Queue(Queue[] list){
        int size = 0;
        for (Queue q : list){
            int qSize = (q.last - q.first + q.N) % q.N;
            size += qSize;
        }
        this.N = size + 1;
        this.array = new Element[N];
        this.first = 0;
        this.last = 0;
        for (Queue q : list){
            for (int i = q.first; i != q.last; i = (i + 1) % q.N){
                array[last] = new Element(q.array[i].getData());
                last = (last + 1) % N;
            }
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed constructor to concatenate queues
    }

    // Q11: Cut and paste elements from p to q to dest
    void cutPaste(Queue dest, int p, int q){
        int size = (q - p + 1);
        int start = (first + p - 1) % N;
        for (int i = 0; i < size; i++){
            dest.array[dest.last] = new Element(array[(start + i) % N].getData());
            dest.last = (dest.last + 1) % dest.N;
        }
        int current = start;
        for (int i = 0; i < (last - start + N) % N - size; i++){
            array[(start + i) % N] = array[(start + i + size) % N];
        }
        last = (last - size + N) % N;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to cut and paste elements
    }

    // Q13: Constructor for interleaving queues
    public Queue(Queue[] list,int dummyTmp){//dummyTmp was added to avoid error due to having the constuctor twice with the same input
        int maxSize = 0;
        int totalSize = 0;
        for (Queue q : list){
            int qSize = (q.last - q.first + q.N) % q.N;
            totalSize += qSize;
            if (qSize > maxSize) maxSize = qSize;
        }
        this.N = totalSize + 1;
        this.array = new Element[N];
        this.first = 0;
        this.last = 0;
        for (int i = 0; i < maxSize; i++){
            for (Queue q : list){
                int index = (q.first + i) % q.N;
                if (index != q.last && (q.last - q.first + q.N) % q.N > i){
                    array[last] = new Element(q.array[index].getData());
                    last = (last + 1) % N;
                }
            }
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added constructor to interleave queues
    }
}