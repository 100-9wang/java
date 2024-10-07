package operator;

public class String_Equals {
    public static void main(String[] args) {
        String strval1 = "신민철";
        String strval2 = "신민철";
        String strval3 = new String("신민철");

        System.out.println(strval1 == strval2);
        System.out.println(strval2 == strval3);
        System.out.println();
        System.out.println(strval1.equals(strval2));
        System.out.println(strval1.equals(strval3));
    }
}
