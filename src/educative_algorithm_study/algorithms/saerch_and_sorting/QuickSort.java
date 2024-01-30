package educative_algorithm_study.algorithms.saerch_and_sorting;

import educative_algorithm_study.algorithms.searchinarotatedarray.Helper;

import java.util.Random;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/4 21:43
 * Version 1.0
 * @description
 **/
public class QuickSort {
    public static int choosePivot(int left,int right) {
        Random random = new Random();
        int i1 = left + (random.nextInt(right - left + 1));
        int i2 = left + (random.nextInt(right - left + 1));
        int i3 = left + (random.nextInt(right - left + 1));

        return Math.max(Math.min(i1,i2),Math.min(Math.max(i1,i2),i3));
    }

    public static int partition(int arr[],int left,int right) {
        int pivotInd = choosePivot(left,right);
        Helper.swap(arr,right,pivotInd);
        int pivot = arr[right];
        int i = (left - 1);

        for (int j = left; j <= right -1; j++) {
            if (arr[j] <= pivot) {
                i++;
                Helper.swap(arr,i,j);
            }
        }
        Helper.swap(arr,i+1,right);
        return (i+1);
    }

    public static void quickSort(int arr[], int left, int right) {
        if (left < right) {
            // pi is where the pivot is at
            int pi = partition(arr, left, right);

            // Separately sort elements before and after partition
            quickSort(arr, left, pi - 1);
            quickSort(arr, pi + 1, right);
        }
    }
    public static void main(String args[]) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        int arrSize = 10;
        quickSort(arr, 0, arrSize - 1);
        System.out.print("Sorted array: ");
        Helper.printArray(arr, arrSize);
    }
}
