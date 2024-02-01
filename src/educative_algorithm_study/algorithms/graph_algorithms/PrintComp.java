package educative_algorithm_study.algorithms.graph_algorithms;

import java.util.LinkedList;

/**
 * @author XiZhuangBaoTu
 * Date 2024/2/1 11:22
 * Version 1.0
 * @description
 **/
public class PrintComp {
    public static void printConnectedComponents(Graph g) {
        //write your code here
        int num_vertices = g.getVertices();
        boolean[] visited = new boolean[num_vertices];

        for (int i = 0; i < num_vertices; i++) {
            if (!visited[i]) {
                utilityFunction(g,i,visited);
                System.out.println();
            }
        }
    }

    public static void utilityFunction(Graph g,int v,boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        LinkedList<Integer>[] list = g.getAdj();
        for(int i: list[v]) {
            if (!visited[i]) {
                utilityFunction(g,i,visited);
            }
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(7);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(3, 4);
        g.addEdge(5, 3);
        g.addEdge(5, 6);
        g.addEdge(3, 6);

        System.out.println("The connected components are:");
        PrintComp.printConnectedComponents(g);
    }
}
