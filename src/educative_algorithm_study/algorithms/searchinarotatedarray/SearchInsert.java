package educative_algorithm_study.algorithms.searchinarotatedarray;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/30 12:39
 * Version 1.0
 * @description
 **/
public class SearchInsert {
    public static int insertPosition(int arr[], int target)
    {
        if (arr.length < 1) {
            return -1;
        }
        int sizeArr = arr.length;
        int start = 0,end = sizeArr - 1,mid,pos = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }else  if (arr[mid] > target) {
                end = mid - 1;
                pos = mid;
            }else {
                start = mid + 1;
                pos = mid + 1;
            }
        }
        // write your code here
        return pos;
    }

    public static void main(String args[])
    {
        int[]arr = {0, 1, 2, 3, 5, 6};

        // Example 1
        System.out.println("Index to Insert " + "\"5\" is " + insertPosition(arr, 5));

        // Example 2
        System.out.println("Index to Insert " + "\"3\" is " + insertPosition(arr, 3));

        // Example 3
        System.out.println("Index to Insert " + "\"7\" is " + insertPosition(arr, 7));
    }
}
