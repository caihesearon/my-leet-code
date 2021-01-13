package 中等;
/**
*
* @author hecai
* @date 2020年4月23日
*/
public class 面试题08硬币 {

	public int waysToChange(int n) {
		int ans = 0;
		int mod = 1000000007;
		for(int i = 0; i*25 <= n; i++) {
			int r = n - i*25;
			int a = r / 10;
			int b = r % 10 / 5;
			ans = (int) ((ans +(long)(a + 1)*(a+b+1)%mod)%mod);
		}
		return ans;
    }
	
}
