package educative_algorithm_study.algorithms.saerch_and_sorting;

import educative_algorithm_study.algorithms.searchinarotatedarray.Helper;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/4 17:39
 * Version 1.0
 * @description
 **/
public class MergeSort {
    public static void merge(int arr[],int left,int mid,int right) {

        int siezLeft = mid - left + 1;
        int sizeRight = right - mid;

        int[] leftArr = new int[siezLeft];
        int[] rightArr = new int[sizeRight];

        for (int i = 0; i < siezLeft; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0,j= 0;
        int k = left;
        while(i < siezLeft && j < sizeRight) {
            if (leftArr[i] < rightArr[j]) {
                arr[k++] = leftArr[i++];
            }else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < siezLeft) {
            arr[k++] = arr[i++];
        }
        while (j < sizeRight) {
            arr[k++] = arr[j++];
        }

    }
    public static void mergeSort(int arr[],int leftIndex,int rightIndex) {
        if (leftIndex < 0 || rightIndex < 0) {
            return;
        }
        if (rightIndex > leftIndex) {
            int mid = leftIndex +  (rightIndex - leftIndex) / 2;
            mergeSort(arr,leftIndex,mid);
            mergeSort(arr,mid+1,rightIndex);
            merge(arr,leftIndex,mid,rightIndex);
         }
    }

    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        mergeSort(arr, 0, arrSize - 1);
        Helper.printArray(arr, arrSize);
    }
}
