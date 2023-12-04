package educative_algorithm_study.data_structes.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/25 17:26
 * Version 1.0
 * @description
 **/
public class QueueWithStack<V> {
    private Stack<V> stack1;
    private Stack<V> stack2;

    public QueueWithStack(int maxSize){
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }

    public boolean isEmpty( ){
        return stack2.isEmpty();
    }

    public void enqueue(V value) {
      stack1.push(value);
    }

    public V dequeue() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        V temp = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return temp;
    }
}
