package educative_algorithm_study.data_structes.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/25 20:21
 * Version 1.0
 * @description
 **/
public class EvaluatePostfixChallenge {
    public static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>(expression.length());
        // 1. Scan expression character by character
        // 2. if character is a number push it in stack
        // 3. if character is operator then pop two elements from stack
        // perform the operation and put the result back in stack
        // at the end ,Stack will contailn result of while expression.
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (!Character.isDigit(character)) {
                Integer x = stack.pop();
                Integer y = stack.pop();

                switch (character) {
                    case '+':
                        stack.push(y + x);
                        break;
                    case '-':
                        stack.push(y - x);
                        break;
                    case '*':
                        stack.push(y * x);
                        break;
                    case '/':
                        stack.push(y / x);
                        break;
                }

            }else {
                stack.push(Character.getNumericValue(character));
            }
        }
        return stack.pop();
    }

    public static void main(String args[]) {

        System.out.println(evaluatePostFix("921*-8-4+"));
        //Try your own examples below

    }
}
