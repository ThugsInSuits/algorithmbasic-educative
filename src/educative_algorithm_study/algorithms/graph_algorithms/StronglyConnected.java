package educative_algorithm_study.algorithms.graph_algorithms;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author XiZhuangBaoTu
 * 这个题目是为了校验图是否有环，解题方法，递归遍历所有的节点，如果每个节点都能连接上，那么可以遍历到所有的节点
 * Date 2024/2/1 09:59
 * Version 1.0
 * @description
 **/
public class StronglyConnected {
    public static void utilityFunction(Graph g, int v, boolean visited[]) {
        //use this helper function if you want to
        visited[v] = true;
        int temp ;

        LinkedList<Integer>[] list;
        list = g.getAdj();

        Iterator<Integer> iterator = list[v].iterator();
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (!visited[temp]) {
                utilityFunction(g,temp,visited);
            }
        }
    }


    public static Object isStronglyConnected(Graph g) {
        int numofVertices = g.getVertices();
        boolean[] visited = new boolean[numofVertices];
        
        utilityFunction(g,0,visited);
        for (int i = 0; i < numofVertices; i++) {

            if (visited[i] == false) {
                return false;
            }
        }
        Graph g1 = g.geTranspose();
        for (int i = 0; i < numofVertices; i++) {
            visited[i] =false;
        }
        utilityFunction(g1,0, visited);

        for (int i = 0; i < numofVertices; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(0, 1);
        g1.addEdge(1, 2);
        g1.addEdge(2, 3);
        g1.addEdge(3, 0);
        g1.addEdge(2, 4);
        g1.addEdge(4, 2);

        Object x = StronglyConnected.isStronglyConnected(g1);
        System.out.println("Graph g1 is strongly connected? " + x);


        Graph g2 = new Graph(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);

        x = StronglyConnected.isStronglyConnected(g2);
        System.out.println("Graph g2 is strongly connected? " + x);
    }
}

