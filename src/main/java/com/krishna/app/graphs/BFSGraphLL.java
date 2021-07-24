package com.krishna.app.graphs;

import java.util.LinkedList;
import java.util.ListIterator;

public class BFSGraphLL {
    private int V;   // No. of vertices
    private LinkedList<Integer> adjGraph[]; //Adjacency Lists

    public BFSGraphLL(int v) {
        V = v;
        adjGraph = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjGraph[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adjGraph[v].add(w);
    }

    void BFS(int s) {
        System.out.println("BFS order is:");
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s]= true;
        while(!queue.isEmpty()) {
            s = queue.poll();
            System.out.print(s);
            ListIterator<Integer> list = adjGraph[s].listIterator();
            while (list.hasNext()) {
                Integer n = list.next();
                if(!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSGraphLL BFSGraphLL = new BFSGraphLL(9);
        BFSGraphLL.addEdge(0, 1);
        BFSGraphLL.addEdge(0, 2);
        BFSGraphLL.addEdge(1, 2);
        BFSGraphLL.addEdge(2, 0);
        BFSGraphLL.addEdge(2, 3);
        BFSGraphLL.addEdge(3, 3);
        BFSGraphLL.addEdge(4, 5);
        BFSGraphLL.addEdge(5, 6);
        BFSGraphLL.addEdge(6, 4);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        BFSGraphLL.BFS(2);
    }
}
