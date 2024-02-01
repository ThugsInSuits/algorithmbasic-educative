package educative_algorithm_study.algorithms.graph_algorithms;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/30 23:29
 * Version 1.0
 * @description
 **/
public class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public Graph(int vertices){
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source,int destination) {
        adjacencyList[source].add(destination);

    }

    public int getVertices(){
        return this.vertices;
    }

    public LinkedList<Integer>[] getAdj(){
        return this.adjacencyList;
    }

    public Graph geTranspose() {
        Graph g = new Graph(vertices);
        for (int i = 0; i < vertices; i++) {
            Iterator<Integer> iterator = adjacencyList[i].listIterator();
            while (iterator.hasNext()) {
                g.adjacencyList[iterator.next()].add(i);
            }
        }
        return g;
    }
}
