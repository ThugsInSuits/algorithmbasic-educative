package educative_algorithm_study.algorithms.saerch_and_sorting;

import educative_algorithm_study.algorithms.Helper;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/4 16:44
 * Version 1.0
 * @description
 **/
public class InsertSort {
    public static void insertSort(int[] arr,int arrSize) {
        int j,ele;

        for (int i = 0; i < arrSize; i++) {
            ele = arr[i];
            j = i - 1;

            while (j >=0 && arr[j] > ele) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = ele;
        }
    }

    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        insertSort(arr, arrSize);
        Helper.printArray(arr, arrSize);
    }
}
