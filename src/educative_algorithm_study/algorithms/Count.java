package educative_algorithm_study.algorithms;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/30 11:17
 * Version 1.0
 * @description
 **/
public class Count {
    public static int calcFreq(int arr[], int key) {
        int count = 0;
        for (int val : arr) {
            if (val == key) {
                count++;
            }
        }
        return count;
    }

    public static int calcFreq2(int arr[], int key) {
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {-5,-3,0,1,3,3,3,3,4,5};
        int key = 3;
        System.out.println("The key \"" + key + "\" occurs " + calcFreq(arr, key) + " times in the Array.");
    }
}
