package Class_lib;

public class Return_Car_Main {
    public static void main(String[] args) {
        Return_Car myCar = new Return_Car();

        myCar.setGas(10); // Return_Car 의 setGas(); 호출

        boolean gasState = myCar.isLeftGas();
        if (gasState) {
            System.out.println("출발합니다.");
            myCar.run();
        }

        if (myCar.isLeftGas()) {
            System.out.println("가스를 주입할 필요가 없습니다.");
        } else {
            System.out.println("가스를 주입해주세요");
        }
    }
}
