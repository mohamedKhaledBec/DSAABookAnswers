//
// Created by Olcay Taner YILDIZ on 18.05.2023.
//

#ifndef DATASTRUCTURES_CPP_MAXHEAP_H
#define DATASTRUCTURES_CPP_MAXHEAP_H


#include "Heap.h"

class MaxHeap : public Heap{
protected:
    void percolateDown(int no) override;
    void percolateUp(int no) override;
public:
    explicit MaxHeap(int N);
    void update(int k, int newValue) override;
    void printLargerThanx (int X);
    HeapNode minDescendant (int index);

    double sumOfDescendants(int index);

    void printLeaves();
};


#endif //DATASTRUCTURES_CPP_MAXHEAP_H
