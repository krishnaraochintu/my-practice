package com.krishna.app.graphs;

import java.util.LinkedList;
import java.util.ListIterator;

public class DFSGraphLL {
    private int V;   // No. of vertices
    private LinkedList<Integer> adjGraph[]; //Adjacency Lists

    public DFSGraphLL(int v) {
        V = v;
        adjGraph = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjGraph[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adjGraph[v].add(w);
    }

    void DFSTraversing(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        ListIterator<Integer> list = adjGraph[s].listIterator();
        while (list.hasNext()) {
            Integer n = list.next();
            if (!visited[n]) {
                DFSTraversing(n, visited);
            }
        }
    }

    public void DFS(int s) {
        System.out.println("BFS order is:");
        boolean visited[] = new boolean[V];
        DFSTraversing(s, visited);
        System.out.println("");
    }

    public void DFS() {//Disconnected Graph
        System.out.println("BFS order is:");
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] == false)
                DFSTraversing(i, visited);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        DFSGraphLL graphLL = new DFSGraphLL(9);
        graphLL.addEdge(0, 1);
        graphLL.addEdge(0, 2);
        graphLL.addEdge(1, 2);
        graphLL.addEdge(2, 0);
        graphLL.addEdge(2, 3);
        graphLL.addEdge(3, 3);
        graphLL.addEdge(4, 5);
        graphLL.addEdge(5, 6);
        graphLL.addEdge(6, 4);

        System.out.println("Following is Depth First Traversal " +
                "(starting from any where)");

        graphLL.DFS(2);
        graphLL.DFS();
    }
}
