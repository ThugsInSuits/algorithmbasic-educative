package educative_algorithm_study.data_structes.data_structes_hash_table;

import java.util.HashSet;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/2 22:57
 * Version 1.0
 * @description
 **/
public class CheckSum {
    public static int[] findSum(int[] arr, int n) {
        int[] result = new int[2];
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : arr) {
            if (hashSet.contains(n - 1) ) {
                arr[0] = i;
                arr[1] = n- 1;
            }
            hashSet.add(i);
        }
        return result;
    }

    public static void main(String args[])
    {
        int n = 0;
        int[] arr1 = {};
        if(arr1.length > 0){
            int[] arr2 = findSum(arr1, n);
            int num1 = arr2[0];
            int num2 = arr2[1];

            if((num1 + num2) != n)
                System.out.println("Not Found");
            else {
                System.out.println("Number 1 = " + num1);
                System.out.println("Number 2 = " + num2);
                System.out.println("Sum = " +  (n) );

            }
        } else {
            System.out.println("Input Array is Empty!");
        }
    }
}
