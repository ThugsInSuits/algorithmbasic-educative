package educative_algorithm_study.data_structes.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/25 13:30
 * Version 1.0
 * @description
 **/
public class Stack<V> {
    private int maxSize;
    private int top;
    private V[] arr;

    @SuppressWarnings("unchecked")
    public Stack(int max_size){
        this.maxSize = max_size;
        this.top = -1;
        arr = (V[]) new Object[max_size];
    }

    public int getMaxSize() {
        return maxSize;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public V top(){
        if (isEmpty()) {
            return null;
        }
        return arr[top];
    }

    public void push(V value) {
        if (isFull()) {
            System.out.println("This stack is full");
            return;
        }
        arr[++top] = value;
    }

    public V pop() {
        if (isEmpty()) {
            return null;
        }
        return arr[top--];
    }

}
