package educative_algorithm_study.data_structes.data_structes_array;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/17 22:32
 * Version 1.0
 * @description
 **/
public class CheckMergeArray {
    public static void main(String[] args) {
        int[] arr1 = {1,3,5,7,9};
        int[] arr2 = {2,4,6,8,10};
        int[] arr3 = mergeArrays(arr1,arr2);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int i = 0,j = 0,k = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            }else {
                result[k++] = arr2[j++];
            }
        }
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        return result;
    }
}
