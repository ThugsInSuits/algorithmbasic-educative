package educative_algorithm_study.algorithms.graph_algorithms;

/**
 * @author XiZhuangBaoTu
 * Date 2024/2/1 15:16
 * Version 1.0
 * @description
 **/
public class Connected {
    public static boolean isConnected(Graph g) {
        //use this helper function if you want to
        int numOfVertices = g.getVertices();
        boolean[] visited = new boolean[numOfVertices];
        g.dfsTraversal2(0,visited);
        for (int i = 0; i < numOfVertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public static Object willCauseSeparateComponents(Graph g, int source, int destination) {
        //write your code here
        if (!g.getAdj()[source].isEmpty()) {
            g.getAdj()[source].remove((Integer) destination);
        }
        if (!g.getAdj()[destination].isEmpty()) {
            g.getAdj()[destination].remove((Integer) source);
        }
        if (isConnected(g)) {
            return false;
        }else {
            return true;
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(0, 4);

        // remove edge 3 -> 4
        Object x = Connected.willCauseSeparateComponents(g, 3, 4);
        System.out.println("Separate components created due to deletion of edge 3 -> 4? " + x);

        // remove edge 1 -> 2
        x = Connected.willCauseSeparateComponents(g, 1, 2);
        System.out.println("Separate components created due to deletion of edge 1 -> 2? " + x);

    }
}
