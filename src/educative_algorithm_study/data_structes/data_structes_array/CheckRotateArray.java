package educative_algorithm_study.data_structes.data_structes_array;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/18 19:52
 * Version 1.0
 * @description
 **/
public class CheckRotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotateArray(arr);
        for (int element : arr) {
            System.out.print(element + " ");

        }
        System.out.println();
    }

    public static void rotateArray(int[] arr){
        int n = arr.length;
        int lastElement = arr[n - 1];
        for (int i =n-1 ;i >= 1 ;i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = lastElement;
    }
}
