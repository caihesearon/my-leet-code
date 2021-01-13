package 练习;

/**
 * @author hecai
 * @date 2020/9/28
 */
public class A {

    void test(){
        System.out.println("A");
    }

    public static void main(String[] args) {
        B b = new B();
        b.test();
    }
}
class B extends A{

    void test(){
        super.test();
        System.out.println("B");
    }

}
