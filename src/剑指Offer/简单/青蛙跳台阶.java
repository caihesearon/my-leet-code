package 剑指Offer.简单;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author hecai
 * @date 2020/11/24
 */
public class 青蛙跳台阶 extends Thread {
    public static void main(String[] args) {
//        double a = 1.1111f;
//        double b = 1.11f;
//        System.out.println(a == b);
//        System.out.println(2.00-1.10);
//        System.out.println(2.00f-1.10f);

        System.out.println(jump(7));
    }

    /**
     * jump 1   1
     *      2   2
     *      3   4
     *
     */
    public static int jump(int n){
        if (n < 3){
            return n;
        }
        return 2 * jump(n - 1);
    }
}
