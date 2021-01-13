package 中等;

import java.util.Arrays;
import java.util.List;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。 ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4
 * 
 * @author hecai
 * @date 2020年4月27日
 */
public class 搜索旋转排序数组 {

	//二分查找
	public int search(int[] nums, int target) {
		return searchFun(nums, 0, nums.length-1, target);
	}
	int searchFun(int[] nums, int left, int right, int target) {
		if(right < left)
			return -1;
		int leftValue = nums[left];
		int midValue = nums[(left+right)/2];
		int rightValue = nums[right];
		if(leftValue == target)
			return left;
		if(rightValue == target)
			return right;
		if(midValue == target)
			return (left+right)/2;
		//如果在左边
		if(midValue > leftValue) {
			if(target > nums[left] && target < nums[(left+right)/2])
				return searchFun(nums, left+1, (left+right)/2-1, target);
			else
				return searchFun(nums, (left+right)/2+1, right-1, target);
		}else {
			if(target > nums[(left+right)/2] && target < nums[right])
				return searchFun(nums,(left+right)/2+1, right-1, target);
			else
				return searchFun(nums, left+1, (left + right)/2-1, target);
		}
	}
	

}
