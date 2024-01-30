package educative_algorithm_study.algorithms;

import java.util.Random;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/4 16:17
 * Version 1.0
 * @description
 **/
public class Helper {
    public static void printArray(int[] arr,int arrSize){
        for (int i = 0; i < arrSize; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int findMin(int[] arr,int start,int end) {
        if (end <= 0 || start < 0) {
            return 0;
        }
        int minInd = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[minInd] > arr[i]) {
                minInd = i;
            }
        }
        return minInd;
    }

    public static int findMax(int[] arr,int start,int end) {
        if (end <= 0 || start <0 ){
            return 0;
        }
        int maxInd = start;
        for (int i = start + 1; i <=end; i++) {
            if (arr[maxInd] < arr[i]) {
                maxInd = i;
            }
        }
        return maxInd;
    }
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

//    private int choosePivot(int left,int right) {
//        Random random = new Random();
//
//    }

//    public static int partition(int arr[],int left,int right) {
//
//    }

    public int binarySearch(int s ,int[] arr,int arrSize) {
        if (arrSize <= 0) {
            return -1;
        }
        if (arrSize== 1) {
            if (s == arr[0] ) {
                return 0;
            }else {
                return -1;
            }
        }

        int left = 0;
        int rigth = arrSize - 1;
        while (left < rigth) {
            int mid = (left + rigth) / 2;
            if (arr[mid] < s) {
                left = mid + 1;
            }else if (arr[mid] > s) {
                rigth = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }


}
