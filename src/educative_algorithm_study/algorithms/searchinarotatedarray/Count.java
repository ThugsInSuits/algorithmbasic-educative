package educative_algorithm_study.algorithms.searchinarotatedarray;

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

    /**
     *@Author XiZhuangBaoTu
     *@Description //TODO 先计算一个中间值，然后在计算左边的重复值，和右边的重复值。这是因为在排序的队列中，相同的数据是连在一起的
     *@Date 11:38 2024/1/30
     *@Param [arr, key]
     *@return int
     **/
    public static int calcFreq2(int[] arr, int key) {
        int size = arr.length;
        int index = Helper.binarySearch(key, arr, size);

        if (index == -1) {
            return 0;
        }
        int count = 1;
        int leftIndex = index - 1;
        while (leftIndex > 0 && arr[leftIndex] == key) {
            count++;
            leftIndex--;
        }

        int rightIndex = index + 1;
        while (rightIndex < size-1 && arr[rightIndex] == key ){
            count++;
            rightIndex++;
        }
        return count;
    }

    /**
     *@Author XiZhuangBaoTu
     *@Description //TODO 这个方法还是先通过二分法查找到中间元素，然后在通过二分查找到最右和最左的相同元素
     *@Date 11:58 2024/1/30
     *@Param [arr, key]
     *@return int
     **/
    public static int calcFreq3(int[] arr, int key) {
        int arrSize = arr.length;
        int left = 0,right = arrSize-1,result = -1,mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == key) {
                result = mid;
                right = mid - 1; // 求左边重复的第一个元素
            }else if (arr[mid] < key) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        int left1 = 0,right1 = arrSize-1,result1 = -1,mid1;
        while (left1 < right1) {
            mid1 = (left1 + right1 ) / 2;
            if (arr[mid1] == key) {
                result1 = mid1;
                left1 = mid1 + 1; // 求最右边重复的元素
            } else if (arr[mid1] < key) {
                left1 = mid1 + 1;
            } else {
                right1 = right1 - 1;
            }
        }

        if (result1 == -1 || result == -1) {
            return result1 - result;
        }

        return result1 - result + 1;
    }
    
    

    public static void main(String[] args) {
        int arr[] = {-5,-3,0,1,3,3,3,3,4,5};
        int key = 3;
        System.out.println("The key \"" + key + "\" occurs " + calcFreq3(arr, key) + " times in the Array.");
    }
}
