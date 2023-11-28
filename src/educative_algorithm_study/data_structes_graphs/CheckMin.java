package educative_algorithm_study.data_structes_graphs;

import educative_algorithm_study.data_structes_list.DoublyLinkedList;
import educative_algorithm_study.data_structes_stack_queue.Queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/28 13:24
 * Version 1.0
 * @description
 **/
public class CheckMin {
    public static int findMin(Graph g,int source,int destination) {
        if (source == destination) {
            return 0;
        }

        int num_of_vertices = g.vertices;

        boolean[] visited = new boolean[num_of_vertices];

        int[] distance = new int[num_of_vertices];

        Queue<Integer> queue = new Queue<>(num_of_vertices);

        queue.enqueue(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current_node = queue.dequeue();
            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_node] != null) {
                temp = g.adjacencyList[current_node].headNode;
            }

            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true;
                    distance[temp.data] = distance[current_node] + 1;
                }
                if (temp.data == destination) {
                    return distance[destination];
                }
                temp = temp.nextNode;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);
        System.out.println(findMin(g, 0, 4));
    }
}
