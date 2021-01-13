package 中等;
/**
*实现 pow(x, n) ，即计算 x 的 n 次幂函数。
*示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
* @author hecai
* @date 2020年5月11日
*/
public class Powxn_快速幂 {
	
	public static void main(String[] args) {
		new Powxn_快速幂().myPow(0, 0);
	}
	public double myPow(double x, int n) {
		double pow = Math.pow(x,  n);
		return pow;
    }
	
	//使用快速幂进行解决
	public double myPow1(double x, int n) {
		//防止为负数变正数时超范围
		long N = n;
	    return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
	}
	double quickMul(double a, long b) {
		double ans = 1.0;
		while(b > 0) {
			if(b % 2 != 0) {
				ans *= a;
			}
			a *= a;
			b /= 2;
		}
		return ans;
	}

}
