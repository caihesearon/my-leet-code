package DP;

import java.util.Arrays;

/**
 * @author caihe 1 1 2 3 5 8
 * @date 2021/8/24 15:46
 */
public class 动态规划_菲波那切数列 {

    public static void main(String[] args) {
        System.out.println(fun(6));
        
    }

    private static int fun(int n) {
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
