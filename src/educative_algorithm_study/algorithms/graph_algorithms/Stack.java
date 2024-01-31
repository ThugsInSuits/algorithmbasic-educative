package educative_algorithm_study.algorithms.graph_algorithms;

/**
 * @author XiZhuangBaoTu
 * Date 2024/1/31 11:07
 * Version 1.0
 * @description
 **/
public class Stack<V> {
    private int maxSize;
    private int top;
    private V[] array;
    private int currentSize;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.array = (V[]) new Object[maxSize];
        this.currentSize = 0;
    }

    public int getCurrentSize(){
        return this.currentSize;
    }

    public int getMaxSize(){
        return this.maxSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public V top(){
        if (isEmpty()) {
            return null;
        }
        return array[top];
    }

    public void push(V value) {
        if (isFull()) {
            System.out.println("statck is full");
        }
        array[++top] = value;
        currentSize++;
    }

    public V pop(){
        if (isEmpty()) {
            return null;
        }
        currentSize--;
        return array[top--];
    }
}
