package educative_algorithm_study.algorithms;

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


}
