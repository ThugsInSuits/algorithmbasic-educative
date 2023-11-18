package zuochengyun_algorithm_study.class02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 有k个数是奇数，
 * 一个数组中有一种数出现K次，其他数都出现了M次，M > 1,  K < M找到，出现了K次的数，要求，额外空间复杂度O(1)，时间复杂度O(N)
 */
public class Code03_KM2 {

    /**
     * 解题思路，通过使用数组保存每个数的二进制数据
     *
     * @param arr
     * @param k
     * @param m
     * @return
     */
    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (map.size() == 0) {
            mapCreater(map);
        }
        int[] t = new int[32];
        // 获取所有数的二进制1
        for (int i : arr) {
            while (i != 0) {
                int rightOne = i & (-i);
                t[map.get(rightOne)]++;
                i ^= rightOne;
            }
        }
        int ans = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] % m != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }

    /**
     * 填充map，key通过1左移生成，value由设置0～31，后续将该value作为存储值的索引
     *
     * @param map
     */
    private static void mapCreater(HashMap<Integer, Integer> map) {
        int key = 1;
        for (int i = 0; i < 32; i++) {
            map.put(key, i);
            key <<= 1;
        }
    }

    public static int compator(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        int ans = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == k) {
                return integer;
            }
        }
        return ans;
    }

    /**
     * 生成随机数组，保证该数组中一个数有k个，其他数是m个
     *
     * @param maxValue 数组中最大值
     * @param kinds    数据类型
     * @param k        一个值欧k个
     * @param m        一个值有m个
     * @return 返回这个随机数组
     */
    public static int[] generateRandomArray(int maxValue, int kinds, int k, int m) {
        int kitmeNum = generateRandomNum(maxValue);
        // 最少两种
        int randomKinds = (int) (Math.random() * kinds) + 2;
        int[] arr = new int[k + m * (randomKinds - 1)];
        // 先填充出现k次的数
        int i = 0;
        for (; i < k; i++) {
            arr[i] = kitmeNum;
        }

        randomKinds--;
        HashSet set = new HashSet();
        set.add(kitmeNum);
        // 然后填充出现m次的数据
        while (randomKinds != 0) {
            int cur = 0;
            do {
                cur = generateRandomNum(maxValue);
            } while (set.contains(cur));
            arr[i] = cur;
            randomKinds--;
            // 取到这个随机数，然后填充m次
            for (int j = 0; j < m; j++) {
                arr[i++] = cur;
            }
        }

        // 获取到数组后在随机打乱排序
        for (int j = 0; j < arr.length; j++) {
            int x = (int) (Math.random() * arr.length);
            int temp = arr[j];
            arr[j] = arr[x];
            arr[x] = temp;
        }
        return arr;
    }

    public static int generateRandomNum(int range) {
        return (int) (Math.random() * (range + 1)) - (int) (Math.random() * range);
    }

    public static void main(String[] args) {
        int time = 50000;
        int type = 5;
        int maxvalue = 9;
        int range = 30;
        System.out.println("start");
        for (int i = 0; i < time; i++) {
            int a = (int) (Math.random() * maxvalue) + 1;
            int b = (int) (Math.random() * maxvalue) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            // k < m
            if (k == m) {
                m++;
            }
            int[] arr = generateRandomArray(range, type, k, m);
            int officalValue = compator(arr, k, m);
            int difineValue = test(arr, k, m);
            if (officalValue != difineValue) {
                System.out.println(Arrays.toString(arr));
                System.out.println(officalValue);
                System.out.println(difineValue);
                System.out.println("wrong");
            }
        }
        System.out.println("end");
    }

}
