package educative_algorithm_study.algorithms.graph_algorithms;

import java.util.LinkedList;

/**
 * @author XiZhuangBaoTu
 * 这个题目是计算两个节点之间有多少挑路径，不包含环
 * 解题思路，是通过递归，保持终点不变，当start的值到达了终点，那就说明这条路是通的。
 * Date 2024/1/31 22:50
 * Version 1.0
 * @description
 **/
public class Count {

    public static int countPaths(Graph g, int start, int destination) {
        int count = 0;
        return countPathsRecursive(g,start,destination,count);
    }

    private static int countPathsRecursive(Graph g, int start, int destination, int count) {
        LinkedList<Integer>[] list = g.getAdj();

        if (start == destination) {
            count++;
        }else {
            for (int i = 0; i < list[start].size(); i++) {
                int ajdacentVertex = list[start].get(i);
                count = countPathsRecursive(g,ajdacentVertex,destination,count);
            }
        }
        return count;
    }

    public static void main(String args[]) {

        int answer;
        Graph g1 = new Graph(6);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(3, 4);
        g1.addEdge(2, 3);
        g1.addEdge(4, 5);

        answer = Count.countPaths(g1, 0, 5);
        System.out.println(answer);

        Graph g2 = new Graph(7);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(1, 5);
        g2.addEdge(2, 3);
        g2.addEdge(2, 4);
        g2.addEdge(5, 3);
        g2.addEdge(5, 6);
        g2.addEdge(3, 6);

        answer = Count.countPaths(g2, 0, 3);
        System.out.println(answer);
    }
}
