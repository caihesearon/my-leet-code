package 中等;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。 在坐标内画 n 条垂直线，垂直线
 * i 的两个端点分别为 (i, ai) 和 (i, 0)。 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 输入：[1,8,6,2,5,4,8,3,7] 输出：49
 * 
 * @author hecai
 * @date 2020年4月18日
 * 
 */
public class 盛最多水的容器 {
	/**
	 * 双指针法：
	 * 	有左右两个指针，分别指向数组的首尾
	 * 	并计算容量比较大小，每当一方较小的时候就移动该方的指针，直到他的下一步为对方就停止
	 * @param height
	 * @return
	 */
	public int maxArea1(int[] height) {
		int ll = 0, rr = height.length-1;
		int max = Integer.MIN_VALUE;
		while(ll < rr) {
			//计算容量大小
			int lval = height[ll];
			int rval = height[rr];
			max = Math.max(max, (rr-ll)*Math.min(lval, rval));//0 1 2 3
			if(lval < rval) {
				ll++;
			}else {
				rr--;
			}
		}
		return max;
	}
	

	//for循环暴力破解法
	public int maxArea(int[] height) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < height.length-1; i++) {
			for(int j = i + 1; j < height.length; j++) {
				//计算容量 j - i  * min(height[i],height[j])
				int t = (j-  i) * Math.min(height[i], height[j]);
				max = max = Math.max(t, max);
			}
		}
		return max;
	}

}
