//
// Created by Olcay Taner YILDIZ on 18.05.2023.
//

#include "MaxDHeap.h"

#include <algorithm>
#include <functional>

void MaxDHeap::percolateDown(int no) {
    int child, largestChild;
    int value;
    do{
        largestChild = -1;
        value = array[no].getData();
        for (int i = 1; i <= d && d * no + i < count; i++){
            child = d * no + i;
            if (value < array[child].getData()){
                largestChild = child;
                value = array[child].getData();
            }
        }
        if (largestChild != -1){
            swapNode(no, largestChild);
            no = largestChild;
        } else {
            break;
        }
    } while (true);
}

void MaxDHeap::percolateUp(int no) {
    int parent;
    parent = (no - 1) / d;
    while (parent >= 0 && array[parent].getData() < array[no].getData()){
        swapNode(parent, no);
        no = parent;
        parent = (no - 1) / d;
    }
}

MaxDHeap::MaxDHeap(int N, int d) : DHeap(N, d) {

}

void MaxDHeap::update(int k, int newValue) {
    int oldValue = array[k].getData();
    array[k].setData(newValue);
    if (oldValue > newValue){
        percolateDown(k);
    } else {
        percolateUp(k);
    }
}
int MaxDHeap :: shortestDistanceBetweenNodes(int index1, int index2) {
    int distance = 0;
    int* lengthArray1 = new int[100];
    int* lengthArray2 = new int[100];
    int pos = 0;
    int i = index1;
    while (i>=0) {
        lengthArray1[pos++] = i;
        if (i==0)break;
        i = i-1/2;
    }
    int pos2 = 0;
    i= index2;
    while (i>=0) {
        lengthArray2[pos2++] = i;
        if (i==0)break;
        i=i-1/2;
    }
    int intersection = 0;
    int j =pos-1,k = pos2-1;
    while (j>=0 && k>=0 && lengthArray1[j] == lengthArray2[k]) {
        intersection = lengthArray1[j];
        k--;j--;
    }
    int count=0;
    i=index1;
    while (i!=intersection) {count++;i=i-1/2;}
    i=index2;
    while (i!=intersection) {count++;i=i-1/2;}
    return count ;
}

int MaxDHeap::howManyPairCanBeSwapped() {
    int swappableCount = 0;
    for (int i = 0; i<count; i++) {
        int tmp = array[i].getData();
        bool isSwapped = true;
        for (int j = 0; j<i; j++) {
            int parent = array[j-1/d].getData();
            if (parent <tmp){isSwapped = false;break;}
            for (int k=1;k<=d;k++) {
                int child = array[j].getData();
                if (child > tmp){isSwapped = false;break;}
            }
            if (isSwapped){swappableCount++;}
        }
    }
    return swappableCount;
}
