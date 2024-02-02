package educative_algorithm_study.algorithms.greed_algorithms;

/**
 * @author XiZhuangBaoTu
 * Date 2024/2/2 15:34
 * Version 1.0
 * @description
 **/
public class Fraction {
    /**
     * @return void
     * @Author XiZhuangBaoTu
     * @Description //TODO
     * @Date 15:53 2024/2/2
     * @Param [numerator, denominator]分子，分母
     **/
    public static void printEgyptianFraction(int numerator, int denominator) {
        // 如果分子或者分母为0，直接返回
        if (denominator == 0 || numerator == 0) {
            return;
        }

        // 如果分母能整除分子，那就直接约分了。这里也是迭代结束的关键地方
        if (denominator % numerator == 0) {
            System.out.println("1/" + denominator / numerator);
            return;
        }

        // 如果分子能被分母约分，那就直接约分
        if (numerator % denominator == 0) {
            System.out.println(numerator / denominator);
            return;
        }

        // 如果分子大于分母，取余数作为分子继续迭代，最终获取1/x形式的组成
        if (numerator > denominator) {
            System.out.println(numerator / denominator + " , ");
            printEgyptianFraction(numerator % denominator, denominator);
            return;
        }

        // 这里加1是为了确保至少有一个单位分数，使得其最小于原始分数
        // 比如 6/7，7/6=1，那么1/1是大于6/7的
        int n = denominator / numerator + 1;
        // 求得最大的单元后，用原数-1/n,e.g  6/14  计算后 n = 3,那就是 6/14 - 1/3 = （6 * 3 - 14）/ （14 * 3）
        // 继续迭代，直到分子为1的时候，跳出
        printEgyptianFraction(numerator * n - denominator, denominator * n);
    }

    public static void main(String[] args) {

        //Example 1
        int numerator = 6, denominator = 14;
        System.out.print("Egyptian Fraction Representation of " + numerator + "/" + denominator + " is\n ");
        Fraction.printEgyptianFraction(numerator, denominator);
        System.out.println();

        //Example 2
        numerator = 2;
        denominator = 3;
        System.out.print("Egyptian Fraction Representation of " + numerator + "/" + denominator + " is\n ");
        Fraction.printEgyptianFraction(numerator, denominator);
    }

}
