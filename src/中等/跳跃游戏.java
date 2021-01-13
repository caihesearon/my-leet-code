package 中等;

/**
 *给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。

输入: [2,3,1,1,4]
输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * @author hecai
 * @date 2020年4月17日
 */
public class 跳跃游戏 {

	
	public boolean canJump(int[] nums) {
		//定义最远到达的位置
		int remoteIndex = 0;
		//从前往后遍历计算能到达的最远距离
		for(int i = 0; i < nums.length; i++) {
			if(i > remoteIndex)
				return false;
			remoteIndex = Math.max(remoteIndex, i + nums[i]);
		}
		return true;
	}
	
	

}
