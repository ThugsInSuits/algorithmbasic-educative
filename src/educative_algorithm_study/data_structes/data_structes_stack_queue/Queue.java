package educative_algorithm_study.data_structes.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/25 13:57
 * Version 1.0
 * @description
 **/
public class Queue <V>{
    private int maxSize;
    private V[] array;
    private int front;
    private int back;
    private int currentSize;

    @SuppressWarnings("unchecked")
    public Queue(int maxSize){
        this.maxSize = maxSize;
        array = (V[]) new Object[maxSize];
        front = 0;
        back = -1;
        currentSize = 0;

    }

    public int MaxSize(){
        return maxSize;
    }

    public int getCurrentSize(){
        return currentSize;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull(){
        return currentSize == maxSize;
    }

    public V pop(){
        return array[front];
    }

    public void enqueue(V value) {
        if (isFull()) {
            return;
        }
        back = (back + 1)%maxSize;
        array[back] = value;
        currentSize++;
    }

    public V dequeue(){
        if (isEmpty()) {
            return null;
        }
        V temp = array[front];
        front = (front+1) % maxSize;
        currentSize--;
        return temp;
    }
}
