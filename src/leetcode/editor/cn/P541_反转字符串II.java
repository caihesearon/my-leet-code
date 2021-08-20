//给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 

// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
//
// 提示：
// 
// Related Topics 双指针 字符串 👍 157 👎 0


package leetcode.editor.cn;

//反转字符串 II

public class P541_反转字符串II {
    public static void main(String[] args) {
        Solution solution = new P541_反转字符串II().new Solution();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }
//"cbad"

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseStr(String s, int k) {
            char[] chars = s.toCharArray();
            int left = 0;
            int right = left + k - 1;
            while (right < s.length() - 1) {
                swap(chars, left, right);
                left = right + k + 1;
                right = left + k - 1;
            }
            if (left < s.length() - 1) {
                swap(chars, left, s.length() - 1);
            }


            return new String(chars);
        }

        private void swap(char[] chars, int left, int right) {
            while (left <= right) {
                char tmp = chars[left];
                chars[left] = chars[right];
                chars[right] = tmp;
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}