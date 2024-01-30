package educative_algorithm_study.algorithms.searchinarotatedarray;

import java.util.Arrays;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/30 16:18
 * Version 1.0
 * @description
 **/
public class DutchFlag {
    public static int[] selectionSort(int[] lst) {
        int size = lst.length;
        int index = 0;
        for (int i = 0; i < size; i++) {
            index = find_min(lst,i,size);
            int swap = lst[index];
            lst[index] = lst[i];
            lst[i] = swap;
        }
        return lst;
    }

    public static void dutchNationFlag(int[] arr) {
        int i = 0;
        int sizeArr = arr.length;
        int mid = 0;
        int j = arr.length - 1;

        while (mid <= j) {
            if (arr[mid] == 0) {
                Helper.swap(arr,i++,mid++);
            } else if (arr[mid] == 2) {
                Helper.swap(arr,mid,j--);
            }else if (arr[mid] == 1) {
                mid++;
            }
        }
    }

    private static int find_min(int[] lst, int start, int end) {
        int min = lst[start];
        int index = start;
        for (int j = start; j < end; j++) {
            if (lst[j] < start) {
                min = lst[j];
                index = j;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {
                2,
                0,
                0,
                1,
                2,
                1
        };
        System.out.println(Arrays.toString(selectionSort(arr)));

    }
}
