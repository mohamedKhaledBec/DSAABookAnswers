//
// Created by Olcay Taner YILDIZ on 18.05.2023.
//

#include "MaxHeap.h"

#include <algorithm>
#include <iostream>

void MaxHeap::percolateDown(int no) {
    int left, right;
    left = 2 * no + 1;
    right = 2 * no + 2;
    while ((left < count && array[no].getData() < array[left].getData()) ||
           (right < count && array[no].getData() < array[right].getData())){
        if (right >= count || array[left].getData() > array[right].getData()){
            swapNode(no, left);
            no = left;
        } else {
            swapNode(no, right);
            no = right;
        }
        left = 2 * no + 1;
        right = 2 * no + 2;
    }
}

void MaxHeap::percolateUp(int no) {
    int parent;
    parent = (no - 1) / 2;
    while (parent >= 0 && array[parent].getData() < array[no].getData()){
        swapNode(parent, no);
        no = parent;
        parent = (no - 1) / 2;
    }
}

void MaxHeap::update(int k, int newValue) {
    int oldValue = array[k].getData();
    array[k].setData(newValue);
    if (oldValue > newValue){
        percolateDown(k);
    } else {
        percolateUp(k);
    }
}


MaxHeap::MaxHeap(int N) : Heap(N) {
}
void MaxHeap :: printLargerThanx (int X) {
    for (int i = 0 ; i< count; i++) {
        if (this->array[i].getData() > X){ std::cout << this->array[i].getData(); << endl }
    }
}

HeapNode MaxHeap::minDescendant (int index) {
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    //base cases
    if (right>count && left<count) {
        return this->array[left].getData()<this->array[index].getData() ? this->array[left] : this->array[index];
    }
    else if (right>count && left>count ) {return this->array[index];}
    //recursive
    HeapNode leftNode = minDescendant(left);


    HeapNode rightNode = minDescendant(right);
    HeapNode minNode = leftNode.getData()<rightNode.getData() ? leftNode : rightNode;
    return minNode;
}
double MaxHeap:: sumOfDescendants(int index) {
    int left = 2 * index + 1;
    int right = 2 * index + 2;
    double sum = 0;

    if (left<count){sum +=this->array[left].getData() + sumOfDescendants(left);}
    if (right<count){sum += this->array[right].getData() + sumOfDescendants(right);}
    return sum;
}
int* ascedants (int index) {
    bool isRight = (index %2  == 0);
    bool isLeft = (index %2  == 1);

    int count = 0 ;
    int i = index ;
    while (i>=0) {
        count++;
        if (i==0){break ; }
        i = (i-1)/2;
    }
    int* result = new int[count];
    i = index; count = 0;
    while (i>=0) {
        i=((i-1)/2);
        result[count++] = i;
        if (count == 0)break;
    }
    return result;
}
void MaxHeap :: printLeaves () {

}

