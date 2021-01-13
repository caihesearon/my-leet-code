package 中等;
/**
*
* @author hecai
* @date 2020年6月9日
* 思路：
* 	递归遍历所有的情况
* 	只有为个位数和为两位数的情况
* 	注意在为两位数的情况下 可能十位会出现为零的情况 需要去掉这种情况
* 
*/

import java.util.HashSet;
import java.util.Set;

public class 把数字翻译成字符串 {
	
	static Set<String> set = new HashSet<String>();
	
    public static int translateNum(int num) {
    	String strNum = ""+num;
    	if(strNum.length() <= 1) {
    		return 1;
    	}
    	deal(0, 1, strNum, "");
    	deal(0, 2, strNum, "");
    	return set.size();
    }
    
    public static void deal(int index, int k, String num, String res) {
    	//判断当前下标    	
    	if(index >= num.length()) {
    		//判断set
    		if(!set.contains(res)) {
    			set.add(res);
    		}
    		return ;
    	}
    	if(index >= num.length()-1 && k == 2) {    		
    		//这个情况需要加上最后的一个
    		int num1 = Integer.parseInt(num.substring(num.length()-1));
    		res += ""+(char)('a'+num1);
    		if(num1 > 25) {
        		return ;
        	}
    		//判断set
    		if(!set.contains(res) ) {
    			set.add(res);
    		}
    		return ;
    	}
    	
    	//分别取出对应的数字
    	String strtemp = num.substring(index, index+k);
    	//去掉前面的零

    	int num1 = Integer.parseInt(strtemp);
    	if(num1 > 25) {
    		return ;
    	}
    	res += ""+(char)('a'+num1);
    	if(strtemp.length() == 2&&strtemp.charAt(0) == '0') {
    		res += ""+(char)('a'+num1);
    		return ;
    	}
    	deal(index+k, 1, num, res);
    	deal(index+k, 2, num, res);
    	
    }
    
    public static void main(String[] args) {
//    	deal(0, 1, "26","");
//    	deal(0, 2, "26","");
    	translateNum(506);//506
    	System.out.println(set.size());
    	for (String string : set) {
			System.out.println(string);
		}
//    	System.out.println(Integer.parseInt("01"));
//    	char s = 'a'+0;
//    	String num = ""+(char)('a'+0);
//    	System.out.println(num);
    	
	}

}
