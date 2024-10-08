package class_lib;

public class Call_Method_Main {
    public static void main(String[] args) {
        Call_Method myCar = new Call_Method();
        myCar.keyTurnOn();
        myCar.run();
        int speed = myCar.getSpeed();
        System.out.println("현재 속도 : " + speed + "km/h");

    }
}
