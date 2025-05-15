//
// Created by Olcay Taner YILDIZ on 18.05.2023.
//

#include "MinHeap.h"

#include <algorithm>

void MinHeap::percolateDown(int no) {
    int left, right;
    left = 2 * no + 1;
    right = 2 * no + 2;
    while ((left < count && array[no].getData() > array[left].getData()) ||
           (right < count && array[no].getData() > array[right].getData())){
        if (right >= count || array[left].getData() < array[right].getData()){
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

void MinHeap::percolateUp(int no) {
    int parent;
    parent = (no - 1) / 2;
    while (parent >= 0 && array[parent].getData() > array[no].getData()){
        swapNode(parent, no);
        no = parent;
        parent = (no - 1) / 2;
    }
}

void MinHeap::update(int k, int newValue) {
    int oldValue = array[k].getData();
    array[k].setData(newValue);
    if (oldValue < newValue){
        percolateDown(k);
    } else {
        percolateUp(k);
    }
}

MinHeap::MinHeap(int N) : Heap(N) {
}
int MinHeap :: kthMaximum (int* array, int k) {

    for ( int i :array) {
        if (this->count<k){this->insert( HeapNode (i,i));}
        else if (i > this->array[0].getData()) {
            this->deleteTop();
            this->insert(HeapNode (i,i));
        }
    }
    return this->array[0].getData();
}
int MinHeap :: howManyChildrenCanBeSwapped() {
    int count = 0;
    for (int i =0 ; i < this->count; i++) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int rightright = right * 2 + 1;
        int rightleft = right * 2 + 2;
        int leftright = left * 2 + 1;
        int leftleft = left * 2 + 2;
        bool left2right = (rightright<count || rightleft<count) ? (array[left].getData()<std::max(array[rightright].getData(),array[rightleft].getData())) : true;
        bool right2left = ;//same as prev
        if (right2left&& left2right)count++;
    }
    return count;
}
bool MinHeap::isLargestLeftMost () {

    int i = 0;
    while (i*2+1<count)i=i*2 + 1;

    int leftMost = this->array[i].getData();
    const int j = i;
    for ( i = 0; i<count; i++) { if (j!=i&&this->array[i].getData()>leftMost)return false;}
    return true;
}

