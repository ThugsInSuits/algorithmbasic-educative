package educative_algorithm_study.data_structes.data_structes_heap;

import java.util.Arrays;

/**
 * @author XiZhuangBaoTu
 * Date 2023/12/1 13:14
 * Version 1.0
 * @description
 **/
public class Heap {
    private void maxHeapify(int[] heapArray,int index,int heapSize) {
        int largest = index;
        while(largest < heapSize / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < heapSize && heapArray[left] > heapArray[largest]) {
                largest = left;
            }
            if (right < heapSize && heapArray[right] > heapArray[largest]) {
                largest = right;
            }
            if (largest != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[largest];
                heapArray[largest] = temp;
                index = largest;
            }else {
                break;
            }
        }
    }

    public void buildMaxHeap(int[] heapArray,int heapSize ) {
        for (int i = (heapSize - 1) / 2; i >= 0 ; i--) {
            maxHeapify(heapArray,i,heapSize);
        }
    }

    private static void minHeapify(int[] heapArray,int index,int heapSize) {
        int smallest = index;
        while (smallest < heapSize / 2) {
            int leftIndex = (2 * index) + 1;
            int rightIndex = (2 * index) + 2;
            if (leftIndex < heapSize && heapArray[leftIndex] < heapArray[smallest]) {
                smallest = leftIndex;
            }
            if (rightIndex < heapSize && heapArray[rightIndex] < heapArray[smallest]) {
                smallest =  leftIndex;
            }
            if (smallest != index) {
                int temp = heapArray[index];
                heapArray[index] = heapArray[smallest];
                heapArray[smallest] = temp;
                index = smallest;
            }else {
                break;
            }
        }
    }

    public static void buildMinHeap(int[] arr,int heapsize) {
        for (int i = (heapsize -1 ) / 2; i >= 0; i--) {
            minHeapify(arr,i,heapsize);
        }
    }

    public static void main(String[] args) {
        int[] heapArray = { 1, 4, 7, 12, 15, 14, 9, 2, 3, 16 };

        System.out.println("Before heapify: "+ Arrays.toString(heapArray));
        new Heap().buildMaxHeap(heapArray, heapArray.length);
        System.out.println("After heapify: "+Arrays.toString(heapArray));

        int[] minHeapArray = { 31, 11, 7, 12, 15, 14, 9, 2, 3, 16 };

        System.out.println("Before heapify: "+Arrays.toString(minHeapArray));
        new Heap().buildMinHeap(minHeapArray, minHeapArray.length);
        System.out.println("After heapify: "+Arrays.toString(minHeapArray));
    }

}
