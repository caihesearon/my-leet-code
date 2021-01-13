package 中等;

import java.util.Arrays;


/**
*给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，
*使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target 
*（最接近表示两者之差的绝对值最小）。
如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。
请注意，答案不一定是 arr 中的数字。
示例 1：
输入：arr = [4,9,3], target = 10
输出：3
解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
* @author hecai
* @date 2020年6月14日
*/
public class 转变数组后最接近目标值的数组和 {
	//使用数状数组
	static int[] C = new int[10010];
	
	static int lowbit(int x) {
		return x & (-x);
	}
	static void add(int index, int val) {
		while(index < C.length) {
			C[index] += val;
			index += lowbit(index);
		}
	}
	static int sum(int index) {
		int res = 0;
		while(index > 0) {
			res += C[index];
			index -= lowbit(index);
		}
		return res;
	}
	
	static int search(int[] arr, int val, int l, int r) {
		if(l > r) {
			if(l < arr.length && arr[l] > val) return l;
			return r;
		}
		int mid = (r + l)/ 2;
		if(arr[mid] == val) 
			return mid;
		else if(arr[mid] > val)
			return search(arr, val, l, mid-1);
		return search(arr, val, mid+ 1, r);
	}
	
	public static int findBestValue1(int[] arr, int target) {
		int value = Integer.MAX_VALUE;
		int distance = Integer.MAX_VALUE;
		//将arr数组排序
		Arrays.sort(arr);
		//给树状数组赋值
		for(int i = 0; i < arr.length; i++) {
			add(i+1, arr[i]);
		}
		for(int i = 0; i <= arr[arr.length-1]; i++) {
			int val = i;
			//找到第一个大于val的下标
			int searchIndex = search(arr, val, 0, arr.length-1);
			//计算出searchIndex前面的值 因为树状数组是从下标为1开始的所以searchindex不需要减一
			int sum = sum(searchIndex);
			int len = arr.length - searchIndex;
			int tempVal = sum + (len * val);
			//算差值
			int dis = Math.abs(target - tempVal);
			//比差值大小
			if(distance > dis) {
				distance = dis;
				value = val;
			}
		}
		return value;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11};
		int binarySearch = Arrays.binarySearch(arr, 2);
		System.out.println(binarySearch);
		
		
		//System.out.println(findBestValue1(new int[]{2,3,5}, 10));
		//System.out.println(search(new int[]{1,3,5,7,9,10}, 11, 0, 5));
//		int sum = sum(3);
//		System.out.println(sum);
	}
	
	
	
	
	public static int findBestValue(int[] arr, int target) {
		int value = Integer.MAX_VALUE;
		int distance = Integer.MAX_VALUE;
		//将arr数组排序
		Arrays.sort(arr);
		//获取字符串
		String str = Arrays.toString(arr);
		str = str.replace('[', ' ').replace(']', ' ').replace(',', ' ').replaceAll(" ", "");
		for(int i = 0; i < arr.length; i++) {
			//给树状数组赋值
			add(i+1, arr[i]);
		}
		int index = 0;
		//循环遍历每一种情况
		for(int i = arr[0]-1; i <= arr[arr.length-1]; i++) {
			//i为value 当i为value时 找到第一个比i大的下标
			//在str中没有找到i这个值
			int tempIndex = str.indexOf(Integer.toString(i));
			int len = -1;
			if(tempIndex == -1) {
				//去index中判断
				while(index < arr.length && arr[index] < i) {
					index++;
				}
				//直到找到arr中第一个大于i的下标 计算
				len = arr.length - index;
				
			}else {
				//在str中有i这个值
				//先改变index的值
				index = tempIndex;
				len = arr.length - index - 1;
			}
			//计算数组和
			int tempVal = sum(index+1) + (len)*i;
			//System.out.println(tempVal);
			int dis = Math.abs(tempVal-target);
			if(dis < distance) {
				distance = dis;
				value = i;
			}
		}
		return value;
	}
}
