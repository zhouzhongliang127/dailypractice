package leetcode.dp;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc2400_恰好移动k步到达某一位置的方法数目 {

    public static int numberOfWays(int startPos, int endPos, int k) {
        if(startPos + k == endPos) return 1;
        if(k == 0) return startPos == endPos ? 1 : 0;

        return (numberOfWays(startPos - 1, endPos, k - 1) + numberOfWays(startPos + 1, endPos, k - 1)) % ((int)Math.pow(10, 9) + 7);
    }

    static int mod = 1_000_000_007;
    public static int numberOfWays_dp(int startPos, int endPos, int k){
        if(endPos - startPos > k) return 0;

        int period = 2 * k + 1;
        int[][] dp = new int[k + 1][period];

        Arrays.fill(dp[0], 0);
        dp[0][endPos - startPos + k] = 1;//只有0步时,在终点位置才算一个方案

        for (int i = 1; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++){
                if(j == 0){
                    dp[i][j] = dp[i - 1][j + 1];
                }else if(j == period - 1){
                    dp[i][j] = dp[i -1][j - 1];
                }else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        return dp[k][k];
    }

    public int numberOfWays_dp_upgrade(int startPos, int endPos, int k){
        if(endPos - startPos > k) return 0;

        int period = 2 * k + 3;
        int[][] dp = new int[k + 1][period];

        dp[0][endPos - startPos + k + 1] = 1;//只有0步时,在终点位置才算一个方案

        for (int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length - 1; j++){
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }
        return dp[k][k + 1];
    }


    public static void main(String[] args) {

        System.out.println(numberOfWays_dp(264, 198, 68));
    }


    /**
     * 记忆化搜索优化-map
     * @return
     */
    static Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    public static int numberOfWays_02(int startPos, int endPos, int k) {
        Pair<Integer, Integer> pair = new Pair<>(startPos, k);
        if(map.containsKey(pair)){
            return map.get(pair);
        }
        if(startPos + k == endPos) {
            map.put(pair, 1);
            return 1;
        }
        if(k == 0) return startPos == endPos ? 1 : 0;

        int curPosCount = (numberOfWays_02(startPos - 1, endPos, k - 1) + numberOfWays_02(startPos + 1, endPos, k - 1)) % ((int)Math.pow(10, 9) + 7);
        map.put(pair, curPosCount);
        return curPosCount;
    }

    /**
     * 记忆搜索优化-【】【】
     * @param startPos
     * @param endPos
     * @param k
     * @return
     */
    public static int numberOfWays_03(int startPos, int endPos, int k) {
        int[][] dp = new int[2 * k + 1][k + 1];
        for(int i = 0; i <= (k << 1); i++){
            for(int j = 0; j <= k; j++){
                dp[i][j] = -1;
            }
        }
        return f(startPos, endPos, k, dp, startPos, k);
    }

    public static int f(int startPos, int endPos, int k, int[][] dp, int yuandian, int p){
        int index = startPos - yuandian + p;
        if(dp[index][k] != -1){
            return dp[index][k];
        }
        if(startPos + k == endPos) {
            dp[index][k] = 1;
            return dp[index][k];
        }
        if(k == 0) return startPos == endPos ? 1 : 0;

        dp[index][k] = (
                f(startPos - 1, endPos, k - 1, dp, yuandian, p) +  f(startPos + 1, endPos, k - 1, dp, yuandian, p)) %
                ((int)Math.pow(10, 9) + 7);
        return dp[index][k];
    }
}
