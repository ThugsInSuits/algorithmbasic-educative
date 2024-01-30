package educative_algorithm_study.algorithms.searchinarotatedarray;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/19 23:24
 * Version 1.0
 * @description
 **/
public class SearchArray {
    static int searchRotatedArray(int arr[],int left,int right,int n) {
        if (right <= 0) {
            return -1;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                return i;
            }
        }
        return -1;
    }

    static int searchRotatedArray2(int arr[],int left,int right,int n) {
        int mid = (left + right) / 2;
        if (arr[mid] == n) {
            return mid;
        }
        if (left > right) {
            return  -1;
        }

        if (arr[left] < arr[mid]) {
            if (n >= arr[left] && n < arr[mid]) {
                return searchRotatedArray2(arr,left,mid - 1,n);
            }else{
                return searchRotatedArray2(arr,left+1,right,n);
            }
        }else if (arr[mid] < arr[right]) {
            if (n <= arr[right] && n > arr[mid]) {
                return searchRotatedArray2(arr,mid+1,right,n);
            }else {
                return searchRotatedArray2(arr,left,mid-1,n);
            }
        }else if (arr[left] == arr[mid]){
            if (arr[mid] != arr[right]) {
                return searchRotatedArray2(arr,mid+1,right,n);
            }else {
                int result = searchRotatedArray2(arr,left,mid-1,n);
                if (result == -1 ) {
                    return searchRotatedArray2(arr,mid+1,right,n);
                }else {
                    return result;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {40,100,-100,40,0,24,40};
        System.out.println(searchRotatedArray2(arr, 0, 6, -100));
    }
}
