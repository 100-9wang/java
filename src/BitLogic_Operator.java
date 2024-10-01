public class BitLogic_Operator {
    public static void main(String[] args) {
        System.out.println("45 & 25 = " + (45 & 25));
        System.out.println("45 | 25 = " + (45 | 25));
        System.out.println("45 ^ 25 = " + (45 ^ 25));
        System.out.println("~45 = " + (~45));
        System.out.println("---------------------------");

        byte receiveData = -120;

        //방법 1 : 비트 논리곱 연산으로 Unsigned 정수 얻기
        int unsignedInt1 = receiveData & 255;
        System.out.println(unsignedInt1);

        //방법 2 : 자바 API를 이용해서 Unsigned 정수 얻기
        int unsigned2 = Byte.toUnsignedInt(receiveData);
        System.out.println(unsigned2);

        int test = 136;
        byte btest = (byte) test;
        System.out.println(btest);
    }
}
