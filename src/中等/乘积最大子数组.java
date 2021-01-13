package 中等;
/**
*给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
示例 1:
输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:
输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
* @author hecai
* @date 2020年5月18日
*/
public class 乘积最大子数组 {
	public static void main(String[] args) {
		maxProduct(new int[]{-2,0,-1});
	}
	
    public static int maxProduct(int[] nums) {
    	if(nums.length == 0)
    		return 0;    	
    	int res = Integer.MIN_VALUE;
    	for(int i = 0; i < nums.length; i++) {
            int max = 1;
    		for(int j = i; j < nums.length; j++) {
    			max *= nums[j];
    			res = Math.max(res, max);
    		}
    	}
    	return res;
    }

}
