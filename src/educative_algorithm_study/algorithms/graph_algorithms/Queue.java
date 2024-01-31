package educative_algorithm_study.algorithms.graph_algorithms;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/31 11:17
 * Version 1.0
 * @description
 **/
public class Queue<V> {
    private int maxSize;
    private V[] array;
    private int front;
    private int back;
    private int currentSize;

    public Queue(int maxSize){
        this.maxSize = maxSize;
        this.array = (V[]) new Object[maxSize];
        this.front = 0;
        this.back = -1;
        currentSize = 0;
    }

    public int getMaxSize(){
        return maxSize;
    }

    public int getCurrentSize(){
        return this.currentSize;
    }

    public boolean isEmpty(){
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public void enqueue(V value) {
        if (isFull()) {
            return;
        }
        back = (back + 1) % maxSize; //  这里是为了控制index在范围内
        array[back] = value;
        currentSize++;
    }

    public V dequeue() {
        if (isEmpty()) {
            return null;
        }
        V temp = array[front];
        front = (front + 1) % maxSize;
        currentSize--;
        return temp;
    }
}
