//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。 
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 abaabaaba
// 👍 302 👎 0

package leetcode.editor.cn;

//Java：重复的子字符串
class P459重复的子字符串 {
    public static void main(String[] args) {
//        Solution solution = new P459重复的子字符串().new Solution();
//        System.out.println(solution.repeatedSubstringPattern("aabaaba"));
        String s1 = "abbcabc";
        String s2 = "abc";
        System.out.println(s1.indexOf(s2));



    }

    class Person{
        private  String name;
        public String get(){
            return this.name;
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            //i为结尾
            for (int i = 1; i <= s.length() / 2; i++) {
                if(s.length() % i == 0){
                    String s1 = s.substring(0, i);

                    boolean match = true;
                    for (int j = i; j <= s.length()-i; j += i) {
                        //截取 j-i 到 j之间的字符串
                        String str = s.substring(j, j + i);
                        if (!s1.equals(str)) {
                            match = false;
                        }
                    }
                    if (match) {
                        return true;
                    }
                }

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
