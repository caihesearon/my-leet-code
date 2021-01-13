package 简单;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那
* 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
* @author hecai
* @date 2020年4月15日
*/
public class 两数之和 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new 两数之和().twoSum(new int[] {3,2,4}, 6)));
	}
	
	public int[] twoSum(int[] nums, int target) {
		for(int i = 0; i < nums.length-1; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				if(target - nums[i] == nums[j]) {
					return new int[] {i,j};
				}
			}
		}
		return null;
    }
	
}
