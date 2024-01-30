package educative_algorithm_study.algorithms;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import educative_algorithm_study.algorithms.util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/22 22:50
 * Version 1.0
 * @description
 **/
class Median {
    public static double getMedian(int array1[], int[] array2) {
        if (array1 == null || array2 == null || array2.length == 0 || array1.length == 0) {
            return -1;
        }
        int n = array1.length + array2.length;
        int[] combineArr = new int[n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while(index2 < array2.length && index1 < array1.length) {
            if (array1[index1] < array2[index2]) {
                combineArr[index++] = array1[index1++];
            }else {
                combineArr[index++] = array2[index2++];
            }
        }
        while (index1 <array1.length) {
            combineArr[index++] = array1[index1++];
        }
        while (index2 < array2.length) {
            combineArr[index++] = array2[index2++];
        }
        Arrays.sort(combineArr);
        if (n % 2 == 0) {
            int mid = n / 2;
            return (double) (combineArr[mid] + combineArr[mid - 1]) /2;
        }else {
            return combineArr[n/2];
        }
    }

    static List<Integer> combineTwoArr(int[] arr1,int[] arr2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            list.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            list.add(arr2[i]);
        }
        Collections.sort(list);
        return list;
    }

    static double getMedian2(int[] arr1,int[] arr2){
        List<Integer> integers = combineTwoArr(arr1, arr2);
        int mid = integers.size() / 2;
        if (integers.size() % 2 == 0) {
            return (double) (integers.get(mid) + integers.get(mid - 1)) / 2;
        }else {
            return integers.get(mid);
        }
    }

    public static void main(String args[]) {
        int runTime = 1000;
        int maxValue = 100;
        for (int i = 0; i < runTime; i++) {
            int sizeArr1 = (int)(Math.random()*10);
            int sizeArr2 = (int)(Math.random()*10);
            int[] arr1 = Util.generateArr(sizeArr1, maxValue);
            int[] arr2 = Util.generateArr(sizeArr2, maxValue);

            if (getMedian(arr1,arr2) != getMedian2(arr1,arr2)) {
                System.out.println(Arrays.toString(arr1));
                System.out.println(Arrays.toString(arr2));
                System.out.println(getMedian(arr1,arr2));
                System.out.println(getMedian2(arr1,arr2));
                System.out.println("bad");
                return;
            }

        }
        System.out.printf("success");
    }
}