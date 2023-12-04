package educative_algorithm_study.data_structes.data_structes_array;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/17 22:27
 * Version 1.0
 * @description
 **/
public class CheckRemoveEven {
    public static void main(String[] args) {
        int size = 10;
        int[] origionArr = new int[size];
        System.out.println("Before remove Even Number:");
        for (int i = 0; i < size; i++) {
            origionArr[i] = i;
            System.out.print(origionArr[i] + " ");
        }
        System.out.println();
        int[] newArr = removeEven(origionArr);
        System.out.println("After remove Even Number:");
        for (int i = 0; i < newArr.length; i++) {
            System.out.print(newArr[i] + " ");
        }
    }

    public static int[] removeEven(int[] arr) {
        int oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] %2 != 0) {
                oddCount++;
            }
        }
        int[] newArr = new int[oddCount];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] %2 != 0) {
                newArr[index++] = arr[i];
            }
        }
        return newArr;
    }
}
