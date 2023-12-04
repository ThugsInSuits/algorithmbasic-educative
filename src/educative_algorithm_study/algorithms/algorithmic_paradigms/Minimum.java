package educative_algorithm_study.algorithms.algorithmic_paradigms;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/4 13:53
 * Version 1.0
 * @description
 **/
public class Minimum {
    public static int minimum_index(int[] array, int array_size) {
        int min_index = 0;
        int min_val = Integer.MAX_VALUE;
        for (int i = 0; i < array_size; i++) {
            if (min_val > array[i]) {
                min_val = array[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void main(String args[]) {
        int array_size = 9;
        int nums[] = {2,4,6,3,5,7,9,1,8};
        int min_index = minimum_index(nums, array_size);

        System.out.println("The MIN number " + nums[min_index] + " is found at index " + min_index);
    }
}
