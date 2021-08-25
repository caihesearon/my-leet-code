package DP;

/**
 * @author caihe
 * @date 2021/8/24 15:20
 */
public class 递归_斐波那契 {

    public static void main(String[] args) {
        System.out.println(fun(4));
    }
    
    private static int fun(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fun(n - 1) + fun(n - 2);
    }
    
}
