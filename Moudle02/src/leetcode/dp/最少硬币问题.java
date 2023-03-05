package leetcode.dp;


/**
 * 问题：给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 */
public class 最少硬币问题 {



    public static int coinChange(int[] coins, int amount) {
        return minCoins(coins, 0, amount);
    }

    /**
     * 暴力尝试：左到右尝试，每次无非拿与不拿
     */

    public static int minCoins(int[] coins, int index, int amount){
        //找到一种拿法
        if(amount == 0) return 0;
        //走完了，没拿够钱
        if(index == coins.length) return -1;

        int yes = -1;
        int no = -1;

        //只有当前面额小于等于当前需要的钱时才拿，避免余量小于0，也可以在baseCase中加amount小于0的情况
        if(coins[index] <= amount){
            yes = minCoins(coins, index + 1, amount - coins[index]);
        }

        no = minCoins(coins, index + 1, amount);

        if(yes ==-1 && no == -1){
            return -1;
        }else {
            if(yes == -1) return no;
            if(no == -1) return yes + 1;
            return Math.min(yes + 1, no);
        }
    }

    public static void main(String[] args) {

    }

}
