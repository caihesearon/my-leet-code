package 中等;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * @author hecai
 * @date 2020年5月2日
 */
public class 无重复字符的最长子串_2 {
	
	public static void main(String[] args) {
		int max = lengthOfLongestSubstring("");
		System.out.println(max);
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s.length() == 0) {
			return 0;
		}
		Queue<Character> queue = new LinkedList<Character>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			if(queue.contains(s.charAt(i))) {
				//找到s.charAt(i)存在的位置
				while(queue.poll() != s.charAt(i)) {
					
				}				
			}
			queue.add(s.charAt(i));
			max = Math.max(max, queue.size());
		}
		return max;
	}
}
