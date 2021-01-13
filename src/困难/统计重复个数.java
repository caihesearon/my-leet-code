package 困难;

import java.util.HashMap;
import java.util.Map;

/**
 * 由 n 个连接的字符串 s 组成字符串 S，记作 S = [s,n]。例如，["abc",3]=“abcabcabc”。 如果我们可以从
 * s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。 例如，根据定义，"abc" 可以从 “abdbec” 获得，但不能从
 * “acbbe” 获得。 现在给你两个非空字符串 s1 和 s2（每个最多 100 个字符长） 和两个整数 0 ≤ n1 ≤ 106 和 1 ≤ n2 ≤
 * 106。现在考虑字符串 S1 和 S2， 其中 S1=[s1,n1] 、S2=[s2,n2] 。 请你找出一个可以满足使[S2,M] 从
 * S1 获得的最大整数 M 。 输入： s1 ="acb",n1 = 4 s2 ="ab",n2 = 2 返回： 2
 * 
 * @author hecai
 * @date 2020年4月20日
 * 思路：
 * 	暴力破解：计算s2在S1中出现的次数 除以n2
 * 	优化：
 * 		保存每次s1和s2对比后s2的下标位置
 * 		然后进行对比是否存在相同的下标 计算循环
 */
public class 统计重复个数 {

	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		int ll1 = cs1.length;
		int ll2 = cs2.length;
		int count1 = 0, count2 = 0;
		Map<Integer,int[]> map = new HashMap<Integer,int[]>();
		//记录下标
		int index1 = 0, index2 = 0;
		//s1的次数
		while(count1 < n1) {
			for(int i = 0; i < ll1; i++) {
				if(cs1[i] == cs2[index2]) {
					//s2右划
					index2++;
					if(index2 == ll2) {
						index2 = 0;
						count2++;
					}
				}
			}
			count1++;
			//每次遍历完一个s1后 保存以s2的下标为k 已经遍历完的个数
			if(!map.containsKey(index2)) {
				map.put(index2, new int[] {count1, count2});
			}else {
				//查找循环
				int[] is = map.get(index2);
				//计算分别相差多少  一个循环的长度
				int len1 = count1 - is[0];
				int len2 = count2 - is[1];
				//计算循环的个数 S1长度减去count1得到剩下的长度 再除以一个循环的长度
				int count = (n1-count1)/len1;
				count2 += len2 * ((n1-count1)/len1);
				count1 += len1 * ((n1-count1)/len1);
			}
		}
		return count2 / n2;
	}
}
