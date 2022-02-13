//给你一个整数 n ，请你返回所有 0 到 1 之间（不包括 0 和 1）满足分母小于等于 n 的 最简 分数 。分数可以以 任意 顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2
//输出：["1/2"]
//解释："1/2" 是唯一一个分母小于等于 2 的最简分数。 
//
// 示例 2： 
//
// 输入：n = 3
//输出：["1/2","1/3","2/3"]
// 
//
// 示例 3： 
//
// 输入：n = 4
//输出：["1/2","1/3","1/4","2/3","3/4"]
//解释："2/4" 不是最简分数，因为它可以化简为 "1/2" 。 
//
// 示例 4： 
//
// 输入：n = 1
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 100 
// 
// 👍 82 👎 0


package leetcode.editor.cn;

//最简分数

import leetcode.editor.cn.classification.最大公约数_GCD;
import leetcode.editor.cn.classification.最小公倍数;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1447_最简分数 implements 最大公约数_GCD, 最小公倍数 {
    public static void main(String[] args) {
        Solution solution = new P1447_最简分数().new Solution();
        System.out.println(Arrays.toString(solution.simplifiedFractions(4).toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> simplifiedFractions(int n) {
            List<String> result = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (i == 1) {
                        result.add(String.format("%d/%d", i, j));
                    } else {
                        if (gcd(i, j) == 1) {
                            result.add(String.format("%d/%d", i, j));
                        }
                    }
                }
            }
            return result;
        }

        // 求最大公约数
        public int gcd(int a, int b) {
            if (b % a == 0) return a;
            return gcd(b % a, a);
        }

        public int minGcd(int a, int b) {
            return b == 0 ? a : minGcd(b % a, a);
        }

        int lcm(int a, int b) //最小公倍数 = 两数相乘/最大公约数
        {
            return a * b / gcd(a, b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}