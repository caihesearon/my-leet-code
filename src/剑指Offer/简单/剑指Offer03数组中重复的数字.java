package 剑指Offer.简单;

import java.util.HashSet;
import java.util.Set;

/**
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 *
 * @author hecai
 * @date 2020年7月27日
 */
public class 剑指Offer03数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        //遍历数组
        for (int num :
                nums) {
            //如果数字num不在set中就添加到set   如果在set中就直接返回
            if(!set.contains(num)){
                set.add(num);
            }else{
                return num;
            }
        }
        return 0;
    }
}
