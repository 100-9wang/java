public class Infinity_Nan_Check {
    public static void main(String[] args) {
        int x = 5;
        double y = 0.0;

        double z = x / y;

        System.out.println(Double.isInfinite(z));
        System.out.println(Double.isNaN(z));

        //잘못된  코드
        System.out.println(z + 2);

        //체크 코드
        if(Double.isInfinite(z) || Double.isNaN(z)) {
            System.out.println("값 산출 불가");
        } else {
            System.out.println(z + 2);
        }
    }
}
