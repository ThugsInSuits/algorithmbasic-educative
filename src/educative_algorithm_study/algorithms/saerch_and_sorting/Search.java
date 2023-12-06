package educative_algorithm_study.algorithms.saerch_and_sorting;

import educative_algorithm_study.algorithms.Helper;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/6 23:08
 * Version 1.0
 * @description
 **/
public class Search {
    public static int  binarySearch(int s,int[] arr,int arrSize) {
        if (arrSize <= 0) {
            return -1;
        }
        if (arrSize == 1 ) {
            if (arr[0] == s) {
                return 0;
            }else {
                return -1;
            }
        }
        int start = 0;
        int end = arrSize - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] < s) {
                start = mid + 1;
            }else if (arr[mid] > s ){
                end = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {-100,0,0,1,4,4,5,5,95,200};
        int arrSize = 10;
        int key = 1;
        int index = binarySearch(key, arr, arrSize);
        Helper.printArray(arr, arrSize);
        if (index != -1)
            System.out.println("Your Key \"" + key + "\" is found at index \"" + index + "\"");
        else
            System.out.println("Your Key \"" + key + "\" not found in the array: ");
    }
}
