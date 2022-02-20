//有两种特殊字符： 
//
// 
// 第一种字符可以用一个比特 0 来表示 
// 第二种字符可以用两个比特(10 或 11)来表示、 
// 
//
// 给定一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一位字符，则返回 true 。 
//
// 
//
// 示例 1: 
//
// 
//输入: bits = [1, 0, 0]
//输出: true
//解释: 唯一的编码方式是一个两比特字符和一个一比特字符。
//所以最后一个字符是一比特字符。
// 
//
// 示例 2: 
//
// 
//输入: bits = [1, 1, 1, 0]
//输出: false
//解释: 唯一的编码方式是两比特字符和两比特字符。
//所以最后一个字符不是一比特字符。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= bits.length <= 1000 
// bits[i] == 0 or 1 
// 
// 👍 260 👎 0


package leetcode.editor.cn;

//1比特与2比特字符

import leetcode.editor.cn.level.简单;

public class P717_1比特与2比特字符 implements 简单 {
    public static void main(String[] args) {
        Solution solution = new P717_1比特与2比特字符().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 遇到0走一步 遇到1走两步 走到最后判断是否最后一位为0
         * @param bits
         * @return
         */
        public boolean isOneBitCharacter(int[] bits) {
            int len = bits.length, index = 0;
            while(index < len - 1) {
                index += bits[index] + 1;
            }
            return index == bits.length - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}