package 练习;

/**
 * 输出100到999之间的水仙花数
 * 所谓“水仙花数”是指一个三位数,其各位数字立方和等于该数 本身。
 * 例如：153是一个“水仙花数”,因为153=1的三次方＋5的三次方＋3的三次方。
 * @author hecai
 * @date 2020/9/29
 */
public class 水仙花 {

    public static void main(String[] args) {

        for(int i = 100; i <= 999; i++){
            int c = i % 10;
            int b = (i % 100 - c)/10;
            int a = i / 100;
            if(a*a*a + b*b*b+c*c*c == i){
                System.out.println(i);
            }
        }

    }

}
