package 练习;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

/**
 * @author hecai
 * @date 2020/9/10
 */
public class Test {

    public String a;
    public static int b;
    public Test(String a, int b){
        this.a = a;
        this.b = b;
    }

//    @Override
//    public boolean equals(Object o) {
//        Test t = (Test)o;
//        return this.a.equals(t.a) && this.b == t.b;
//    }

    @Override
    public int hashCode() {
        return a.hashCode()*10+b;
    }

    static void test(int a){
        a = 2;
    }

    public static void main(String[] args) throws IOException {

        int a = 1;
        test(a);
        System.out.println(a);



//        Test t = new Test("a", 1);
//        Test tt = new Test("a", 1);
//        System.out.println(t.hashCode());
//        System.out.println(tt.hashCode());
//        System.out.println(tt == t);
//        System.out.println(tt.equals(t));
//
//        HashSet set = new HashSet();
//        set.add(t);
//        System.out.println(set);
//        set.add(tt);
//        System.out.println(set);



//        int x = 5, y = 5;
//        y = ++x * --y;
//        x = (x--);
//        System.out.println(x + " " + y);
//        throw new StackOverflowError();

//        try {
//
//        }catch (Exception e){
//
//        } finally{
//
//        }


//        List<String> list = new ArrayList<String>();
//        Iterator iterator = list.iterator();
//        while(iterator.hasNext()){
//            String next = (String)iterator.next();
//        }
//        HashMap<String,String> map = new HashMap();
//        map.put("1","2");
//        String value = map.put("1","3");


//        Test t1 = new Test();
//        Test t2 = t1;
//        System.out.println(t1.equals(t2));


//        File file = new File("test");
//        if (!file.exists()){
//            file.mkdir();
//        }
//        File file1 = new File(file.getAbsolutePath()+"/a.txt");
//        System.out.println();
//        file1.createNewFile();
//        file1.setReadOnly();

    }

}
