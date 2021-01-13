package 中等;

import java.util.HashSet;
import java.util.Set;

/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *输入: "abcabcbb"
	输出: 3 
	解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author hecai
 * @date 2020年4月16日
 * 	思路：暴力破解不可取
 * 	滑动窗口的概念：
 * 		使用两个变量保存左右的下标
 * 
 */
public class 无重复字符的最长子串 {

	public static void main(String[] args) {
		System.out.println(new 无重复字符的最长子串().lengthOfLongestSubstring(""));
	}
	
	public int lengthOfLongestSubstring(String s) {
		int l= 0 , r = 0, ans = 0;
		Set<Character> set = new HashSet<Character>();
		while(l < s.length() && r < s.length()) {
			if(!set.contains(s.charAt(r))) {
				set.add(s.charAt(r++));
				ans = Math.max(ans, r - l);
			}else {
				set.remove(s.charAt(l++));
			}
		}
		return ans;
	}

}
