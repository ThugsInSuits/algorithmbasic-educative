package educative_algorithm_study.data_structes.data_structes_hash_table;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/2 21:18
 * Version 1.0
 * @description
 **/
public class CheckFirstUnique {
    public static int findFirstUnique(int[] arr) {
        HashMap<Integer,Integer> countElements = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (countElements.containsKey(arr[i])) {
                int occurence = countElements.get(arr[i]) + 1;
                countElements.put(arr[i],occurence);
            }else {
                countElements.put(arr[i],0);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (countElements.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return -1;
    }

    public static void main(String args[]) {

        int[] arr = {2, 54, 7, 2, 6, 54};

        System.out.println("Array: " + Arrays.toString(arr));

        int unique = findFirstUnique(arr);
        System.out.print("First Unique in an Array: " + unique);

    }
}
