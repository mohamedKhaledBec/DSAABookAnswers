//
// Created by Olcay Taner YILDIZ on 18.12.2023.
//
#include "Array/Graph/Graph.h"
#include "Array/Heap/MaxHeap.h"
#include "Array/DisjointSet.h"
#include "Array/Heap/MaxDHeap.h"
#include <iostream>
using namespace array;

int main(){
    Graph g = Graph(10);
    g.addEdge(1, 2);
    g.addEdge(2, 4);
    MaxHeap heap = MaxHeap(10);
    DisjointSet disjointSet = DisjointSet(5);
    MaxDHeap heap2 = MaxDHeap(10, 3);
    std::cout << "hello world";
}