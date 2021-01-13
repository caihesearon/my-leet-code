package 简单;
/**
*设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2
* @author hecai
* @date 2020年5月12日
*/

import java.util.Stack;

public class 最小栈 {
	
	 /** initialize your data structure here. */
	Stack<Integer> data;
	Stack<Integer> helper;
    public 最小栈() {
    	data = new Stack<Integer>();
    	helper = new Stack<Integer>();
    }
    
    public void push(int x) {
    	data.push(x);
    	if(helper.isEmpty() || x <= helper.peek()) {
    		helper.push(x);
    	}else {
    		helper.push(helper.peek());
    	}
    }
    
    public void pop() {
    	data.pop();
    	helper.pop();
    }
    
    public int top() {
    	//helper.pop();
    	return data.peek();
    }
    
    public int getMin() {
    	return helper.peek();
    }

}
