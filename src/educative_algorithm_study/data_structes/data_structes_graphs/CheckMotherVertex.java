package educative_algorithm_study.data_structes.data_structes_graphs;

import educative_algorithm_study.data_structes.data_structes_list.DoublyLinkedList;

import java.util.Arrays;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/26 20:49
 * Version 1.0
 * @description
 **/
public class CheckMotherVertex {
    public static int findMotherVertex(Graph g) {
        boolean[] visited = new boolean[g.vertices];
        Arrays.fill(visited,false);

        int lastV = 0;
        for (int i = 0; i < g.vertices; i++) {
            if (visited[i] == false) {
                DFS(g,i,visited);
                lastV = i;
            }
        }

        Arrays.fill(visited,false);
        DFS(g,lastV,visited);

        for (int i = 0; i < g.vertices; i++) {
            if (visited[i] == false) {
                return -1;
            }
        }
        return lastV;
    }

    private static void DFS(Graph g, int node, boolean[] visited) {
        visited[node] = true;

        DoublyLinkedList<Integer>.Node temp = null;
        if (g.adjacencyList[node] != null) {
            temp = g.adjacencyList[node].headNode;
        }

        while (temp != null) {
            if (visited[temp.data]) {
                temp = temp.nextNode;
            }else {
                visited[temp.data] = true;
                DFS(g,temp.data,visited);
                temp = temp.nextNode;
            }
        }
    }

    public static void main(String args[]) {

        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertex(g));

    }

}
