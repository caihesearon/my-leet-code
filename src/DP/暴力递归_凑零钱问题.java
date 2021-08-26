package DP;

/**
 * 给你 k 种面值的硬币，面值分别为 c1, c2 ... ck，再给一个总金额 n，问你最少需要几枚硬币凑出这个金额，如果不可能凑出，则回答 -1 。
 * <p>
 * <p>
 * 比如说，k = 3，面值分别为 1，2，5，总金额 n = 11，那么最少需要 3 枚硬币，即 11 = 5 + 5 + 1 。下面走流程。
 *
 * @author caihe
 * @date 2021/8/25 13:47
 */
public class 暴力递归_凑零钱问题 {


    public static void main(String[] args) {
        System.out.println(deal(11, new int[]{1, 2 ,5}));
    }

    private static int deal(int n, int[] moneys) {
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < moneys.length; i++) {
            int money = moneys[i];
            if (n - money < 0) {
                continue;
            }
            int res = deal(n - money, moneys);
            if (res != -1) {
                ans = Math.min(ans, res + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
