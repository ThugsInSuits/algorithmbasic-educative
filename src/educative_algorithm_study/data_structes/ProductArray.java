package educative_algorithm_study.data_structes;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/18 15:36
 * Version 1.0
 * @description
 **/
public class ProductArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        int[] result = findProduct2(array);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    public static int[] findProduct(int arr[]) {
        int result = 1;
        List<Integer> zeroIndex = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zeroIndex.add(i);
                continue;
            }
            result *= arr[i];
        }

        int[] resultArr = new int[arr.length];
        // 如果有两个或以上的0，那么每个位置都为0
        if (zeroIndex.size() >= 2) {
            return resultArr;
        }
        // 如果只有一个位置为0，那么为0的位置就是其他位置相乘的结果，其他位置都为0
        if (zeroIndex.size() == 1) {
            resultArr[zeroIndex.get(0)] = result;
            return resultArr;
        }

        for (int i = 0; i < arr.length; i++) {
            // 如果没有0，那么每个位置的值就是总乘积除以i位置的余值
            resultArr[i] = result / arr[i];
        }
        return resultArr;
    }

    /**
     *@Author XiZhuangBaoTu
     *@Description findProduct2 function is smart than findProduct function ,because it complexity of time is n
     *@Date 16:14 2023/11/18
     *@Param [arr]
     *@return int[]
     **/
    public static int[] findProduct2(int arr[])
    {
        int n = arr.length;
        int[] result = new int[n];
        int temp = 1;
        // 把i位置左边的元素乘起来
        for (int i = 0; i < n; i++) {
            result[i] = temp;
            temp *= arr[i];
        }

        temp = 1;
        // 把i位置的元素从右边开始乘，这样每个位置就都把除i位置以外的元素乘在一块了
        for (int i = n-1; i >=0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }
        return result;
    }

}
