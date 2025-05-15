//
// Created by Olcay Taner YILDIZ on 19.12.2023.
//
#include "List/Graph/Graph.h"



using namespace list;
using namespace std;

int main(){
    Graph g = Graph(10);
    g.addEdge(1, 2);
    g.addEdge(2, 4);
   int a = 0;
    int b = 1;
    int c = 2;
    int d = 3;
    int e = 4;
    int f = 5;
    int g1 = 6;
    int h = 7;
    int i = 8;
    int j = 9;

    g.addEdge(a, b);
    g.addEdge(b, c);
    g.addEdge(c, d);
    g.addEdge(d, e);
    g.addEdge(e, f);
    g.addEdge(f, g1);
    g.addEdge(g1, h);
    g.addEdge(h, i);
    g.addEdge(i, j);
    
}