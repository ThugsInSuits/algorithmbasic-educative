package educative_algorithm_study.algorithms.graph_algorithms;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/31 21:29
 * Version 1.0
 * @description
 **/
public class CountNodes {
    public static int numberOfNodesInGivenLevel(Graph g, int source, int level) {
        int count = 0; //count initialized to zero
        int num_of_vertices = g.getVertices(); //getVertices given in Graph.java file
        int[] visited = new int[num_of_vertices];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[source] = 1;
        queue.add(source);

        while (queue.size() != 0 ) {
            source = queue.poll();
            LinkedList<Integer>[] list;
            list = g.getAdj();
            Iterator<Integer> i = list[source].listIterator();

            while (i.hasNext()) {
                int temp = i.next();
                if (visited[temp] != 1) {
                    visited[temp] = visited[source] + 1;
                }
                if (visited[temp] < level) {
                    queue.add(temp);
                }
            }
        }

        for (int i = 0;i < num_of_vertices;i++) {
            if (visited[i] == level) {
                count++;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 5);
        g.addEdge(2, 4);

        int answer;

        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 1);
        System.out.println(answer);
        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 2);
        System.out.println(answer);
        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 3);
        System.out.println(answer);
        answer = CountNodes.numberOfNodesInGivenLevel(g, 0, 4);
        System.out.println(answer);
    }
}
