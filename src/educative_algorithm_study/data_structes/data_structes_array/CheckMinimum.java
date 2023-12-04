package educative_algorithm_study.data_structes.data_structes_array;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/18 17:40
 * Version 1.0
 * @description
 **/
public class CheckMinimum {

    public static void main(String[] args) {
        int[] arr = {8,3,4,5,6};
        int minValue = findMinimum(arr);
        System.out.println(minValue);
    }

    public static int findMinimum(int[] arr) {
        int minValue = arr[0];
        for (int ele : arr) {
            if (minValue >ele) {
                minValue = ele;
            }
        }
        return minValue;
    }
}
