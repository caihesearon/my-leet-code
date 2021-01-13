package 练习;

import sun.plugin.javascript.navig.Array;
import sun.plugin2.message.Conversation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author hecai
 * @date 2020/9/28
 */
public class 神州排序 {

    public static void main(String[] args) {
        String data = "19 5 9 255 9";
        System.out.println(sort(data));
    }

    public static int sort(String inData) {
        String[] s = inData.split(" ");

        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (String a : s) {
            list.add(Integer.parseInt(a));
        }
        boolean flag = true;
        do {
            int i = 0;
            for (i = 0; i < list.size() - 1; i++) {
                //先检查
                if (list.get(i) > list.get(i + 1)) {
                    flag = false;
                    break;
                }
            }
            if(i == list.size()-1){
                flag = true;
            }else{
                count++;
            }
            List<Integer> temp = new ArrayList<Integer>(list.subList(0, list.size() - 1));
            Collections.sort(temp);
            //将最大的移动到后面去
            int max = temp.get(temp.size() - 1);
            int index = list.indexOf(max);
            list.add(list.remove(index));
        } while (!flag);
        return count;
    }


}
