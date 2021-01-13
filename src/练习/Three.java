package 练习;

import java.util.Scanner;

/**
 * @author hecai
 * @date 2020/10/4
 */
public class Three {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = 0;
        int chars = 0;
        int others = 0;
        for (int i = 0; i < str.length(); i++) {
            String s = String.valueOf(str.charAt(i));
            if (s.matches("[0-9]")) {
                num++;
            } else if (s.matches("[a-z A-Z \u4e00-\u9fa5]")) {
                chars++;
            } else {
                others++;
            }
        }
        System.out.println("中英文字母："+chars);
        System.out.println("数字："+num);
        System.out.println("其他符号:"+others);

//        你想成为rapStart吗?.
    }
}
