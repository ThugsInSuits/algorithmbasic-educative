package educative_algorithm_study.algorithms.graph_algorithms;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/31 20:41
 * Version 1.0
 * @description
 **/
public class CheckDFS {
    public static String dfs(DoubleLinkedListGraph g) {
        String result = "";
        if (g.vertices < 1) {
            return result;
        }

        boolean[] visited = new boolean[g.vertices];

        for (int i = 0; i < g.vertices; i++) {
            if (!visited[i]) {
                result = result + dfsVisit(g,i,visited);
            }
        }
        return result;
    }

    private static String dfsVisit(DoubleLinkedListGraph g, int source, boolean[] visited) {
        String result = "";
        Stack<Integer> stack = new Stack<>(g.vertices);
        stack.push(source);

        while (!stack.isEmpty()) {
            int current_code = stack.pop();
            result += String.valueOf(current_code);

            DoublyLinkedList<Integer>.Node temp = null;
            if (g.adjacencyList[current_code] != null ) {
                temp = g.adjacencyList[current_code].getHeadNode();
            }
            while (temp != null) {
                if (!visited[temp.data]) {
                    stack.push(temp.data);
                }
                temp = temp.nextNode;
            }
            visited[current_code] = true;
        }
        return result;
    }

    public static void main(String[] args) {
        DoubleLinkedListGraph g = new DoubleLinkedListGraph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        DoubleLinkedListGraph g2 = new DoubleLinkedListGraph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }
}
