package educative_algorithm_study.algorithms.searchinarotatedarray.util;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/23 20:23
 * Version 1.0
 * @description
 **/
public class Util {
    public static int[] generateArr(int size,int maxValue) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random()*maxValue);
        }
        return arr;
    }
}
