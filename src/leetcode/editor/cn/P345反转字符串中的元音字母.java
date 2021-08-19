//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。
//
//
//
// 示例 1：
//
//
//输入：s = "hello"
//输出："holle"
//
//
// 示例 2：
//
//
//输入：s = "leetcode"
//输出："leotcede"
//
//
//
// 提示：
//
//
// 1 <= s.length <= 3 * 105
// s 由 可打印的 ASCII 字符组成
//	        测试用例:" apG0i4maAs::sA0m4i0Gp0"
//			测试结果:" ipG0A4maAs::si0m4a0Gp0"
//			期望结果:" ipG0A4mAas::si0m4a0Gp0"
// Related Topics 双指针 字符串
// 👍 208 👎 0

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

//Java：反转字符串中的元音字母
class P_反转字符串中的元音字母 {
    public static void main(String[] args) {
        Solution solution = new P_反转字符串中的元音字母().new Solution();
        solution.reverseVowels("hello");

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<Character> characters = Arrays.asList('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u');

        public String reverseVowels(String s) {
            char[] chars = s.toCharArray();
            goodDeal(chars, 0, chars.length - 1);
            String s1 = new String(chars);
            System.out.println(s1);
            return s1;
        }
        private void goodDeal(char[] chars, int start, int end) {

            while(start < end) {
                // 首尾都为元音
                if (characters.contains(chars[start]) && characters.contains(chars[end])) {
                    char tmp = chars[start];
                    chars[start] = chars[end];
                    chars[end] = tmp;
                    start++;
                    end--;

                }
                // 左边不为元音
                if (!characters.contains(chars[start])) {
                    start++;
                }
                // 右边不为元音
                if (!characters.contains(chars[end])) {
                    end--;
                }
            }
        }

        private void deal(char[] chars, int start, int end) {
            if (start >= end) {
                return;
            }
            for (int i = start; i <= end; i++) {
                if (characters.contains(chars[i])) {
                    char aChar = chars[i];
                    for (int j = end;  j > i; j--) {
                        if (characters.contains(chars[j])) {
                            // change
                            chars[i] = chars[j];
                            chars[j] = aChar;
                            end = j - 1;
                            break;
                            //deal(chars, i + 1, j - 1);
                        }
                    }
                }
            }

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
