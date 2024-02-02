package educative_algorithm_study.algorithms.greed_algorithms;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author XiZhuangBaoTu
 * Date 2024/2/2 10:28
 * Version 1.0
 * @description
 **/
public class MinimumCost {
    public static int minCost(int[] pipes) {
        int cost = 0;
        int n  = pipes.length;

        for (int i = 0; i < n -1; i++) {
            Arrays.sort(pipes);
            int pre_cost = cost;
            cost = pipes[i] + pipes[i+1];
            pipes[i + 1] = cost;
            cost = cost + pre_cost;
        }
        return cost;
    }

    public static int minCost2(int[] pipes) {
        Stack<Integer> stack = new Stack<>();
        int
    }

    public static void main(String[] args) {
        int[] pipes = {4,3,2,6};
        System.out.println("total cost for connecting pipes is :" + MinimumCost.minCost(pipes));
    }
}
