package com.krishna.app.graphs;

import java.util.*;

public class DijkstraDPQ {
    private int V;
    private int dist[];
    private PriorityQueue<Node> priorityQueue;
    private Set<Integer> visited;
    List<List<Node>> adjList;

    public DijkstraDPQ(int vertices) {
        this.V = vertices;
        dist = new int[V];
        priorityQueue =  new PriorityQueue<>(V, new Node());
        visited = new HashSet<>();
    }
    public void dijkstra(List<List<Node>> adjList, int source) {
        this.adjList = adjList;
        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        priorityQueue.add(new Node(source,  0));
        dist[source] = 0;
        while(visited.size() != V) {
            if(priorityQueue.isEmpty()) return;
            int u = priorityQueue.remove().node;
            visited.add(u);
            e_Neighbours(u);
        }
    }

    private void e_Neighbours(int u) {
        List<Node> nodeList = adjList.get(u);
        for(int i=0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);
            if(!visited.contains(node.node)) {
                // take, A, B,C then
                //d[B] = Math.min(d[B], d[A] + d[A,B])
                dist[node.node] = Math.min(dist[node.node], (dist[u] + node.cost));
                priorityQueue.add(new Node(node.node, dist[node.node]));
            }
        }
    }

    public static void main(String[] args) {
        List<List<Node>> adjList = new ArrayList<List<Node>>();
        int vertices = 5;
        int source = 0;
        for(int i=0; i < vertices; i++) {
            adjList.add(new ArrayList<Node>());
        }
        adjList.get(0).add(new Node(1, 9));
        adjList.get(0).add(new Node(2, 6));
        adjList.get(0).add(new Node(3, 5));
        adjList.get(0).add(new Node(4, 3));
        adjList.get(2).add(new Node(1, 2));
        adjList.get(2).add(new Node(3, 4));
        DijkstraDPQ dpqShortestPath = new DijkstraDPQ(vertices);
        dpqShortestPath.dijkstra(adjList, source);
        System.out.println("The shorted path from node :");
        for (int i = 0; i < dpqShortestPath.dist.length; i++)
            System.out.println(source + " to " + i + " is "
                    + dpqShortestPath.dist[i]);
    }

    static class Node implements Comparator<Node> {
        public int node;
        public int cost;

        public Node() {
        }

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compare(Node node1, Node node2) {
            if(node1.cost < node2.cost) return -1;
            if(node1.cost > node2.cost) return 1;
            return 0;
        }
    }
}
