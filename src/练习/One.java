package 练习;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hecai
 * @date 2020/10/4
 */
public class One {

    public static void main(String[] args) {
        List list = new ArrayList<>();
        Map<Integer,Integer> map =new HashMap<>();
        for(int i = 1; i <= 100; i++){
            list.add(i);
            if(i % 2 == 1){
                map.put(i, i+1);
            }
        }
        System.out.println(list.size());
        System.out.println(map);

    }

}
