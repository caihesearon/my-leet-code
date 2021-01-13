package 简单;

import org.omg.CORBA.INTERNAL;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 示例: 输入:
 * [-2,1,-3,4,-1,2,1,-5,4], 输出: 6 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 
 * @author hecai
 * @date 2020年5月3日
 */
public class 最大子序和 {

	//暴力破解
	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			int ans = 0;
			for(int j = i; j < nums.length; j++ ) {
				ans += nums[j];
				max = Math.max(max, ans);
			}
		}
		return max;
	}
	
	//贪心
	/**
	 * 用一个变量保存之前的结果 并 判断小于0时需要要重置为0
	 */
	public int maxSubArray1(int[] nums) {
		int max = Integer.MIN_VALUE;
		int preVal = 0;
		for(int i = 0; i < nums.length; i++) {
			if(preVal < 0)
				preVal = 0;
			preVal += nums[i];
			max = Math.max(preVal, max);
		}
		return max;
	}

}
