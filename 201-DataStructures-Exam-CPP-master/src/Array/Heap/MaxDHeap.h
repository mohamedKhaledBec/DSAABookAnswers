//
// Created by Olcay Taner YILDIZ on 18.05.2023.
//

#ifndef DATASTRUCTURES_CPP_MAXDHEAP_H
#define DATASTRUCTURES_CPP_MAXDHEAP_H


#include "DHeap.h"

class MaxDHeap : public DHeap{
public:
    MaxDHeap(int N, int d);
protected:
    void percolateDown(int no) override;
    void percolateUp(int no) override;
    void update(int k, int newValue) override;

    int shortestDistanceBetweenNodes(int index1, int index2);

    int howManyPairCanBeSwapped();
};


#endif //DATASTRUCTURES_CPP_MAXDHEAP_H
