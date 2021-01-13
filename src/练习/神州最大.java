package 练习;

/**
 * @author hecai
 * @date 2020/9/28
 */
public class 神州最大 {

    public static void main(String[] args) {
//        String[] arr = {"6", "-3", "-2", "7", "-15", "1", "2", "2"}; //8
        String[] arr = {"6", "-5","6"};
        System.out.println(findGreatestSumOfSubArray(arr));
    }

    /**
     * 求连续子数组的最大和
     *
     * @param array string字符串一维数组 数组
     * @return int整型
     */
    public static int findGreatestSumOfSubArray(String[] array) {
        int[] arr = new int[array.length];
        for(int i = 0 ; i < array.length; i++){
            arr[i] = Integer.parseInt(array[i]);
        }
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            int leiji = 0;
            for(int j = i; j < arr.length; j++){
                leiji += arr[j];
                if(leiji < arr[j]){
                    break;
                }
                if(leiji > max){
                    max = leiji;
                }
            }
        }

        return max;
    }
}
