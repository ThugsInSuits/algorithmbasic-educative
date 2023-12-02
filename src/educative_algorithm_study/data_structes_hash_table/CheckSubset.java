package educative_algorithm_study.data_structes_hash_table;

import java.util.HashSet;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/1 23:44
 * Version 1.0
 * @description
 **/
public class CheckSubset {
    public static boolean isSubset(int[] arr1,int[] arr2) {
        HashSet<Integer> hset = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!hset.contains(arr1[i])) {
                hset.add(arr1[i]);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (!hset.contains(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

        int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
        int[] arr2 = {7, 1, -2};
        int[] arr3 = {10, 12};

        System.out.println(isSubset(arr1, arr2));
        System.out.println(isSubset(arr1, arr3));
    }
}
