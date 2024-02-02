package educative_algorithm_study.algorithms.greed_algorithms;

import java.util.ArrayList;

/**
 * @author XiZhuangBaoTu
 * Date 2024/2/2 10:05
 * Version 1.0
 * @description
 **/
public class ChangeMachine {
    // a public collection of available coins
    public static int [] coins = {25, 10, 5, 1};

    public static ArrayList<Integer> getMinCoins(int amount)  // function to recieve change in the form of coins
    {
        ArrayList<Integer> change = new ArrayList<Integer>();
        for (int i = 0; i < coins.length && amount > 0; i++) {
            while (amount > coins[i]) {
                amount -= coins[i];
                change.add(coins[i]);
            }
        }
        return change;
    }

    public static void main(String args[])
    {
        // Play around with this amount to see how many coins you get!
        int amount = 1;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 17;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 33;
        System.out.println(amount + " --> " + getMinCoins(amount));

        amount = 99;
        System.out.println(amount + " --> " + getMinCoins(amount));
    }


}
