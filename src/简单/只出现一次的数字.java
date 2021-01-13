package 简单;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 说明： 你的算法应该具有线性时间复杂度。
 * 你可以不使用额外空间来实现吗？ 示例 1: 输入: [2,2,1] 输出: 1 示例 2: 输入: [4,1,2,1,2] 输出: 4
 * 
 * @author hecai
 * @date 2020年5月14日
 */
public class 只出现一次的数字 {
	/**
	 * 异或运算：相同为0 不同为1 并且满足交换律 不在乎顺序
	 * 思路：把所有有两个的数字使用异或运算消除掉 剩下的就是只有一个的元素
	 * @param nums
	 * @return
	 */
	public int singleNumber(int[] nums) {
		for(int i = 1; i < nums.length; i++) {
			nums[0] ^= nums[i];
		}
		return nums[0];
	}
	
	//使用hashMap
	public int singleNumber1(int[] nums) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], 2);
			}else {
				map.put(nums[i], 1);
			}
		}
		for (Integer i : map.keySet()) {
			if(map.get(i) == 1) {
				return i;
			}
		}
		return 0;
	}
	
	//使用排序
	public int singleNumber2(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i] != nums[i+1]) {
				return nums[i];
			}else {
				i++;
			}
		}
		return nums[nums.length-1];
	}
}
