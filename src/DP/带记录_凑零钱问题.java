package DP;

import java.util.Arrays;

/**
 * @author caihe
 * @date 2021/8/25 14:07
 */
public class 带记录_凑零钱问题 {


    public static void main(String[] args) {
        System.out.println(fun(11, new int[]{1, 2, 5}));
    }

    private static int fun(int n, int[] moneys) {
        // 初始化记录
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -2);
        return deal(n, moneys, memo);
    }

    private static int deal(int n, int[] moneys, int[] memo) {
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int val :
                moneys) {
            if (n - val < 0) {
                continue;
            }
            int res = deal(n - val, moneys, memo);
            if (res != -1) {
                ans = Math.min(ans, res + 1);
            }
        }
        memo[n] = ans == Integer.MAX_VALUE ? -1 : ans;
        return memo[n];
    }


}
