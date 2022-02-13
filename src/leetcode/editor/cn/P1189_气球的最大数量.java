////给你一个字符串 text，你需要使用 text 中的字母来拼凑尽可能多的单词 "balloon"（气球）。 
////
//// 字符串 text 中的每个字母最多只能被使用一次。请你返回最多可以拼凑出多少个单词 "balloon"。 
////
//// 
////
//// 示例 1： 
////
//// 
////
//// 输入：text = "nlaebolko"
////输出：1
//// 
////
//// 示例 2： 
////
//// 
////
//// 输入：text = "loonbalxballpoon"
////输出：2
//// 
////
//// 示例 3： 
////
//// 输入：text = "leetcode"
////输出：0
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= text.length <= 10^4 
//// text 全部由小写英文字母组成 
//// 
//// 👍 92 👎 0
//


package leetcode.editor.cn;

//“气球” 的最大数量

import leetcode.editor.cn.level.简单;

import java.util.HashMap;
import java.util.Map;

public class P1189_气球的最大数量 implements 简单 {
    public static void main(String[] args) {
        Solution solution = new P1189_气球的最大数量().new Solution();
        solution.maxNumberOfBalloons("balon");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfBalloons(String text) {
            Map<Byte, Integer> counter = new HashMap<>();
            // 初始化单词计数
            String initStr = "balloon";
            for (byte aByte : initStr.getBytes()) {
                counter.put(aByte, 0);
            }
            // 进行计数
            for (byte aByte : text.getBytes()) {
                if (counter.containsKey(aByte)) {
                    counter.put(aByte, counter.get(aByte) + 1);
                }
            }
            int minResult = Integer.MAX_VALUE;
            // 获取结果
            for (Byte aByte : counter.keySet()) {
                if (aByte == 'l' || aByte == 'o') {
                    minResult = Math.min(minResult, (counter.get(aByte) / 2));
                }
                minResult = Math.min(minResult, counter.get(aByte));
            }
            return minResult;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}
