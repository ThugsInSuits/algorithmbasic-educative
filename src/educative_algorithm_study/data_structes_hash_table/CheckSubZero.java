package educative_algorithm_study.data_structes_hash_table;

import java.util.HashMap;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/2 20:51
 * Version 1.0
 * @description
 **/
public class CheckSubZero {
    public static boolean findSubZero(int[] arr) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (arr[i] == 0 || sum == 0 || hashMap.get(sum) != null) {
                return true;
            }
            hashMap.put(sum,i);

        }
        return false;
    }

    public static void main(String args[]) {

        int[] arr = {6, 4, -7, 3, 12, 9};
        System.out.println(findSubZero(arr));

    }
}
