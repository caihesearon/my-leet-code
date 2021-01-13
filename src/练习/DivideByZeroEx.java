package 练习;

/**
 * @author hecai
 * @date 2020/9/29
 */
public class DivideByZeroEx extends Exception {
    public static void main(String[] args) {
        try {
            new TestDivideByZero().div(1,0);
        } catch (DivideByZeroEx divideByZeroEx) {
            System.out.println("除数不能为0");
        }
    }
}

class TestDivideByZero {
    double div(double a, double b) throws DivideByZeroEx {
        if (b == 0) {
            throw new DivideByZeroEx();
        }
        return a / b;
    }

}
