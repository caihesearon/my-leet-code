package 简单;
/**
*假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。
示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
* @author hecai
* @date 2020年6月13日
* 思路：
* 	递归
*/
public class 爬楼梯 {
	
	
	/**
	 * 1 2 3 4 5
	 * 1 2 3 5 8
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if(n < 3) {
			return n;
		}
		int a = 1;	
		int b = 2;
		int c = a + b;		
		for(int i = 2; i < n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
    }

}
