package Class_lib;

public class Car_Static {
    int speed;

    void run(){
        System.out.println(speed + "으로 달립니다.");
    }

    public static void main(String[] args) {
        Car_Static myCar = new Car_Static();
        myCar.speed = 60;
        myCar.run();
    }
}
