package 简单;
/**
*编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
示例 1:
输入: ["flower","flow","flight"]
输出: "fl"
示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
* @author hecai
* @date 2020年6月15日
*/
public class 最长公共前缀 {
	public static String longestCommonPrefix(String[] strs) {
		String str = "";
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < strs.length; i ++) {
			if(min > strs[i].length()) {
				min = strs[i].length();
				str = strs[i];
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++) {
			//取出下标为i的字符
			char c = str.charAt(i);
			boolean flag = true;
			for(int j = 0; j < strs.length; j ++) {
				char cc = strs[j].charAt(i);
				if(c != cc) {
					flag = false;
					break;
				}
			}
			if(!flag) {
				return sb.toString();
			}
			sb.append(c);
		}
		
		return sb.toString();
   	}
	
	public static void main(String[] args) {
		System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
	}

}
