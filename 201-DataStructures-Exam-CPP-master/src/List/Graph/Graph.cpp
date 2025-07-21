//
// Created by Olcay Taner YILDIZ on 8.05.2023.
//

#include "Graph.h"
#include "../../Array/DisjointSet.h"
#include "../Queue.h"
#include "../../Array/Heap/MinHeap.h"

namespace list {

    Graph::Graph(int _vertexCount) : AbstractGraph(_vertexCount){
        edges = new EdgeList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            edges[i] = EdgeList();
        }
    }

    void Graph::addEdge(int from, int to) {
        Edge* edge = new Edge(from, to, 1);
        edges[from].insert(edge);
    }

    void Graph::addEdge(int from, int to, int weight) {
        Edge* edge = new Edge(from, to, weight);
        edges[from].insert(edge);
    }

    Graph::~Graph() {
        delete[] edges;
    }

    void Graph::depthFirstSearch(bool *visited, int fromNode) {
        Edge* edge;
        int toNode;
        edge = edges[fromNode].getHead();
        while (edge != nullptr){
            toNode = edge->getTo();
            if (!visited[toNode]){
                visited[toNode] = true;
                depthFirstSearch(visited, toNode);
            }
            edge = edge->getNext();
        }
    }

    void Graph::breadthFirstSearch(bool *vis








        Edge* edge;
        int fromNode, toNode;
        Queue queue = Queue();
        queue.enqueue(new Node(startNode));
        while (!queue.isEmpty()){
            fromNode = queue.dequeue()->getData();
            edge = edges[fromNode].getHead();
            while (edge != nullptr) {
                toNode = edge->getTo();
                if (!visited[toNode]){
                    visited[toNode] = true;
                    queue.enqueue(new Node(toNode));
                }
                edge = edge->getNext();
            }
        }
    }

    Graph Graph::reverseGraph() {
        Graph  resultGraph(this->vertexCount);
        for (int i = 0; i < this->vertexCount; i++) {
            Edge *firstEdge = edges[i].getHead();
            while (firstEdge != nullptr) {
                resultGraph.addEdge(firstEdge->getTo(),i);
                firstEdge = firstEdge->getNext();
            }
        }
        return resultGraph;
    }
    int Graph::islands() {
        int islandsCount = 0;
        for (int i = 0; i < this->vertexCount; i++) {
            bool islandInterrupt = true;
            if (edges[i].getHead() != nullptr) {
                islandInterrupt = false; continue;
            }
            for (int j = 0; j < this->vertexCount; j++) {
                Edge* edge = edges[j].getHead();
                if (edge != nullptr) {
                    while (edge!=nullptr) {
                        if (edge->getTo() == i) {islandInterrupt =false;break;}
                        edge = edge->getNext();
                    }
                }
            }
            if (islandInterrupt){islandsCount++;}
        }
        return islandsCount;
    }

}