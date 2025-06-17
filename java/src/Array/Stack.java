package Array;

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

    // Ex 1: Check if parenthesis sequence with only '(' and ')' is balanced
    boolean isBalanced(String s){
        Stack stack = new Stack(s.length());
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(new Element(1));
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to check balanced parentheses using stack
    }

    // Ex 2: Check if parenthesis sequence with '(', '{', '[', ')', '}', ']' is balanced
    boolean isBalancedComplex(String s){
        Stack stack = new Stack(s.length());
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(new Element(c));
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false;
                Element top = stack.pop();
                if (!((c == ')' && top.getData() == '(') ||
                      (c == '}' && top.getData() == '{') ||
                      (c == ']' && top.getData() == '['))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method for complex parenthesis balancing
    }

    // Ex 3: Enlarge stack to hold twice as many elements
    void enlarge(){
        Element[] newArray = new Element[N * 2];
        for (int i = 0; i <= top; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        N = N * 2;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to double stack capacity
    }

    // Ex 4: Check if a string is a palindrome
    boolean palindrom(String s){
        Stack stack = new Stack(s.length());
        for (char c : s.toCharArray()) {
            stack.push(new Element(c));
        }
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.pop().getData() != c) {
                return false;
            }
        }
        return true;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added palindrome check using stack
    }

    // Ex 5: Return bottom element using only pop, push, isEmpty
    Element bottom(){
        Stack temp = new Stack(N);
        Element bottom = null;
        while (!isEmpty()) {
            bottom = pop();
            temp.push(bottom);
        }
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        return bottom;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to retrieve bottom element
    }

    // Ex 6: Multiply last two popped elements (array implementation)
    int multiply(){
        if (top < 1) return 0;
        int a = array[top].getData();
        int b = array[top - 1].getData();
        top -= 2;
        return a * b;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to multiply top two elements
    }

    // Ex 7: Remove bottom element using only pop, push, isEmpty
    void removeBottom(){
        Stack temp = new Stack(N);
        while (!isEmpty()) {
            temp.push(pop());
        }
        temp.pop();
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to remove bottom element
    }

    // Ex 8: Return a copy of the stack (array implementation)
    Stack copy(){
        Stack newStack = new Stack(N);
        newStack.top = top;
        for (int i = 0; i <= top; i++) {
            newStack.array[i] = new Element(array[i].getData());
        }
        return newStack;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to copy stack
    }

    // Ex 9: Double each item in the stack
    void doubleStack(){
        Stack temp = new Stack(N * 2);
        while (!isEmpty()) {
            Element e = pop();
            temp.push(e);
            temp.push(new Element(e.getData()));
        }
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to duplicate each stack element
    }

    // Ex 10: Remove middle element using only pop, push, isEmpty
    void removeMiddle(){
        Stack temp = new Stack(N);
        int size = 0;
        while (!isEmpty()) {
            temp.push(pop());
            size++;
        }
        int middle = size / 2;
        int count = 0;
        while (!temp.isEmpty()) {
            if (count != middle) {
                push(temp.pop());
            } else {
                temp.pop();
            }
            count++;
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to remove middle element
    }

    // Ex 11: Remove K bottom elements
    void removeBottomK(int K){
        Stack temp = new Stack(N);
        while (!isEmpty()) {
            temp.push(pop());
        }
        for (int i = 0; i < K && !temp.isEmpty(); i++) {
            temp.pop();
        }
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added method to remove K bottom elements
    }

    // Ex 13: Remove odd-indexed elements (already provided, fixed)
    void removeOddIndexed(){
        Stack temp = new Stack(N);
        int index = 1;
        while (!isEmpty()) {
            temp.push(pop());
        }
        while (!temp.isEmpty()) {
            if (index % 2 == 0) {
                push(temp.pop());
            } else {
                temp.pop();
            }
            index++;
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed logic to correctly remove odd-indexed elements
    }

    // Ex 14: Pop k'th element (already provided, verified)
    Element pop(int k){
        int popIndex = top - k + 1;
        Element popped = array[popIndex];
        for (int i = popIndex; i < top; i++) {
            array[i] = array[i + 1];
        }
        top--;
        return popped;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Verified correct implementation
    }

    // Ex 15: Compress stack (already provided, fixed)
    void compress(){
        Stack temp = new Stack(N);
        Element prevPopped = pop();
        temp.push(prevPopped);
        while (!isEmpty()) {
            Element popped = pop();
            if (prevPopped.getData() != popped.getData()) {
                temp.push(popped);
            }
            prevPopped = popped;
        }
        while (!temp.isEmpty()) {
            push(temp.pop());
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed variable naming and logic for clarity
    }

    // Ex 16: Push data as k'th element (already provided, fixed)
    void push(int k, int data){
        if (top - k + 1 < 0 || top == N - 1) return;
        for (int i = top; i >= top - k + 1; i--) {
            array[i + 1] = array[i];
        }
        array[top - k + 1] = new Element(data);
        top++;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Added bounds check and incremented top
    }

    // Ex 17: Remove even-indexed elements (already provided, fixed)
    void removeEvenIndexed(){
        Stack temp = new Stack(N);
        int index = 1;
        while (!isEmpty()) {
            temp.push(pop());
        }
        while (!temp.isEmpty()) {
            if (index % 2 == 1) {
                push(temp.pop());
            } else {
                temp.pop();
            }
            index++;
        }
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Simplified logic and removed unnecessary List.Stack reference
    }

    // Ex 19: Check if integer array is balanced (already provided, verified)
    boolean isBalanced(int[] a){
        Stack stack = new Stack(a.length);
        for (int i : a) {
            if (i < 10) {
                stack.push(new Element(i));
            } else if (i > 10) {
                if (stack.isEmpty() || stack.pop().getData() != i - 10) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Verified correct implementation
    }

    // Ex 21: Insert after largest element (already provided, fixed)
    void insertAfterLargest(int s){
        int largest = Integer.MIN_VALUE;
        int largestIndex = -1;
        for (int i = 0; i <= top; i++) {
            if (array[i].getData() > largest) {
                largest = array[i].getData();
                largestIndex = i;
            }
        }
        if (largestIndex == -1 || top == N - 1) return;
        for (int i = top; i > largestIndex; i--) {
            array[i + 1] = array[i];
        }
        array[largestIndex + 1] = new Element(s);
        top++;
        // Created by Mohamed Khaled Becetti
        // Edited by AI: Fixed loop bounds and added top increment
    }
}