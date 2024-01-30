package educative_algorithm_study.algorithms.saerch_and_sorting;

import educative_algorithm_study.algorithms.searchinarotatedarray.Helper;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/4 16:35
 * Version 1.0
 * @description
 **/
public class BubbleSort {
    // 想象成泡泡，每一次遍历都把一个最大或者最小的值放到最后的位置
    public static void bubbleSort(int[] arr,int arrSize) {
        for (int i = 0; i < arrSize; i++) {
            for (int j = 0; j < arrSize - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = arr[j];
                }
            }
        }
    }

    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        bubbleSort(arr, arrSize);
        Helper.printArray(arr, arrSize);
    }
}
