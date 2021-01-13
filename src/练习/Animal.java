package 练习;

import java.util.HashMap;

/**
 * @author hecai
 * @date 2020/9/29
 */
public class Animal {

    public String name;
//    private int size;
//    private float weight;
    public Animal(String name){
        this.name = name;
    }

//    public void run(){
//        System.out.println("跑");
//    }
//    public void jump(){
//        System.out.println("跳");
//    }
//    public void go(){
//        System.out.println("走");
//    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Animal a = (Animal)obj;
        return this.name.equals(a.name);
    }

    public static void main(String[] args) {
        Animal a = new Animal("1");
        Animal b = new Animal("1");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        System.out.println(a.equals(b));
        System.out.println(a==b);


    }

}
