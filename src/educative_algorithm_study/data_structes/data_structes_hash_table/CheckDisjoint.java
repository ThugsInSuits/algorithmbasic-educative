package educative_algorithm_study.data_structes.data_structes_hash_table;

import java.util.HashSet;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/2 18:27
 * Version 1.0
 * @description
 **/
public class CheckDisjoint {
    public static Object isDisjoint(int[] arr1,int[] arr2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!set.contains(arr1[i])) {
                set.add(arr1[i]);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                return false;
            }
        }
        return true;
    }
}
