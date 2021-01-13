package 困难;

/**
 * （这是一个 交互式问题 ） 给你一个
 * 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * 如果不存在这样的下标 index，就请返回 -1。 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件： 首先，A.length >= 3
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得： A[0] < A[1] < ... A[i-1] < A[i] A[i] >
 * A[i+1] > ... > A[A.length - 1] 
 * 
 * 输入：array = [1,2,3,4,5,3,1], target = 3 输出：2
 * 解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。
 * @author hecai
 * @date 2020年4月29日
 */
public class 山脉数组中查找目标值 {
	
	public int findInMountainArray(int target, MountainArray mountainArr) {
		if(mountainArr.length() < 3)
			return -1;
		return deal(0, mountainArr.length()-1, target, mountainArr);
	}
	
	int deal(int left, int right, int target, MountainArray mountainArr) {
		int r = right,l = left;
		//找到最高的下标
		
		while(l < r) {
			int mid = (r + l) / 2;
			if(mountainArr.get(mid) < mountainArr.get(mid+1))
				l = mid+1;
			else
				r = mid;
//			if(mountainArr.get(mid) >= mountainArr.get(mid-1) && mountainArr.get(mid) >= mountainArr.get(mid+1)) {
//				break;
//			}
//			//左边的大于中间的 向左边判断
//			if(mid > 0 && mountainArr.get(mid) < mountainArr.get(mid-1)) {
//				r = mid;			
//			}else {
//				l = mid;
//			}
//			mid = (r + l) / 2;
			
		}
		//最高的下标为mid
		//然后对两边进行2分查找
		//首先对左边进行 0 - mid
		int lmid = l, rmid = l;
		
		while(lmid >= left) {
			int mmid = (lmid + left) / 2;
			if(mountainArr.get(mmid) == target)
				return mmid;
			else if(mountainArr.get(mmid) > target) {
				lmid = mmid - 1;
			}else {
				left = mmid + 1;
			}			
		}
		
		while(right >=  rmid) {
			int mmid = ( rmid + right) / 2;
			if(mountainArr.get(mmid) == target)
				return mmid;
			else if(mountainArr.get(mmid) > target) {
				rmid = mmid + 1;
				  // 5 4 3 2 1    2    
			}else {
				right = mmid - 1;
			}
		}
		return -1;
		
	}
	

}

interface MountainArray {
	public int get(int index);
	public int length();
}