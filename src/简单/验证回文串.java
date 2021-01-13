package 简单;
/**
*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。
示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:
输入: "race a car"
输出: false
* @author hecai
* @date 2020年6月19日
*/
public class 验证回文串 {
	
	public static boolean isPalindrome(String s) {
		
		//排除字符串中所有不是数字和字母的元素
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))) {
				sb.append(s.charAt(i));
			}
		}
		StringBuilder left; //= ;
		StringBuilder right; //= new StringBuilder();
		if(sb.length() % 2 == 0) {
			left = new StringBuilder(sb.substring(0, sb.length()/2).toLowerCase());
			right = new StringBuilder(sb.substring(sb.length()/2).toLowerCase());
		}else {// 0 1 2 3 4
			left = new StringBuilder(sb.substring(0, sb.length()/2+1).toLowerCase());
			right = new StringBuilder(sb.substring(sb.length()/2).toLowerCase());
		}
		if(left.reverse().toString().toLowerCase().equals(right.toString().toLowerCase())) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

}
