package com.krishna.app.graphs;


import java.util.*;

public class Prim {
    private List<Vertex> graph;

    public Prim(List<Vertex> graph) {
        this.graph = graph;
        run();
    }

    public void run() {
        if (graph.size() > 0) {
            graph.get(0).setVisited(true);
        }
        while (isDisconnected()) {
            Edge nextMinimum = new Edge(Integer.MAX_VALUE);
            Vertex nextVertex = graph.get(0);
            for (Vertex vertex : graph) {
                if (vertex.isVisited()) {
                    Pair<Vertex, Edge> candidate = vertex.nextMinimum();
                    if (candidate.getValue().getWeight() < nextMinimum.getWeight()) {
                        nextMinimum = candidate.getValue();
                        nextVertex = candidate.getKey();
                    }
                }
            }
            nextMinimum.setIncluded(true);
            nextVertex.setVisited(true);
        }
    }

    private boolean isDisconnected() {
        for (Vertex vertex : graph) {
            if (!vertex.isVisited()) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        List<Vertex> graph = new ArrayList<>();
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Edge ab = new Edge(2);
        a.addEdge(b, ab);
        b.addEdge(a, ab);
        Edge ce = new Edge(1);
        c.addEdge(e, ce);
        e.addEdge(c, ce);
        graph.add(a);
        graph.add(e);
        Prim prim = new Prim(graph);
    }


    static public class Edge {
        private int weight;
        private boolean isIncluded = false;

        public Edge(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public boolean isIncluded() {
            return isIncluded;
        }

        public void setIncluded(boolean included) {
            isIncluded = included;
        }
    }

    static public class Vertex {
        private String label = null;
        private Map<Vertex, Edge> edges = new HashMap<>();
        private boolean isVisited = false;

        public Vertex(String label) {
            this.label = label;
        }

        public void addEdge(Vertex v, Edge e) {
            edges.put(v, e);
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public Map<Vertex, Edge> getEdges() {
            return edges;
        }

        public void setEdges(Map<Vertex, Edge> edges) {
            this.edges = edges;
        }

        public boolean isVisited() {
            return isVisited;
        }

        public void setVisited(boolean visited) {
            isVisited = visited;
        }

        public Pair<Vertex, Edge> nextMinimum() {
            Edge nextMinimum = new Edge(Integer.MAX_VALUE);
            Vertex nextVertex = this;
            Iterator<Map.Entry<Vertex, Edge>> it = edges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Vertex, Edge> pair = it.next();
                if (!pair.getKey().isVisited()) {
                    if (!pair.getValue().isIncluded()) {
                        if (pair.getValue().getWeight() < nextMinimum.getWeight()) {
                            nextMinimum = pair.getValue();
                            nextVertex = pair.getKey();
                        }
                    }
                }
            }
            return new Pair(nextVertex, nextMinimum);
        }
    }

    static public class Pair<K,V> {
        private K vertex;
        private V edge;

        public Pair(K vertex, V edge) {
            this.vertex = vertex;
            this.edge = edge;
        }
        public K getKey() {
            return vertex;
        }

        public V getValue() {
            return edge;
        }
    }

}
