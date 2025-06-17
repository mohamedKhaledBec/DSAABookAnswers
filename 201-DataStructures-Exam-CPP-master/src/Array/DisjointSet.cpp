//
// Created by Olcay Taner YILDIZ on 6.05.2023.
//

#include "DisjointSet.h"

DisjointSet::DisjointSet(int *elements, int count) {
    sets = new Set[count];
    for (int i = 0; i < count; i++){
        sets[i] = Set(elements[i], i);
    }
    this->count = count;
}

DisjointSet::~DisjointSet() {
    delete[] sets;
}

int DisjointSet::findSetRecursive(int index) {
    int parent = sets[index].getParent();
    if (parent != index){
        return findSetRecursive(parent);
    }
    return parent;
}

int DisjointSet::findSetIterative(int index) {
    int parent = sets[index].getParent();
    while (parent != index){
        index = parent;
        parent = sets[index].getParent();
    }
    return parent;
}

DisjointSet::DisjointSet(int count) {
    sets = new Set[count];
    for (int i = 0; i < count; i++){
        sets[i] = Set(i, i);
    }
    this->count = count;
}

void DisjointSet::unionOfSets(int index1, int index2) {
    int x = findSetIterative(index1);
    int y = findSetIterative(index2);
    if (sets[x].getDepth() < sets[y].getDepth()){
        sets[x].setParent(y);
    } else {
        sets[y].setParent(x);
        if (sets[x].getDepth() == sets[y].getDepth()){
            sets[x].incrementDepth();
        }
    }
}

int DisjointSet::numberOfTriples() {
    int count = 0;
    for (int i = 0; i < this->count; i++) {
        int size=0;
        for (int j = 0; j < this->count; j++) {
            if (findSetIterative(j) == i) size++;
        }
        if (size == 3)count++;
    }
    return count;
}
int* DisjointSet::ascendants (int index) {
    int count = 1;
    int parent = sets[index].getParent();
    while (parent != index){
        count++;
        index = parent;
        parent = sets[index].getParent();
    }
    int* array = new int[count];
    int i = 0 ;
    parent = index;
    for (int j = 0; j < count; j++) {
        array[j] = parent;
        parent = sets[parent].getParent();
    }
    return array;
}

DisjointSet::DisjointSet (int count) {
    sets = new Set[count];
    for (int i = 0; i < count; i++) {
        sets[i] = Set(i, i);
    }
    for (int i = 0 ; i < count ; i++) {
        for (int j = 2*i;j<count;j+=i)unionOfSets(i,j);
    }
    this->count = count;
}
int* DisjointSet::numberOfDescendants(int index) {
    int count = 0 ;
    for (int i = 0; i < this->count; i++) {
        int current = i;
        int parent = sets[current].getParent();
        while (parent != current){
            if (current == index)count++;
            current = parent;
            parent = sets[current].getParent();
        }
    }

    int* array = new int[count];
    count =0;
    for (int i = 0; i < this->count; i++) {
        int current = i;
        int parent = sets[current].getParent();
        while (parent != current){
            if (current == index)array[count++]=i;
            current = parent;
            parent = sets[current].getParent();
        }
    }
    return array;
}
int* DisjointSet::numberOfDescendants(int index) {
    int descendantsCount = 0;
    int indexParent = findSetIterative(index);
    for (int i = 0; i < this->count; i++) {
        if ()
    }
}

