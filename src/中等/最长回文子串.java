package 中等;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 输入: "babad" 输出: "bab" 注意: "aba" 也是一个有效答案。
 * 
 * @author hecai
 * @date 2020年4月18日 思路： 1、暴力破解：遍历截取所有可能的长度，判断是否为回文 2、中心扩展： 从第 1 到 倒数第二个 之间
 *       每一个和连续的两个元素为中心 向首尾两端开始扩展并判断
 */
public class 最长回文子串 {
	
	
	public static String longestPalindrome1(String s) {
		/**
		 * 中心查找法：
		 * 	奇数从下标为1是中心开始len-1结束，偶数下标从1和2开始len-2和len-1结束
		 * 注意：
		 * 	偶数进行判断的时候需要提前判断是否越界
		 */
		String str = "";
		for(int i = 0; i <= s.length()-1; i++) {
			//奇数
			String str1 = deal(i,i,s);
			//偶数
			String str2 = deal(i, i+1,s);
			//判断长度
			if(str1.length() > str.length()) 
				str = str1;
			if(str2.length() > str.length())
				str = str2;
		}
		return str;
	}
	public static String deal(int x, int y, String s) {
		if(x < 0 || y >= s.length())
			return "";
		if(x != y && s.charAt(x) != s.charAt(y)) {
			return "";
		}
		while(x >= 0 && y < s.length()) {
			if(s.charAt(x)!= s.charAt(y))
				break;
			x--;
			y++;
		}
		//截取x+1到y-1之间的
		return s.substring(x+1, y);
	}
	
	
	
	
	
	

	public static String longestPalindrome(String s) {
		if(s == null || s.length()==0)
			return "";
		//i为中心  i 和 i-1 为中心
		int len = Integer.MIN_VALUE;
		int ll = 0,rr= 0;
		//最后一个不可取 因为要考虑中心为两个的情况
		for(int i = 0; i < s.length()-1; i++) {
			int[] deal = deal(s, i,i);
			//计算长度大小
			int len1 = deal[1] - deal[0] + 1;
			int[] deal2 = deal(s, i, i+1);
			int len2 = deal2[1] - deal2[0] + 1;
			if(len1 > len) {
				ll = deal[0];				
				rr = deal[1];
				len = len1;
			}
			if(len2 > len) {
				ll = deal2[0];
				rr = deal2[1];
				len = len2;
			}
		}
		
		return s.substring(ll, rr+1);
	}
	
	
	static int[] deal(String s, int l, int r) {
		if(s.charAt(l) != s.charAt(r)) {
			return new int[] {0,0};
		}
		while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;
			r++;
		}
		return new int[] {++l,--r};
	}
	public static void main(String[] args) {
//		longestPalindrome("cbbd");
//		int t = new int[4].length;
//		a a = new a();
//		b b = new b();
//		c c = new c();
//		if(b  instanceof a) {
//			
//		}
		
		longestPalindrome1("a");
	}
	
}
class a{
	
}
class b extends a{
	
}
class c extends a{
	
}