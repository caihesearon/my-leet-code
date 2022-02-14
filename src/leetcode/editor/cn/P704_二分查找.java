//给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否
//则返回 -1。 
//
// 
//示例 1: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 9
//输出: 4
//解释: 9 出现在 nums 中并且下标为 4
// 
//
// 示例 2: 
//
// 输入: nums = [-1,0,3,5,9,12], target = 2
//输出: -1
//解释: 2 不存在 nums 中因此返回 -1
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设 nums 中的所有元素是不重复的。 
// n 将在 [1, 10000]之间。 
// nums 的每个元素都将在 [-9999, 9999]之间。 
// 
// 👍 639 👎 0


package leetcode.editor.cn;

//二分查找

import leetcode.editor.cn.classification.二分查找;
import leetcode.editor.cn.level.简单;

public class P704_二分查找 implements 二分查找, 简单 {
    public static void main(String[] args) {
        Solution solution = new P704_二分查找().new Solution();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        private int binarySearch(int[] nums, int target, int left, int right) {
//            Arrays.binarySearch()
            if (left > right) {
                return -1;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                return binarySearch(nums, target, left, mid - 1);
            } else {
                return binarySearch(nums, target, mid + 1, right);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}