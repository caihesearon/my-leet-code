package 中等;
/**
*给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
返回一对观光景点能取得的最高分。
示例：
输入：[8,1,5,2,6]
输出：11
解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
提示：
2 <= A.length <= 50000
1 <= A[i] <= 1000
* @author hecai
* @date 2020年6月17日
*/
public class 最佳观光组合 {
	//会记录左边的最大值并会更新
	public int maxScoreSightseeingPair1(int[] A) {
		int res = 0;
		int valL = A[0];
		for(int j = 1; j < A.length; j++) {
			res = Math.max(valL + A[j]-j, res);
			//维护左边的最大值
			valL = Math.max(valL, A[j]+j);
		}
		return res;
    }
	
	/**
	 * 思路：超时
	 * 	两个for循环：从左到右，依次判断并记录右边的最大值
	 * @param A
	 * @return
	 */
	public int maxScoreSightseeingPair(int[] A) {
		//i < j
		int maxVal = Integer.MIN_VALUE;
		for(int i  = 0; i < A.length-1; i++) {
			int maxR = Integer.MIN_VALUE;
			for(int j = i+1; j < A.length; j++) {
				//需要记录右边的最大值
				if(A[j] > maxR) {					
					maxR = A[j];
					int val = A[i]+A[j]+i-j;
					maxVal = Math.max(val, maxVal);
				}
			}
		}
		return maxVal;
    }
	
	public static void main(String[] args) {
		System.out.println(new 最佳观光组合().maxScoreSightseeingPair(new int[] {1,3,5}));
	}

}
