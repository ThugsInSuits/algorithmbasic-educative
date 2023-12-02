package educative_algorithm_study.data_structes_heap;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/1 15:36
 * Version 1.0
 * @description
 **/
public class CheckSmall {
    public static int[] findKSmallest(int[] arr,int k) {
        int arraySize = arr.length;

        if (k <= arraySize) {
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = removeMin(arr,arraySize);
                --arraySize;
            }
            return result;
        }
        System.out.println("value of k = " + k + "out of bounds");
        return arr;
    }

    public static int removeMin(int[] arr,int arraySize) {
        buildMinHeap(arr,arraySize);
        int min = arr[0];
        arr[0] = arr[arr.length - 1];
        return min;
    }

    public static void buildMinHeap(int[] arr,int size) {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            minHeapify(arr,i,size);
        }
    }

    public static void minHeapify(int[] arr,int index,int size) {
        int smallest = index;
        while (smallest <= size / 2) {
            int leftIndex = (smallest * 2 ) + 1;
            int rightIndex = (smallest * 2) + 2;

            if (leftIndex < size && arr[leftIndex] < arr[smallest]) {
                smallest = leftIndex;
            }
            if (rightIndex < size && arr[rightIndex] < arr[smallest]) {
                smallest = rightIndex;
            }
            if (smallest != index) {
                int temp = arr[index];
                arr[index] = arr[smallest];
                arr[smallest] = temp;
                index = smallest;
            }else {
                break;
            }
        }
    }

    public static void main(String args[]) {
        int[] input = {9, 4, 7, 1, -2, 6, 5};
        int[] output = findKSmallest(input, 2);

        for(int i = 0; i < output.length; i++)
            System.out.println(output[i]);
    }
}
