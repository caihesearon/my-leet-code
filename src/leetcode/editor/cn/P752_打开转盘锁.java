//你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9
//' 。每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 
//
// 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 
//
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 
//
// 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//输出：6
//解释：
//可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
//注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
//因为当拨动到 "0102" 时这个锁就会被锁定。
// 
//
// 示例 2: 
//
// 
//输入: deadends = ["8888"], target = "0009"
//输出：1
//解释：
//把最后一位反向旋转一次即可 "0000" -> "0009"。
// 
//
// 示例 3: 
//
// 
//输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//输出：-1
//解释：
//无法旋转到目标数字且不被锁定。
// 
//
// 示例 4: 
//
// 
//输入: deadends = ["0000"], target = "8888"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target 不在 deadends 之中 
// target 和 deadends[i] 仅由若干位数字组成 
// 
// 👍 402 👎 0


package leetcode.editor.cn;

//打开转盘锁

import java.util.*;
import java.util.stream.Collectors;

public class P752_打开转盘锁 {
    public static void main(String[] args) {
        Solution solution = new P752_打开转盘锁().new Solution();
        String[] str = {"0201","0101","0102","1212","2002"};
        solution.openLock(str, "0202");
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int openLock(String[] deadends, String target) {
            Queue<String> queue = new LinkedList<>();
            Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toSet());
            Set<String> visiteSet = new HashSet<>();

            // 起始
            String source = "0000";
            queue.offer(source);
            visiteSet.add(source);
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String poll = queue.poll();
                   
                    // 判断死亡数字
                    if (deadSet.contains(poll)) {
                        continue;
                    }
                    // 判断是否到达目的
                    if (poll.equals(target)) {
                        return step;
                    }
                  
                    // 将poll的四个位置的8中情况全部列出
                    for (int j = 0; j < 4; j++) {
                        String plus = plusOne(poll, j);
                        String minus = minusOne(poll, j);
                        if (!visiteSet.contains(plus)){
                            queue.offer(plus);
                            visiteSet.add(plus);
                        }
                        if (!visiteSet.contains(minus)){
                            queue.offer(minus);
                            visiteSet.add(minus);
                        }
                    }
                }
                step++;
            }
            return -1;
        }

        // 一个轮向上转 pos轮子的位置
        String plusOne(String str, int pos) {
            char[] chars = str.toCharArray();
            if (chars[pos] == '9') {
                chars[pos] = '0';
            } else {
                chars[pos] += 1;
            }
            return new String(chars);
        }

        String minusOne(String str, int pos) {
            char[] chars = str.toCharArray();
            if (chars[pos] == '0') {
                chars[pos] = '9';
            } else {
                chars[pos] -= 1;
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}