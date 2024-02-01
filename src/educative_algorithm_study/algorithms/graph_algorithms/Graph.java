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

    public void dfsTraversal(int i, boolean[] visited) {
        Stack<Integer> stack = new Stack<>(vertices);
        stack.push(i);

        while (!stack.isEmpty()) {
            Integer current_code = stack.pop();
            System.out.println("current_code"+current_code);
            Integer ajdaNode = null;
            if (adjacencyList[current_code] != null) {
                if (!adjacencyList[current_code].isEmpty()) {
                    ajdaNode = adjacencyList[current_code].pop();
                }else {
                    ajdaNode = null;
                }
            }

            while (ajdaNode != null) {
                if (!visited[ajdaNode]) {
                    stack.push(ajdaNode);
                }
                if (!adjacencyList[current_code].isEmpty()) {
                    ajdaNode = adjacencyList[current_code].pop();
                }else {
                    ajdaNode = null;
                }
            }
            visited[current_code] = true;
        }
    }

    public void dfsTraversal2(int i,boolean[] visited) {
        visited[i] = true;

        Iterator<Integer> iterator = adjacencyList[i].iterator();
        Integer temp = 0;
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (!visited[temp]) {
                dfsTraversal2(temp,visited);
            }
        }
    }

    public void printGraph(){
        System.out.println(">>Adjacency List of Directed Graph<<");
        for (int i = 0; i < vertices; i++) {
            if (adjacencyList[i] != null) {
                System.out.print("|" + i + "| =>");
                Iterator<Integer> iterator = adjacencyList[i].listIterator();
                while (iterator.hasNext()) {
                    System.out.print("{" + iterator.next() + "] =>");
                }
                System.out.print("null");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println();
        g.dfsTraversal(0,new boolean[5]);

    }
}
