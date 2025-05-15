cmake_minimum_required(VERSION 3.23)
project(Exam_CPP)

set(CMAKE_CXX_STANDARD 20)

add_library(Exam_CPP src/Array/Graph/Graph.cpp src/Array/Graph/Graph.h src/General/AbstractGraph.cpp
        src/General/AbstractGraph.cpp src/General/Path.cpp src/General/Path.h src/Array/DisjointSet.cpp src/Array/DisjointSet.h
        src/Array/Element.h src/Array/Element.cpp src/Array/Hash.cpp src/Array/Hash.h src/Array/Queue.h src/Array/Queue.cpp
        src/Array/Set.cpp src/Array/Set.h src/Array/Stack.h src/Array/Stack.cpp src/Array/Heap/DHeap.cpp src/Array/Heap/DHeap.h
        src/Array/Heap/Heap.cpp src/Array/Heap/Heap.h src/Array/Heap/HeapNode.cpp src/Array/Heap/HeapNode.h src/Array/Heap/MaxDHeap.cpp
        src/Array/Heap/MaxDHeap.h src/Array/Heap/MaxHeap.cpp src/Array/Heap/MaxHeap.h src/Array/Heap/MinDHeap.cpp src/Array/Heap/MinDHeap.h
        src/Array/Heap/MinHeap.cpp src/Array/Heap/MinHeap.h src/Tree/Tree.cpp src/Tree/Tree.h src/Tree/TreeNode.cpp src/Tree/TreeNode.h
        src/List/Graph/Edge.cpp src/List/Graph/Edge.h src/List/Graph/EdgeList.cpp src/List/Graph/EdgeList.h src/List/DoublyLinkedList.h
        src/List/DoublyLinkedList.cpp src/List/DoublyNode.h src/List/DoublyNode.cpp src/List/Hash.h src/List/Hash.cpp src/List/LinkedList.h
        src/List/LinkedList.cpp src/List/Node.h src/List/Node.cpp src/List/Queue.cpp src/List/Queue.h src/List/Stack.cpp src/List/Stack.h
        src/Tree/Queue.h src/Tree/Queue.cpp src/Tree/Stack.h src/Tree/Stack.cpp src/Tree/Element.h src/Tree/Element.cpp src/List/Graph/Graph.cpp
        src/List/Graph/Graph.h src/List/Graph/Edge.cpp src/List/Graph/Edge.h src/List/Graph/EdgeList.cpp src/List/Graph/EdgeList.h)

add_executable(ExamTest1 src/Array/Graph/Graph.cpp src/Array/Graph/Graph.h src/General/AbstractGraph.cpp
        src/General/AbstractGraph.cpp src/General/Path.cpp src/General/Path.h src/Array/DisjointSet.cpp src/Array/DisjointSet.h
        src/Array/Element.h src/Array/Element.cpp src/Array/Hash.cpp src/Array/Hash.h src/Array/Queue.h src/Array/Queue.cpp
        src/Array/Set.cpp src/Array/Set.h src/Array/Stack.h src/Array/Stack.cpp src/Array/Heap/DHeap.cpp src/Array/Heap/DHeap.h
        src/Array/Heap/Heap.cpp src/Array/Heap/Heap.h src/Array/Heap/HeapNode.cpp src/Array/Heap/HeapNode.h src/Array/Heap/MaxDHeap.cpp
        src/Array/Heap/MaxDHeap.h src/Array/Heap/MaxHeap.cpp src/Array/Heap/MaxHeap.h src/Array/Heap/MinDHeap.cpp src/Array/Heap/MinDHeap.h
        src/Array/Heap/MinHeap.cpp src/Array/Heap/MinHeap.h src/Tree/Tree.cpp src/Tree/Tree.h src/Tree/TreeNode.cpp src/Tree/TreeNode.h
        src/List/Graph/Edge.cpp src/List/Graph/Edge.h src/List/Graph/EdgeList.cpp src/List/Graph/EdgeList.h src/List/DoublyLinkedList.h
        src/List/DoublyLinkedList.cpp src/List/DoublyNode.h src/List/DoublyNode.cpp src/List/Hash.h src/List/Hash.cpp src/List/LinkedList.h
        src/List/LinkedList.cpp src/List/Node.h src/List/Node.cpp src/List/Queue.cpp src/List/Queue.h src/List/Stack.cpp src/List/Stack.h
        src/Tree/Queue.h src/Tree/Queue.cpp src/Tree/Stack.h src/Tree/Stack.cpp src/Tree/Element.h src/Tree/Element.cpp src/ExamTest1.cpp src/List/Graph/Graph.cpp
        src/List/Graph/Graph.h src/List/Graph/Edge.cpp src/List/Graph/Edge.h src/List/Graph/EdgeList.cpp src/List/Graph/EdgeList.h)

add_executable(ExamTest2 src/Array/Graph/Graph.cpp src/Array/Graph/Graph.h src/General/AbstractGraph.cpp
        src/General/AbstractGraph.cpp src/General/Path.cpp src/General/Path.h src/Array/DisjointSet.cpp src/Array/DisjointSet.h
        src/Array/Element.h src/Array/Element.cpp src/Array/Hash.cpp src/Array/Hash.h src/Array/Queue.h src/Array/Queue.cpp
        src/Array/Set.cpp src/Array/Set.h src/Array/Stack.h src/Array/Stack.cpp src/Array/Heap/DHeap.cpp src/Array/Heap/DHeap.h
        src/Array/Heap/Heap.cpp src/Array/Heap/Heap.h src/Array/Heap/HeapNode.cpp src/Array/Heap/HeapNode.h src/Array/Heap/MaxDHeap.cpp
        src/Array/Heap/MaxDHeap.h src/Array/Heap/MaxHeap.cpp src/Array/Heap/MaxHeap.h src/Array/Heap/MinDHeap.cpp src/Array/Heap/MinDHeap.h
        src/Array/Heap/MinHeap.cpp src/Array/Heap/MinHeap.h src/Tree/Tree.cpp src/Tree/Tree.h src/Tree/TreeNode.cpp src/Tree/TreeNode.h
        src/List/Graph/Edge.cpp src/List/Graph/Edge.h src/List/Graph/EdgeList.cpp src/List/Graph/EdgeList.h src/List/DoublyLinkedList.h
        src/List/DoublyLinkedList.cpp src/List/DoublyNode.h src/List/DoublyNode.cpp src/List/Hash.h src/List/Hash.cpp src/List/LinkedList.h
        src/List/LinkedList.cpp src/List/Node.h src/List/Node.cpp src/List/Queue.cpp src/List/Queue.h src/List/Stack.cpp src/List/Stack.h
        src/Tree/Queue.h src/Tree/Queue.cpp src/Tree/Stack.h src/Tree/Stack.cpp src/Tree/Element.h src/Tree/Element.cpp src/ExamTest2.cpp src/List/Graph/Graph.cpp
        src/List/Graph/Graph.h src/List/Graph/Edge.cpp src/List/Graph/Edge.h src/List/Graph/EdgeList.cpp src/List/Graph/EdgeList.h)
