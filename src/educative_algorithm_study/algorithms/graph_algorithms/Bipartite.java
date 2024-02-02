package educative_algorithm_study.algorithms.graph_algorithms;

import java.util.HashMap;

/**
 * @author XiZhuangBaoTu
 * 判断图是否为二分图，这里关键是，节点的相邻节点不能是和自己一样，这里通过颜色区分，通过一个组件的是一个颜色
 * Date 2024/2/1 21:01
 * Version 1.0
 * @description
 **/
public class Bipartite {
    public static boolean isBipartite(Graph g) {
        int n = g.getVertices();
        boolean[] color = new boolean[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!bfs(g,i,visited,color)) {
                return false;
            }
        }
       return true;
    }

    public static boolean bfs(Graph g,int source,boolean[] visited,boolean[] color){
        for (int i : g.getAdj()[source]) {
            if (!visited[i]) {
                visited[i] = true;
                color[i] = !color[source];
                // 这里检查i节点的子节点是否为二分图
                if (!bfs(g, i, visited, color)) {
                    return false;
                }
            } else if (color[i] == color[source]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

        Graph g = new Graph(7);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(6, 1);


        Graph g2 = new Graph(7);
        g2.addEdge(3, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 1);
        g2.addEdge(5, 3);
        g2.addEdge(6, 2);
        g2.addEdge(3, 1);

//        boolean[] discovered = new boolean[8];
//        boolean[] color = new boolean[8];
//        discovered[1] = true;
//        color[1] = false;


        //Example 1
        Object x = Bipartite.isBipartite(g);
        System.out.println("Graph1 is bipartite: " + x);


        //Example 2
        Object x2 = Bipartite.isBipartite(g2);
        System.out.println("Graph2 is bipartite: " + x2);

    }
}
