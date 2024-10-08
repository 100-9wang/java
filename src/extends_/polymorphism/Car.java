package extends_.polymorphism;

public class Car {
    //필드
    Tire f_LeftTire = new Tire("앞왼쪽", 6);
    Tire f_RightTire = new Tire("앞오른쪽", 2);
    Tire b_LeftTire = new Tire("뒤왼쪽", 3);
    Tire b_RightTire = new Tire("뒤오른쪽", 4);
    //생성자


    //메소드
    int run(){
        System.out.println("[자동차가 달립니다.]");
        if(f_LeftTire.roll()==false) { stop(); return 1; };
        if(f_RightTire.roll()==false) { stop(); return 2; };
        if(b_LeftTire.roll()==false) { stop(); return 3; };
        if(b_RightTire.roll()==false) { stop(); return 4; };
        return 0;
    }

    void stop(){
        System.out.println("[자동차가 멈춥니다.]");
    }
}
