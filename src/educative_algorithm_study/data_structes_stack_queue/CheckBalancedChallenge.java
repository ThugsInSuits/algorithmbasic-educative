package educative_algorithm_study.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/26 05:07
 * Version 1.0
 * @description
 **/
public class CheckBalancedChallenge {
    public static boolean isBalanced(String exp) {
        Stack<Character> stack = new Stack<>(exp.length());
        char temp;

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    temp = stack.pop();
                    if (temp != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    temp = stack.pop();
                    if (temp != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    temp = stack.pop();
                    if (temp != '{') {
                        return false;
                    }
                    break;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String args[]) {

        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("[{(}]"));

    }
}
