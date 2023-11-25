package educative_algorithm_study.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/26 05:55
 * Version 1.0
 * @description
 **/
public class MinStack {
    int maxSize;
    Stack<Integer> mainStack;
    Stack<Integer> minStack;

    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
        minStack = new Stack<>(maxSize);
        mainStack = new Stack<>(maxSize);
    }
    //removes and returns value from stack
    public Integer pop(){
        minStack.pop();
        return mainStack.pop();
    }
    //pushes value into the stack
    public void push(Integer value){
        mainStack.push(value);
        if (!minStack.isEmpty() && minStack.top() < value) {
            minStack.push(minStack.top());
        }else {
            minStack.push(value);
        }
    }
    //returns minimum value in O(1)
    public int min(){
        return minStack.top();
    }
    public static void main(String args[]) {

        MinStack stack = new MinStack(6);
        stack.push(5);
        stack.push(2);
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(9);

        System.out.println(stack.min());

        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack.min());

    }
}