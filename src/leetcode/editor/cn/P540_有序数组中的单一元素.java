//给你一个仅由整数组成的有序数组，其中每个元素都会出现两次，唯有一个数只会出现一次。 
//
// 请你找出并返回只出现一次的那个数。 
//
// 你设计的解决方案必须满足 O(log n) 时间复杂度和 O(1) 空间复杂度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,2,3,3,4,4,8,8]
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: nums =  [3,3,7,7,10,11,11]
//输出: 10
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
// 👍 347 👎 0


package leetcode.editor.cn;

//有序数组中的单一元素

import leetcode.editor.cn.classification.异或;

public class P540_有序数组中的单一元素 implements 异或 {
    public static void main(String[] args) {
        Solution solution = new P540_有序数组中的单一元素().new Solution();
        int i = solution.singleNonDuplicate(new int[]{3, 3, 4, 5, 5});
        System.out.println(i);

        int a = 1;
        int b = 2;
        int c = 3;
        System.out.println(a ^ 1);
        System.out.println(b ^ 1);
        System.out.println(c ^ 1);

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNonDuplicate(int[] nums) {
            return binarySingleNonDuplicate(nums);
        }

        // 普通遍历方式
        private int simpleSingleNonDuplicate(int[] nums) {
            for (int i = 0; i < nums.length - 1; i += 2) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            }
            return nums[nums.length - 1];
        }

        /**
         * 二分法
         * 目标数的左边 偶数位和偶数位+1的值一致
         * 目标数的右边 奇数位和奇数位+1的值一致
         * 与1异或特点
         * 偶数与1进行异或操作，结果会加1
         * 奇数与1进行异或曹组，结果会减1
         *
         * @param nums
         * @return
         */
        private int binarySingleNonDuplicate(int[] nums) {
            int lIndex = 0;
            int rIndex = nums.length - 1;
            while (lIndex < rIndex) {
                int midIndex = (rIndex + lIndex) / 2;
                // 异或说明如描述
                if (nums[midIndex] == nums[midIndex ^ 1]) {
                    lIndex = midIndex + 1;
                } else {
                    rIndex = midIndex;
                }
            }
            return nums[lIndex];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}