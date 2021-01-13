package 树状数组案例;

import java.util.Arrays;
import java.util.Scanner;

/**
*
* @author hecai
* @date 2020年4月14日
* n 个小朋友站成一排。现在要把他们按身高从低到高的顺序排列，但是每次只能交换位置相邻的两个小朋友。
每个小朋友都有一个不高兴的程度。开始的时候，所有小朋友的不高兴程度都是0。
如果某个小朋友第一次被要求交换，则他的不高兴程度增加1，如果第二次要求他交换，则他的不高兴程度增加2（即不高兴程度为3），依次类推。
当要求某个小朋友第k次交换时，他的不高兴程度增加k。
请问，要让所有小朋友按从低到高排队，他们的不高兴程度之和最小是多少。
如果有两个小朋友身高一样，则他们谁站在谁前面是没有关系的。
输入：
3
3 2 1
输出：9
*/
public class 小朋友排队 {
	/*
	 * 思路：
	 * 	需要从小到大排序，且两两相邻交换：冒泡超时：
	 * 	实质上是查找每个小朋友的前面有几个比他高的，后面有几个比他矮的
	 */
	//树状数组  从下标1开始  
	static int[] C = new int[100010];
	//正反逆序对 保存小朋友交换的次数
	static int[] B = new int[100010];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//保存小朋友的身高
		int[] arr = new int[n+2];
		for(int i = 0; i < n; i++) {
			//输入小朋友的身高，身高对应C树状数组中的下标
			arr[i] =  sc.nextInt();
			//根据下标对树状数组进行标记
			add(arr[i]+1, 1);
			//计算所有比t+1高的小朋友个数
			//首先使用sum(arr[i])计算出比t+1矮的人数 i-sum(arr[i])是计算第i个人前面比高的人数
			B[i] = i - sum(arr[i]);//通过for循环的下标得知进去的次数 使用次数减去比t+1矮的人数减t+1的人数就是所有比t+1高的人数
			B[i] = B[i] - (sum(arr[i]+1) - sum(arr[i])) + 1;
		}
		System.out.println(Arrays.toString(Arrays.copyOfRange(B, 0, 20)));
		C = new int[100010];
		//从后往前 查找所有比当前小朋友矮的人数
		for(int i = n-1; i >= 0; i--) {
			add(arr[i]+1, 1);
			B[i] += sum(arr[i]);
		}
		System.out.println(Arrays.toString(Arrays.copyOfRange(B, 0, 20)));
		//sn = a1 * n + n*(n-1)*d/2 
		//sn = n+n*(n-1)/2
		long res = 0;
		for(int i = 0; i <= n; i++) {
			int t = B[i];
			res += t+(t*(t-1))/2;
		}
		System.out.println(res);
		
		
	}
	
	static int sum(int index) {
		int res = 0;
		while(index > 0) {
			res += C[index];
			index -= lowbit(index);
		}		
		return res;
	}
	
	static void add(int index, int k) {
		while(index < 100010) {
			C[index] += k;
			index += lowbit(index);
		}
	}
	
	static int lowbit(int x) {
		return x & (-x);
	}
	
}
