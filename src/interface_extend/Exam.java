package interface_extend;

public class Exam {
    public static void main(String[] args) {
        /*
    인터페이스간 상속시 주의점
    ex)
   인터페이스 1 과 인터페이스 2를 상속받은 인터페이스 3가 있다고 가정

   구현 클래스에서 인터페이스 3에 선언된 추상 메소드가 필요해 호출하면
   인터페이스 3을 상속해준 인터페이스 1,2의 추상 메소드까지 전부 정의 해줘야함.
     */

        // 활용 클래스
        ImplementationC imp1 = new ImplementationC();

        InterfaceA ia = imp1;
        ia.methodA();
        //ia.methodB(); // 실행 안됨
        System.out.println();

        InterfaceB ib = imp1;
        ib.methodB();
        //ib.methodC(); // 실행 안됨
        System.out.println();

        InterfaceC ic = imp1;
        ic.methodA();
        ic.methodB();
        ic.methodC();

    }
}
