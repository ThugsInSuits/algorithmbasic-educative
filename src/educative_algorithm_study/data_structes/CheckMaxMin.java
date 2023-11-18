package educative_algorithm_study.data_structes;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/18 20:45
 * Version 1.0
 * @description
 **/
public class CheckMaxMin {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        maxMin(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void maxMin(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int[] newArr = new int[arr.length];

        boolean switchTag = true;

        for (int i= 0 ;i < arr.length ;i++) {
            if (switchTag) {
                newArr[i] = arr[end--];
            }else {
                newArr[i] = arr[start++];
            }
            switchTag = !switchTag;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = newArr[i];
        }
    }
}
