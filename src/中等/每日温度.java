package 中等;

import java.util.Stack;

/**
*根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

* @author hecai
* @date 2020年6月11日
* 思路：
* 	从当前位置往后找，找到第一个比自己大的数字，并计算出数组中下标的距离
*/
public class 每日温度 {
	
	
	/**
	 * 使用栈
	 * 将元素的下标放入栈中，每次新加入元素的时候从栈顶开始判断是否
	 * 有比新元素小的元素，有就弹出栈顶并计算下标差值
	 * @param T
	 * @return
	 */
	 public int[] dailyTemperatures1(int[] T) {
		 //定义一个保存结果的数组
		 int[] res = new int[T.length];
		 //定义栈
		 Stack<Integer> stack = new Stack<Integer>();
		 //遍历T数组
		 for(int i = 0; i < T.length; i++) {
			 //循环判断 栈是否为空 并且 栈顶的元素是否小于新加入的元素
			 while(!stack.isEmpty() && T[stack.peek()] < T[i]) {
				 //计算 新加入元素的下标  和   栈顶元素的下标    的差值
				 res[stack.peek()] = i - stack.pop();
			 }
			 //将新加入的元素压入栈中
			 stack.push(i);
		 }
		 return res;
	 }
	
	
	/**
	 * 暴力破解
	 * @param T
	 * @return
	 */
	 public int[] dailyTemperatures(int[] T) {
		 for(int i = 0; i < T.length-1; i++) {
			 int step = 0;
			 boolean flag = true;
			 for(int j = i+1; j < T.length; j++) {
				 step ++;
				 if(T[i] < T[j]) {
					 T[i] = step;
					 flag = false;
					 break;
				 }
			 }
			 if(flag) {
				 T[i] = 0;
			 }
			 
		 }
		 T[T.length-1] = 0;
		 return T;
	 }

}
