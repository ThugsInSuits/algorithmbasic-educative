package educative_algorithm_study.algorithms.graph_algorithms;

import java.util.LinkedList;

/**
 * @author XiZhuangBaoTu
 * 这个题目并不是需要从底部开始反转，而是简单的吧edge的顺序反转一下就可以了。
 * Date 2024/1/31 21:57
 * Version 1.0
 * @description
 **/
public class Transponse {
    public static void getTranspose(Graph g) {
        int num_of_vertices = g.getVertices(); //getVertices defined in Graph.java file

        DoubleLinkedListGraph transposedGraph = new DoubleLinkedListGraph(num_of_vertices); //new graph to store the transpose

        LinkedList<Integer> list[];
        list = g.getAdj();
        for (int i = 0; i < g.getVertices(); i++) {
            for (int j = 0; j < list[i].size(); j++) {
                transposedGraph.addEdge(list[i].get(j),i);
            }
        }

        transposedGraph.printGraph(); //calling print function on the final transposed graph
    }
    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);
        System.out.println("Transpose of given Graph: ");
        getTranspose(g1);
    }
}
