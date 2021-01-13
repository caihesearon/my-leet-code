package 简单;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到
 * 1。如果 可以变为  1，那么这个数就是快乐数。 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 * 
 * 输入：19 输出：true 解释： 12 + 92 = 82 82 + 22 = 68 62 + 82 = 100 12 + 02 + 02 = 1
 * 
 * @author hecai
 * @date 2020年4月30日
 */
public class 快乐数 {
	
	public boolean isHappy1(int n) {
		Set<Integer> set = new HashSet<Integer>();
		while(n != 1 && !set.contains(n)) {
			set.add(n);
			n = deal(n);
		}
		return n == 1;
	}	
	

	

	int deal(int n) {
		int res = 0;
		while (n > 0) {
			int t = n % 10;
			res += t * t;
			n /= 10;
		}
		return res;
	}
	
	public boolean isHappy(int n) {

		int count = 0;
		while (count < 10000) {
			if (n == 1)
				return true;
			int deal = deal(n);
			if (deal == 1)
				return true;
			n = deal;
			count++;
		}
		return false;
	}

}
