package educative_algorithm_study.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/25 19:37
 * Version 1.0
 * @description
 **/
public class SortValuesChallenge {
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>(stack.getMaxSize());


        while (!stack.isEmpty()) {
            Integer minValue = stack.pop();
            if (temp.isEmpty()) {
                temp.push(minValue);
            }else {
                while (!temp.isEmpty() && temp.top() >minValue) {
                    stack.push(temp.pop());
                }
                temp.push(minValue);
            }


        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }

    }

    public static void main(String args[]) {

        Stack<Integer> stack = new Stack<Integer>(7);
        stack.push(2);
        stack.push(97);
        stack.push(4);
        stack.push(42);
        stack.push(12);
        stack.push(60);
        stack.push(23);
        sortStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}