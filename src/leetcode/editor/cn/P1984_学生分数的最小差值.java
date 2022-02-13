////给你一个 下标从 0 开始 的整数数组 nums ，其中 nums[i] 表示第 i 名学生的分数。另给你一个整数 k 。 
////
//// 从数组中选出任意 k 名学生的分数，使这 k 个分数间 最高分 和 最低分 的 差值 达到 最小化 。 
////
//// 返回可能的 最小差值 。 
////
//// 
////
//// 示例 1： 
////
//// 输入：nums = [90], k = 1
////输出：0
////解释：选出 1 名学生的分数，仅有 1 种方法：
////- [90] 最高分和最低分之间的差值是 90 - 90 = 0
////可能的最小差值是 0
//// 
////
//// 示例 2： 
////
//// 输入：nums = [9,4,1,7], k = 2
////输出：2
////解释：选出 2 名学生的分数，有 6 种方法：
////- [9,4,1,7] 最高分和最低分之间的差值是 9 - 4 = 5
////- [9,4,1,7] 最高分和最低分之间的差值是 9 - 1 = 8
////- [9,4,1,7] 最高分和最低分之间的差值是 9 - 7 = 2
////- [9,4,1,7] 最高分和最低分之间的差值是 4 - 1 = 3
////- [9,4,1,7] 最高分和最低分之间的差值是 7 - 4 = 3
////- [9,4,1,7] 最高分和最低分之间的差值是 7 - 1 = 6
////可能的最小差值是 2 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= k <= nums.length <= 1000 
//// 0 <= nums[i] <= 10⁵ 
//// 
//// 👍 79 👎 0
//


package leetcode.editor.cn;

//学生分数的最小差值

import java.util.Arrays;


public class P1984_学生分数的最小差值 {
    public static void main(String[] args) {
        Solution solution = new P1984_学生分数的最小差值().new Solution();
        System.out.println(solution.minimumDifference(new int[]{87063, 61094, 44530, 21297, 95857, 93551, 9918}, 6));
        System.out.println(solution.minimumDifference(new int[]{9,4,1,7}, 2));
    }
    /**
     * 先排序
     * 后比较
     */
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDifference(int[] nums, int k) {
            if (k <= 1) {
                return 0;
            }
            int minResult = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i <= nums.length - k; i++) {
                minResult = Math.min(minResult, Math.abs(nums[i + k-1] - nums[i]));
            }
            return minResult;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)


}