package educative_algorithm_study.data_structes_hash_table;

import java.util.HashMap;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/2 20:39
 * Version 1.0
 * @description
 **/
public class CheckPair {
    public static String findPair(int[] arr) {
        String result = "";
        HashMap<Integer,int[]> hMap = new HashMap<>();

        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                int sum = arr[i] + arr[j];

                if (!hMap.containsKey(sum)) {
                    hMap.put(sum,new int[]{arr[i],arr[j]});
                }else {
                    int[] prev_pair = hMap.get(sum);

                    result += "{" + prev_pair[0] + "," + prev_pair[1] + "}{" + arr[i] + "," + arr[j] + "}";
                    return result;
                }
            }

        }
        return result;
    }

    public static void main(String args[]) {

        int[] arr = {3, 4, 7, 1, 12, 9};
        System.out.println(findPair(arr));

    }
}
