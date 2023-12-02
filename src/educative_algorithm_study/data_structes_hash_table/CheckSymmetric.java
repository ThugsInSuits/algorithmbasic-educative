package educative_algorithm_study.data_structes_hash_table;

import java.util.HashMap;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/2 19:49
 * Version 1.0
 * @description
 **/
public class CheckSymmetric {
    public static String findSymmetric(int[][] arr) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int second = arr[i][1];

            Integer value = hashMap.get(second);
            if (value != null && value == first) {
                result += "{" + String.valueOf(second) + "," + String.valueOf(first) + "}";
            }else  {
                hashMap.put(first,second);
            }
        }
        return result;
    }

    public static void main(String args[]) {

        int[][] arr = {{1, 2}, {3, 4}, {5, 9}, {4, 3}, {9, 5}};
        String symmetric = findSymmetric(arr);
        System.out.println(symmetric);

    }
}
