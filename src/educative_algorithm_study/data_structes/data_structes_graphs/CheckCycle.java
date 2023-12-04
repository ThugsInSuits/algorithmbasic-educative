package educative_algorithm_study.data_structes.data_structes_graphs;

import educative_algorithm_study.data_structes.data_structes_list.DoublyLinkedList;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/26 19:42
 * Version 1.0
 * @description
 **/
public class CheckCycle {
    public static boolean detectCycle(Graph g) {
        int num_of_vertices = g.vertices;

        boolean[] visited = new boolean[g.vertices];
        boolean[] stackFlag = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            if (cyclic(g,i,visited,stackFlag)) {
                return true;
            }
        }
        return false;
    }

    private static boolean cyclic(Graph g, int i, boolean[] visited, boolean[] stackFlag) {
        if (stackFlag[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        visited[i] =true;
        stackFlag[i] =true;

        DoublyLinkedList<Integer>.Node node = null;
        if (g.adjacencyList[i] != null) {
            node = g.adjacencyList[i].headNode;
        }

        while (node != null) {
            if (cyclic(g,node.data,visited,stackFlag)) {
                return true;
            }
            node = node.nextNode;
        }
        stackFlag[i] =false;
        return false;
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
    }

}
