package 中等;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * 火车票有三种不同的销售方式： 一张为期一天的通行证售价为 costs[0] 美元； 一张为期七天的通行证售价为 costs[1] 美元；
 * 一张为期三十天的通行证售价为 costs[2] 美元。 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7
 * 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。 示例 1： 输入：days = [1,4,6,7,8,20], costs
 * = [2,7,15] 输出：11 解释： 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划： 在第 1 天，你花了 costs[0] = $2
 * 买了一张为期 1 天的通行证，它将在第 1 天生效。 在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4,
 * ..., 9 天生效。 在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。 你总共花了
 * $11，并完成了你计划的每一天旅行。 示例 2： 输入：days = [1,2,3,4,5,6,7,8,9,10,30,31], costs =
 * [2,7,15] 输出：17 解释： 例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划： 在第 1 天，你花了 costs[2] = $15
 * 买了一张为期 30 天的通行证，它将在第 1, 2, ..., 30 天生效。 在第 31 天，你花了 costs[0] = $2 买了一张为期 1
 * 天的通行证，它将在第 31 天生效。 你总共花了 $17，并完成了你计划的每一天旅行。
 * 
 * @author hecai
 * @date 2020年5月6日 提示： 1 <= days.length <= 365 1 <= days[i] <= 365 days 按顺序严格递增
 *       costs.length == 3 1 <= costs[i] <= 1000
 * 
 */
public class 最低票价 {
	
	
	public int mincostTickets1(int[] days, int[] costs) {
		Set<Integer> sets = new HashSet<Integer>();
		for (int i : days) {
			sets.add(i);
		}
		int minDay = days[0];
		int maxDay = days[days.length-1];
		int[] memo = new int[maxDay+31];
				
		for(int i = maxDay; i >= 0; i--) {
			if(set.contains(i)) {
				memo[i] = Math.min(Math.min(memo[i+1]+costs[0],memo[i+7]+costs[1]), memo[i+30]+costs[2]);
			}else {
				memo[i] = memo[i+1];
			}
		}
		
		return memo[1];
	}
	
	
	int[] costs;
	Set<Integer> set = new HashSet<Integer>();
	Integer[] memo = new Integer[366];
	public int mincostTickets(int[] days, int[] costs) {
		this.costs = costs;
		//将天数放入Set中进行保存
		for (int i : days) {
			set.add(i);
		}
		return deal(1);
	}
	
	int deal(int i) {
		if(i > 365)
			return 0;
		if(memo[i] != null)
			return memo[i];
		if(set.contains(i)) {
			memo[i] = Math.min(Math.min(deal(i+1)+costs[0], deal(i+7)+costs[1]), deal(i+30)+costs[2]);
		}else {
			memo[i] = deal(i+1);
		}
		return memo[i];
	}
}
