package 简单;
/**
*给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

示例 1:

输入: "aba"
输出: True
示例 2:

输入: "abca"
输出: True
解释: 你可以删除c字符。
* @author hecai
* @date 2020年5月19日
*/
public class 验证回文字符串Ⅱ {
	public static void main(String[] args) {
		String s = "abcdef";
		System.out.println(s.subSequence(0, s.length()-1));
	}
	
	public boolean validPalindrome(String s) {
		int i = 0, j = s.length()-1;
		for(; i < j && s.charAt(i) == s.charAt(j); i++, j--);
		if(i >= j)
			return true;
    	return deal(s, i+1, j) || deal(s, i, j-1);
    }
	
	boolean deal(String s, int i, int j) {
		for(; i < j && s.charAt(i) == s.charAt(j); i++, j--);
		if(i >= j)
			return true;
		return false;
	}
	
	
//    public boolean validPalindrome(String s) {
//    	
//    	if(check(s)) {
//    		return true;
//    	}
//    	String str = "";
//    	for(int i = 0; i < s.length(); i++) {
//    		if(i == 0) {
//    			str = s.substring(1);
//    		}
//    		else if(i == s.length() - 1) {
//    			str = s.substring(0, s.length()-1);
//    		}else {
//    			String s1 = s.substring(0, i);
//    			String s2 = s.substring(i+1);
//    			str = s1 + s2;
//    		}
//    		if(check(str)) {
//    			return true;
//    		}
//    	}
//    	return false;
//    }
//    
//    static boolean check(String s) {
//    	String s1 = "",s2="";
//    	//长度为偶数
//    	if(s.length() % 2 == 0) {
//    		s1 = s.substring(0, s.length()/2);
//    		s2 = s.substring(s.length()/2);
//    	}else {
//    		s1 = s.substring(0,s.length()/2);
//    		s2 = s.substring(s.length()/2+1);
//    	}
//    	StringBuilder sb = new StringBuilder(s2);
//    	s2 = sb.reverse().toString();
//   		return s2.equals(s1);
//    }
}
