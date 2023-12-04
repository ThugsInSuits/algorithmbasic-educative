package educative_algorithm_study.data_structes.data_structes_array;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/18 20:45
 * Version 1.0
 * @description
 **/
public class CheckMaxMin {
    public static void main(String[] args) {
        int[] arr = {11,22,33,44,55,66,77,88,99};
        maxMin2(arr);
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

    public static void maxMin2(int[] arr) {
       int mixIndex = 0;
       int maxIndex = arr.length -1;
       int maxValue = arr[maxIndex] + 1;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIndex] % maxValue) * maxValue;
                maxIndex--;
            }else {
                arr[i] += (arr[mixIndex] % maxValue) * maxValue;
                mixIndex++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] / maxValue;
        }
    }
}
