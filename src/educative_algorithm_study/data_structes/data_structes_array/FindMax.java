package educative_algorithm_study.data_structes.data_structes_array;

import java.util.Arrays;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/21 21:45
 * Version 1.0
 * @description
 **/
public class FindMax {
    public static int findMaxSumSubArray(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }

        int currMax = arr[0];
        int globalMax = arr[0];
        int lengthArray = arr.length;

        for (int i = 1; i < lengthArray; i++) {
            if(currMax < 0) {
                currMax = arr[i];
            }else  {
                currMax += arr[i];
            }

            if (globalMax < currMax) {
                globalMax =  currMax;
            }

        }

        return globalMax;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 7, -2, -5, 10, -1};
        System.out.println("Array: "+ Arrays.toString(arr1));
        System.out.println("Sum: " + findMaxSumSubArray(arr1));
    }
}