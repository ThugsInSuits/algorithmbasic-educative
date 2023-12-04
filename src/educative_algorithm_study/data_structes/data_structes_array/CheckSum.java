package educative_algorithm_study.data_structes.data_structes_array;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/17 22:53
 * Version 1.0
 * @description
 **/
class CheckSum
{
    public static void main(String[] args) {
        int[] arr = {1,21,3,14,5,60,7,6};
        int[] result = findSum(arr,27);
        System.out.println("Result: " + result[0] + " " + result[1]);
    }
    public static int[] findSum(int[] arr, int n)
    {
        int[] result = new int[2];
        for (int i = 0 ;i < arr.length;i++) {
            for ( int j = i + 1; j< arr.length;j++) {
                if ( arr[i] + arr[j] == n)  {
                    result[0] = arr[i];
                    result[1] = arr[j];
                    return result;
                }
            }
        }
        return arr;
    }
}