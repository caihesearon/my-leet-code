package 中等;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k。 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。 输入：nums = [1,1,2,1,1], k = 3 输出：2 解释：包含 3 个奇数的子数组是
 * [1,1,2,1] 和 [1,2,1,1] 。
 * 
 * @author hecai
 * @date 2020年4月21日
 */
public class 统计_优美子数组 {
	
	//使用滑动窗口
	/**
	 * 找到所有的奇数下标
	 * 从第一个奇数下标到k区间的奇数下标
	 * 分别从左右两边开始遍历偶数个数 并将两边找到的偶数个数相乘 
	 */
	public int numberOfSubarrays1(int[] nums, int k) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] % 2 != 0)
				list.add(i);
		}
		//取出k个奇数的下标
		int l = 0, r = k - 1;
		int count = 0;
		while(r < list.size()) {
			int ll = list.get(l), rr = list.get(r);
			int count1 = 1;
			while(ll > 0 && nums[ll-1] % 2 == 0) {
				count1++;
				ll--;
			}
			int count2 = 1;
			while(rr < nums.length-1 && nums[rr+1] %2 == 0) {
				count2++;
				rr++;
			}
			count += count1*count2;
			l++;
			r++;
		}
		return count;
	}

	public int numberOfSubarrays(int[] nums, int k) {
		//先保存所有的奇数下标
		//然后遍历所有的区间并查找在区间中的奇数下标的个数
		int ans = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] % 2 != 0)
				list.add(i);
		}
		for(int i = 0; i <= nums.length-k; i++) {
			for(int j = i+k; j <= nums.length; j++) {
				int count = 0;
				for(int z = i; z < j ; z++) {
					if(list.contains(z)) {
						count++;
					}
					if(count > k)
						break;
				}
				if(count == k) {
					ans++;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int numberOfSubarrays = new 统计_优美子数组().numberOfSubarrays1(new int[] {1,1,2,1,1}, 2);
		System.out.println(numberOfSubarrays);
	}

}
