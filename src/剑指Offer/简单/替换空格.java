package 剑指Offer.简单;

/**
 * @author hecai
 * @date 2020/12/11
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class 替换空格 {

    public static void main(String[] args) {
        String s = replaceSpace_a("We are happy.");
        System.out.println(s);
    }

    //方法一：直接使用 replaceAll 方法
    public static String replaceSpace(String s) {
        String s1 = s.replaceAll(" ", "%20");
        return s1;
    }
    //方法二：将字符串转为char数组
    public static String replaceSpace_a(String s) {
        int index = 0;
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length * 2];
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == ' '){
                res[index ++] = '%';
                res[index ++] = '2';
                res[index ++] = '0';
            }else{
                res[index ++] = chars[i];
            }
        }
        return new String(res, 0, index);
    }

}
