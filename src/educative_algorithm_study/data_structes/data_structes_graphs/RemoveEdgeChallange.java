package educative_algorithm_study.data_structes.data_structes_graphs;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/28 13:44
 * Version 1.0
 * @description
 **/
public class RemoveEdgeChallange {
    public  static void removeEdge(Graph g,int source,int destination) {
        g.adjacencyList[source].deleteByValue(destination);
    }

    public static void main(String args[]) {
        Graph g=new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(1,4);

        System.out.println("Before:");
        g.printGraph();

        removeEdge(g, 1, 3);
        System.out.println("After:");
        g.printGraph();
    }
}
