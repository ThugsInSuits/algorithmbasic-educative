package educative_algorithm_study.algorithms.greed_algorithms;

/**
 * @author XiZhuangBaoTu
 * Date 2024/2/2 10:40
 * Version 1.0
 * @description
 **/
public class MinHeap {
    int[] heaparr;
    int hSize;
    int capcity;

    /**
     *@Author XiZhuangBaoTu
     *@Description 构造函数的目的是初始化最小堆，使其满足最小堆的性质。这样一来，构造完成后，堆中的元素应该符合最小堆的定义，
     * 即每个节点的值都小于或等于其子节点的值。
     *@Date 15:23 2024/2/2
     *@Param [pipes, capcity]
     *@return
     **/
    public MinHeap(int pipes[] ,int capcity) {
        this.capcity = capcity;
        heaparr = pipes;
        hSize = capcity;
        // 从最后一个非叶子节点开始，逐个调用MinHeapify方法，以构建最小堆
        int i = (hSize - 1) / 2;
        while (i >= 0) {
            MinHeapify(i);
            i--;
        }
    }

    public void MinHeapify(int i ) {
        int l = left(i);
        int r = right(i);
        int smallest = i;
        if (l < hSize && heaparr[l] < heaparr[i]) {
            smallest = l;
        }
        if (r < hSize && heaparr[r] < heaparr[i]) {
            smallest = r;
        }
        if (smallest != i) {
            swap(i,smallest);
            MinHeapify(smallest);
        }
    }

    public int parent(int i) {
        return (i - 1) /2;
    }

    public int left(int i) {
        return (2 * i + 1);
    }

    public int right(int i) {
        return (2 * i + 2);
    }

    public int extractMin(){
        if (hSize <= 0) {
            return Integer.MAX_VALUE;
        }
        if (hSize == 1) {
            hSize--;
            return heaparr[0];
        }
        int root = heaparr[0];
        heaparr[0] = heaparr[hSize - 1];
        hSize--;
        MinHeapify(0);
        return root;
    }

    public void insertKey(int x) {
        if (hSize == capcity) {
            System.out.println("Could not insertKey");
            return;
        }

        hSize++;
        int i = hSize - 1;
        heaparr[i] = x;

        while (i != 0 && heaparr[parent(i)] > heaparr[i] ) {
            swap(i,parent(i));
            i = parent(i);
        }
    }

    void swap(int x,int y) {
        int temp = heaparr[x];
        heaparr[x] = heaparr[y];
        heaparr[y] = temp;
    }

    boolean sizeIsOne(){
        return hSize == 1;
    }
}
