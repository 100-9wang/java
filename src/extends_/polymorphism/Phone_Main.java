package extends_.polymorphism;

public class Phone_Main {
    public static void main(String[] args) {
        SmartPhone smartPhone = new SmartPhone("홍길동");

        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.trunOff();
    }
}
