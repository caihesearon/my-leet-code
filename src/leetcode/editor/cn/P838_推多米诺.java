//n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。 
//
// 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。 
//
// 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。 
//
// 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。 
//
// 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中： 
//
// 
// dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧， 
// dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧， 
// dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。 
// 
//
// 返回表示最终状态的字符串。 
// 
//
// 示例 1： 
//
// 
//输入：dominoes = "RR.L"
//输出："RR.L"
//解释：第一张多米诺骨牌没有给第二张施加额外的力。
// 
//
// 示例 2： 
//
// 
//输入：dominoes = ".L.R...LR..L.."
//输出："LL.RR.LLRRLL.."
// 
//
// 
//
// 提示： 
//
// 
// n == dominoes.length 
// 1 <= n <= 10⁵ 
// dominoes[i] 为 'L'、'R' 或 '.' 
// 
// 👍 156 👎 0


package leetcode.editor.cn;

//推多米诺

import leetcode.editor.cn.level.中等;

public class P838_推多米诺 implements 中等 {
    public static void main(String[] args) {
        Solution solution = new P838_推多米诺().new Solution();
        System.out.println(solution.pushDominoes("R.R.L"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String pushDominoes(String dominoes) {

            char[] dominoesChars = dominoes.toCharArray();
            // 循环找到不是触发点的位置
            for (int i = 0; i < dominoes.length(); i++) {
                if (dominoesChars[i] == '.') {
                    // 找到点后分别从前后找到各个操作点  并操作这个区间的点
                    dealPoint(dominoesChars, i);
                }
            }
            return String.valueOf(dominoesChars);
        }

        private void dealPoint(char[] dominoesChars, int targetIndex) {
            int leftIndex = targetIndex, rightIndex = targetIndex;
            while (leftIndex > 0 && dominoesChars[leftIndex] == '.') {
                leftIndex--;
            }
            while (rightIndex < dominoesChars.length - 1 && dominoesChars[rightIndex] == '.') {
                rightIndex++;
            }
            if (dominoesChars[leftIndex] == 'R' && dominoesChars[rightIndex] == 'L') {
                for (; leftIndex < rightIndex; leftIndex++, rightIndex--) {
                    dominoesChars[leftIndex] = 'R';
                    dominoesChars[rightIndex] = 'L';
                }
            } else if (dominoesChars[rightIndex] == 'L') {
                while (--rightIndex >= 0 && dominoesChars[rightIndex] == '.') {
                    dominoesChars[rightIndex] = 'L';
                }
            } else if (dominoesChars[leftIndex] == 'R') {
                while (++leftIndex < dominoesChars.length && dominoesChars[leftIndex] == '.') {
                    dominoesChars[leftIndex] = 'R';
                }
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)


}