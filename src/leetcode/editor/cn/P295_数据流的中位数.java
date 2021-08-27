//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// 👍 471 👎 0


package leetcode.editor.cn;

//数据流的中位数

import java.util.*;

public class P295_数据流的中位数 {
    public static void main(String[] args) {
        MedianFinder solution = new P295_数据流的中位数().new MedianFinder();
        solution.addNum(6);
        System.out.println(solution.findMedian());
        solution.addNum(10);
        System.out.println(solution.findMedian());
        solution.addNum(2);
        System.out.println(solution.findMedian());
        solution.addNum(1);
        solution.addNum(6);

        System.out.println(solution.findMedian());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {

        private List<Integer> lists;

        private Queue<Integer> queueMin;
        private Queue<Integer> queueMax;

        public MedianFinder() {
            // 小根堆 头节点值最小 用来保存数组后半段
            queueMin = new PriorityQueue<>();
            // 大根堆 头节点值最大 用来保存数组前半段
            queueMax = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            // 如果大根堆为空 或 新加入的数字小于等于大根堆的头结点 就加入大根堆
            if (queueMax.isEmpty() || queueMax.peek() >= num) {
                queueMax.offer(num);
                if ( queueMin.size() + 1 < queueMax.size()) {
                    queueMin.offer(queueMax.poll());
                }
            } else {
                queueMin.offer(num);
                if (queueMin.size() > queueMax.size()) {
                    queueMax.offer(queueMin.poll());
                }
            }
        }

        public double findMedian() {
            if (queueMax.size() == queueMin.size()) {
                return (queueMax.peek() + queueMin.peek()) / 2.0;
            }
            return queueMax.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)


}