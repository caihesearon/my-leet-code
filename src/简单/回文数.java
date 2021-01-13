package 简单;
/**
*判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
示例 1:
输入: 121
输出: true
示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
* @author hecai
* @date 2020年6月10日
*/
public class 回文数 {

	 public static boolean isPalindrome(int x) {
//		 String str = Integer.toString(x);
		 String str = String.valueOf(x);
		 int mid = str.length() / 2;
		 //判断长度是否为偶数
		 if(str.length()%2 == 0) {
			 return deal(mid-1, mid, str);
		 }else {
			 return deal(mid, mid, str);
		 }		 		
		 
		 //return false;
	 }
	 
	 public static boolean deal(int x, int y, String str) {
		 String substring = str.substring(0, x+1);
		 String substring2 = str.substring(y);
		 StringBuilder sb = new StringBuilder(substring2).reverse();
		 if(!sb.toString().equals(substring))
			 return false;
		 
		 return true;
	 }
	 
	 public static void main(String[] args) {
		 isPalindrome(11);
	}
	
}
