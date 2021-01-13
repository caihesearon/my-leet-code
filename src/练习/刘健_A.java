package 练习;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author hecai
 * @date 2020/10/9
 */
public class 刘健_A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <str.length(); i++){
            String temp = String.valueOf(str.charAt(i));
            if(map.containsKey(temp)){
                Integer integer = map.get(temp);
                integer++;
                map.put(temp, integer);
            }else{
                map.put(temp, 1);
            }
        }
        System.out.println(map);


    }


}
