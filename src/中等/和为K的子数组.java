package 中等;

import java.util.HashMap;
import java.util.Map;

/**
*给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。

* @author hecai
* @date 2020年5月15日
*/
public class 和为K的子数组 {
	public static void main(String[] args) {
		new 和为K的子数组().subarraySum(new int[]{1,2,3}, 3);
		
	}
	
	//使用前缀和	
	public int subarraySum1(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//保存第一个下标的前缀和为0
		map.put(0, 1);
		int count = 0;
		int pre = 0;
		for(int i = 0; i < nums.length; i++) {
			pre += nums[i];
			//查找是否存在
			if(map.containsKey(pre - k)) {
				count += map.get(pre - k);
			}
			//记录前缀和pre出现的个数
			map.put(pre, map.getOrDefault(pre, 0) + 1);			
		}//0 1 1 2 3 4 6 -1   k = 3		
		 //1 1   1  
		return count;
    }
	
	public int subarraySum(int[] nums, int k) {
		int count = 0;
		for(int i = 0; i < nums.length; i ++) {
			int num = 0;			
			for(int j = i; j < nums.length; j++) {
				num += nums[j];
				if(num == k) {
					count++;
					break;
				}			
			}
		}
		return count;
    }

}
