package DFS;

import java.util.Arrays;

/**
 * @author hecai
 * @date 2020/10/6
 */
public class SimpleDFS {

    static int[] arr = {1, 2, 3, 4};
    static int N = 0;
    public static void main(String[] args) {
        dfs(0);
        System.out.println(N);
    }

    static void dfs(int k) {
        if (k == arr.length) {
            System.out.println(Arrays.toString(arr));
            N++;
        } else {
            for (int i = k; i < arr.length; i++) {
                int t = arr[k];
                arr[k] = arr[i];
                arr[i] = t;
                dfs(k + 1);
                t = arr[k];
                arr[k] = arr[i];
                arr[i] = t;
            }
        }

    }

}
/**
4 3
0 10
1 0
2 20
3 30

 */
