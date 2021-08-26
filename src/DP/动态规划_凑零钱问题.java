package DP;

import java.util.Arrays;

/**
 * @author caihe
 * @date 2021/8/25 14:14
 */
public class 动态规划_凑零钱问题 {

    public static void main(String[] args) {
        System.out.println(deal(11, new int[]{1, 2 ,5}));
    }

    private static int deal(int n, int[] moneys) {
        // dp下标代表着 钱为xxx时对应的结果
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int j = 0; j < dp.length; j++) {
            for (int money : moneys) {
                if (j - money < 0) {
                    continue;
                }
                dp[j] = Math.min(dp[j], dp[j - money] + 1);
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];
    }

}
