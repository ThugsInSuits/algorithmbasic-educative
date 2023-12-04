package educative_algorithm_study.data_structes.data_structes_stack_queue;

/**
 * @author XiZhuangBaoTu
 * Date 2023/11/25 23:23
 * Version 1.0
 * @description
 **/
public class FindCelebChallenge {
    public static boolean aqStatus(int[][] arr,int x,int y) {
        return arr[x][y] == 1;
    }

    public static int findCelebrity(int[][] party,int numPeople) {
        Stack<Integer> stack = new Stack<>(numPeople);
        for (int i = 0; i < numPeople; i++) {
            stack.push(i);
        }
        int celebrity = -1;

        while (!stack.isEmpty()) {
            int x = stack.pop();
            if (stack.isEmpty()) {
                celebrity = x;
                break;
            }
            int y = stack.pop();
            // x认识y，则说明x不是名人，x不认识y，说明y不是名人
            if (aqStatus(party,x,y)) {
                stack.push(y);
            }else {
                stack.push(x);
            }
        }

        for (int i = 0; i < numPeople; i++) {
            if (celebrity != i && (aqStatus(party,celebrity,i) || !aqStatus(party,i,celebrity))){
                return -1;
            }
        }
        return celebrity;
    }

    public static void main(String args[]) {

        int [][] party1 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,0},
                {0,1,1,0},
        };

        int [][] party2 = {
                {0,1,1,0},
                {1,0,1,1},
                {0,0,0,1},
                {0,1,1,0},
        };

        int [][] party3 = {
                {0,0,0,0},
                {1,0,0,1},
                {1,0,0,1},
                {1,1,1,0},
        };

        System.out.println(findCelebrity(party1,4));
        System.out.println(findCelebrity(party2,4));
        System.out.println(findCelebrity(party3,4));
    }
}
