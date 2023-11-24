package educative_algorithm_study.data_structes_array;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/18 19:58
 * Version 1.0
 * @description Implement a method,which will sort the elements,such that all the negative elements appear at the right
 * and positive elements at the right
 **/
public class CheckReArrange {
    public static void main(String[] args) {
        int[] arr = {2, 4, -6, 8, -5, -10};
        reArrage2(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void reArrange(int[] arr) {
        int n = arr.length;
        int[] newArr = new int[n];
        int i = 0;
        for (int element : arr) {
            if (element < 0) {
                newArr[i++] = element;
            }
        }

        for (int element : arr) {
            if (element >= 0) {
                newArr[i++] = element;
            }
        }
        for (int m = 0; m < n; m++) {
            arr[m] = newArr[m];
        }
    }

    // 一次循环搞定
    public static void reArrage2(int[] arr) {
        int negetiveIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 ) {
                if (i != negetiveIndex) {
                    int temp= arr[i];
                    arr[i] = arr[negetiveIndex];
                    arr[negetiveIndex] = temp;
                }
                negetiveIndex++;
            }
        }
    }
}
