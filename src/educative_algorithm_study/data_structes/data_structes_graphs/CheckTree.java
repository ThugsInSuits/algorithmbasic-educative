package educative_algorithm_study.data_structes.data_structes_graphs;

import educative_algorithm_study.data_structes.data_structes_list.DoublyLinkedList;
import educative_algorithm_study.data_structes.data_structes_stack_queue.Stack;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/28 09:50
 * Version 1.0
 * @description
 **/
public class CheckTree {
    // 1. Each code (expect root ) has exactly one parent
    // 2. There is no cycle in graph
    // 3. The graph is connectd
    public static boolean isTree(Graph g) {
        if (!checkOneParent(g)) {
            return false;
        }

        if (detectCycle(g)) {
            return false;
        }

        if (checkConnected(g,0)) {
            return false;
        }

        return true;
    }



    private static boolean checkOneParent(Graph g) {
        int num_of_vertices = g.vertices;
        boolean[] hasOneParent = new boolean[num_of_vertices];
        for (int i = 0; i < num_of_vertices; i++) {
            DoublyLinkedList<Integer>.Node tmp = null;
            if (g.adjacencyList[i] != null) {
                tmp = g.adjacencyList[i].headNode;
                while (tmp != null) {
                    if (hasOneParent[tmp.data]) {
                        return false;
                    }
                    hasOneParent[tmp.data] = true;
                    tmp = tmp.nextNode;
                }
            }
        }
        for (int i = 0; i < num_of_vertices; i++) {
            if (i == 0 && hasOneParent[i] == true) {
                return false;
            }else if (i != 0 && hasOneParent[i] == false ) {
                return false;
            }
        }
        return true;

    }


    private static boolean detectCycle(Graph g) {
        int num_of_vertices = g.vertices;
        boolean[] visited = new boolean[num_of_vertices];
        boolean[] stackFlag = new boolean[num_of_vertices];
        for (int i = 0; i < num_of_vertices; i++) {
            if (cycli(g,i,visited,stackFlag)) {
                return true;
            }
        }
        return false;
    }

    private static boolean cycli(Graph g, int i, boolean[] visited, boolean[] stackFlag) {
        if (stackFlag[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }

        visited[i] = true;
        stackFlag[i] = true;

        DoublyLinkedList<Integer>.Node temp = null;
        if (g.adjacencyList[i] != null ){
            temp = g.adjacencyList[i].headNode;
        }

        while (temp != null) {
            if (cycli(g,temp.data,visited,stackFlag)) {
                return true;
            }
            temp = temp.nextNode;
        }
        stackFlag[i] = false;
        return false;
    }


    private static boolean checkConnected(Graph g,int source) {
        int num_of_vertices = g.vertices;
        int vertices_reached = 0;
        boolean[] visited = new boolean[num_of_vertices];
        Stack<Integer> stack = new Stack<>(num_of_vertices);
        stack.push(source);
        visited[source] = true;

        while (!stack.isEmpty()) {
            int current_node = stack.pop();

            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null) {
                temp = g.adjacencyList[current_node].headNode;
            }
            while (temp != null) {
                if (!visited[temp.data]) {
                    stack.push(temp.data);
                    visited[temp.data] = true;
                    vertices_reached++;
                }

                temp = temp.nextNode;
            }
        }
        return (vertices_reached + 1) == g.vertices;
    }

    public static void main(String args[]) {

        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(0,3);
        g.addEdge(3,4);
        g.printGraph();
        System.out.println("isTree : " + isTree(g));

        Graph g2 = new Graph(4);
        g2.addEdge(0,1);
        g2.addEdge(0,2);
        g2.addEdge(0,3);
        g2.addEdge(3,2);
        g2.printGraph();
        System.out.println("isTree : " + isTree(g2));

        Graph g3 = new Graph(6);
        g3.addEdge(0,1);
        g3.addEdge(0,2);
        g3.addEdge(0,3);
        g3.addEdge(4,5);
        g3.printGraph();
        System.out.println("isTree : " + isTree(g3));
    }
}
