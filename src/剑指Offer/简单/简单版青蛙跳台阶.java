package 剑指Offer.简单;

/**
 * @author hecai
 * @date 2020/12/11
 */
public class 简单版青蛙跳台阶 {


    public static void main(String[] args) {
        System.out.println(numWaysa(7));
    }

    public static int numWaysa(int n) {
        if (n == 0){
            return 1;
        }
        if(n <= 2){
            return n;
        }
        //a = f(n-2); b = f(n - 1); c = f(n)
        int a = 1, b = 2, c = 0;
        for (int i = 2; i < n; i++){
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }







    public static int numWays(int n) {
        //没有台阶，直接在上面，一种
        if (n == 0) {
            return 1;
        }
        //一个或两个台阶
        if (n <= 2) {
            return n;
        }
        //a保存f(n-2),b保存f(n-1),c保存f(n)
        int a = 1, b = 2, c = 0;
        //i：第i个台阶
        for (int i = 3; i <= n; ++i) {
            //第i个台阶跳法：a:i-2个台阶跳发，b:i-1个台阶跳发
            c = (a + b) % 1000000007;
            //a保存b
            a = b;
            //b保存c
            b = c;
        }
        return c;
    }


}
