package class_lib;

public class Calculator_Static_Main {
    public static void main(String[] args) {
        double result1 = 10 * 10 * Calculator_Static.pi;
        int result2 = Calculator_Static.plus(10, 5);
        int result3 = Calculator_Static.minus(10,5);

        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);
        System.out.println("result3 : " + result3);
    }
}
