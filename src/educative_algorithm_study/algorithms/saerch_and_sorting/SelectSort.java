package educative_algorithm_study.algorithms.saerch_and_sorting;

import educative_algorithm_study.algorithms.searchinarotatedarray.Helper;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/4 16:22
 * Version 1.0
 * @description
 **/
public class SelectSort {
    public static void selectionSort(int[] arr,int arrSize) {
        int minInd;
        for (int i = 0; i < arrSize; i++) {
            minInd = Helper.findMin(arr,i,arrSize - 1);
            int temp = arr[i];
            arr[i] = arr[minInd];
            arr[minInd] = temp;
        }
    }

    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        selectionSort(arr, arrSize);
        Helper.printArray(arr, arrSize);
    }
}
