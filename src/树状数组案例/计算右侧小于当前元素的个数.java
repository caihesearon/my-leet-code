package 树状数组案例;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * ----------------xxxxxxxxxxxxxxxxxxxxxxxx没有通过
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。 数组 counts 有该性质： counts[i] 的值是  nums[i]
 * 右侧小于 nums[i] 的元素的数量。 输入: [5,2,6,1] 输出: [2,1,1,0] 解释: 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1). 6 的右侧有 1 个更小的元素 (1). 1 的右侧有 0 个更小的元素.
 * 
 * @author hecai
 * @date 2020年4月15日 思路： 计算当前元素右侧所有比自己小的个数，和小朋友排队异曲同工
 *       使用树状数组，从输入数组的后面往前进行对树状数组的操作， 每次判断小于的个数即可
 */
public class 计算右侧小于当前元素的个数 {
	public static void main(String[] args) {
		System.out.println(countSmaller(new int[] {5,2,6,1}));
	}
	
	static int[] C = new int[10000010];
	static public List<Integer> countSmaller(int[] nums) {
		
		List<Integer> list = new LinkedList<Integer>();
		//从后往前
		for(int i = nums.length-1; i >= 0; i--) {
			add(nums[i]+1, 1);
			//判断比nums[i]+1小的个数
			int sum = sum(nums[i]);
			list.add(sum);
		}
		Collections.reverse(list);
		return list;
	}
	
	static int sum(int index) {
		int res = 0;
		while(index > 0) {
			res += C[index];
			index -= lowbit(index);
		}
		return res;
	}
	
	static void add(int index, int val) {
		while(index < C.length) {
			C[index] += val;
			index += lowbit(index);
		}
	}
	static int lowbit(int index) {
		return index & (-index);
	}
}
