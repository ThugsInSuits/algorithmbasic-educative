package educative_algorithm_study.algorithms.saerch_and_sorting;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/6 23:24
 * Version 1.0
 * @description
 **/
public class CheckSum {
    public static int[] findSum_burte_solution(int[] arr, int n) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if ((arr[i] + arr[j] == n)) {
                    result[0] = arr[i];
                    result[1] = arr[j];
                }
            }
        }
        return result; // return the elements in the array whose sum is equal to the value passed as parameter
    }
    public static int[] findSum_quick_solution(int[] arr, int n) {

    }

    public static void main(String args[]) {

        int n = 9;
        int[] arr1 = {2, 4, 5, 7, 8};
        int[] arr2 = findSum_burte_solution(arr1, n);
        int num1 = arr2[0];
        int num2 = arr2[1];

        if ((num1 + num2) != n)
            System.out.println("Results not found!");
        else
            System.out.println("Sum of " + n + " found: " + num1 + " and " + num2);
    }
}
