package 中等;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给出一个区间的集合，请合并所有重叠的区间。
 *	输入: [[1,3],[2,6],[8,10],[15,18]]
	输出: [[1,6],[8,10],[15,18]]
	解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6]

 * @author hecai
 * @date 2020年4月16日
 */
public class 合并区间 {
	public int[][] merge(int[][] intervals) {
		int count = 0;
		for(int i = 0; i < intervals.length-1; i++) {
			for(int j = i + 1; j < intervals.length; j++) {
				if(intervals[i] != null && intervals[i][0] <= intervals[j][1] && intervals[j][0] <= intervals[i][1]) {
					//合并
					intervals[j][0] = Math.min(intervals[j][0], intervals[i][0]);
					intervals[j][1] = Math.max(intervals[j][1], intervals[i][1]);
					intervals[i] = null;
					count++;
					break;
				}
			}
		}
		int[][] res = new int[intervals.length-count][2];
		int index = 0;
		for(int[] tt: intervals) {
			if(tt != null)
				res[index++] = tt;
		}
		
		return res;
	}
	
	//分别将左边和右边用两个数组进行保存
	public int[][] merge1(int[][] intervals) {
		int[] ll = new int[intervals.length];
		int[] rr = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++) {
			ll[i] = intervals[i][0];
			rr[i] = intervals[i][1];
		}
		//分别从小到大进行排序
		Arrays.sort(ll);
		Arrays.sort(rr);//abcdb
		List<int[]> list = new ArrayList<int[]>();
		//如果左边的第二个大于右边的第一个就需要记录合并了
		for(int l = 0, r = 0; r < rr.length; r++) {
			//r == rr.lenth-1 是特判到达最后
			if(r == rr.length-1 || ll[r+1] > rr[r]) {
				list.add(new int[] {ll[l],rr[r]});
				l = r + 1;
			}
		}
		return list.toArray(new int[list.size()][]);
	}

	public static void main(String[] args) {
		new 合并区间().merge1(new int[][] {{1,3},{2,6},{8,10},{15,18}});
		
	}
	
}
