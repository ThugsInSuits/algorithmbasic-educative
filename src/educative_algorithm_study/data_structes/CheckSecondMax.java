package educative_algorithm_study.data_structes;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/18 19:03
 * Version 1.0
 * @description find second maxmium value in an array
 **/
public class CheckSecondMax {
    public static void main(String[] args) {
        int[] arr = {4,2,1,5,0};
        System.out.println(findSecondMaximum2(arr));

    }

    public static int findSecondMaximum(int[] arr)
    {
        int maxValue = Integer.MIN_VALUE;
        int secondMaxValue = Integer.MIN_VALUE;

        for (int ele : arr) {
            if (ele > maxValue) {
                maxValue = ele;
            }
        }

        for (int ele : arr) {
            if (ele < maxValue && ele > secondMaxValue) {
                secondMaxValue = ele;
            }
        }
        return secondMaxValue;
    }

    public static int findSecondMaximum2(int[] arr) {
        int maxValue = Integer.MIN_VALUE;
        int secondMaxValue = Integer.MIN_VALUE;

        for (int ele : arr) {
            if (ele > maxValue) {
                secondMaxValue = maxValue;
                maxValue = ele;
            }else if (ele > secondMaxValue && ele != maxValue) {
                secondMaxValue = ele;
            }
        }
        return secondMaxValue;
    }


}
