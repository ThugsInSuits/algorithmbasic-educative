package educative_algorithm_study.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/25 17:40
 * Version 1.0
 * @description
 **/
public class Optimized_QueueWithStack <V>{
    private Stack<V> stack1;
    private Stack<V> stack2;

    /**
     *@Author XiZhuangBaoTu
     *@Description //这里优化的点在于说，固定入栈从1入，出栈从2出
     *@Date 19:30 2023/11/25
     *@Param [maxSize]
     *@return
     **/
    public Optimized_QueueWithStack(int maxSize) {
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }

    public  void enqueue(V value ){
        stack1.push(value);
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public V dequeue() {
        if (isEmpty() ) {
            return null;
        }else if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }

    }
    public static void main(String args[]) {

        QueueWithStack<Integer> queue = new QueueWithStack<Integer>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue()); //this will output null because queue will be empty
    }

}
