package educative_algorithm_study;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/14 21:38
 * Version 1.0
 * @description
 **/
public class MergeSort {
    public static void main(String[] args) {
        createTestData();
        long start = System.currentTimeMillis();
        mergeSort(0,input.length-1,input);
        long end = System.currentTimeMillis();
        System.out.println("Time taken:" + (end - start));
        printArr(input);
    }

    public static int SIZE = 100;
    public static Random random = new Random(System.currentTimeMillis());
    public static int[] input = new int[SIZE];
    public static  PriorityQueue<Integer> p = new PriorityQueue();

    public static void createTestData(){
        for (int i = 0; i < SIZE; i++) {
            input[i] = random.nextInt(10000);
        }
    }

    public static void printArr(int[] input) {
        System.out.println();
        for (int i = 0; i < input.length; i++) {
            System.out.print(" " + input[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int start , int end, int[] input ) {
        if (start >= end) {
            return;
        }else if (start + 1 == end) {
            if (input[start] > input[end]) {
                int temp = input[start];
                input[start] = input[end];
                input[end] = temp;
            }
            return;
        }
        int oneThird = (end - start) / 3;
        mergeSort(start, start + oneThird, input);
        mergeSort(start + oneThird + 1, start + 1 + oneThird * 2, input);
        mergeSort(start + 2 + oneThird * 2, end, input);

        int k ;
        for (k = start ; k <= end; k++) {
            p.add(input[k]);
        }

        k = start;
        while (!p.isEmpty()) {
            input[k] = p.poll();
            k++;
        }
    }
}
