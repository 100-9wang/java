package interface_;

public class Remotecontroller {
    public static void main(String[] args) {
        Remotecontrol rc;
        rc = new Television();
        rc = new Audio();
        rc = new Misson();

//      Remotecontrol rc = null;

        // 미션 1 ##
        System.out.println("-------------------------------#1");
        System.out.println("#미션 1 : ");
        rc.setVolume(5);
        System.out.println("-------------------------------#1");

        System.out.println("-------------------------------#2");
        System.out.println("#미션 2 : ");
        rc.turnOn();
        rc.setVolume(0);
        rc.turnOff();
        System.out.println("-------------------------------#2");

        //인터페이스 구현 객체 대입 후 사용
        System.out.println("-------------------------------#3");
        rc = new Television();
        rc.turnOn();
        rc.setMute(true);
        rc.setMute(false);
        rc.turnOff();
        System.out.println();
        rc = new Audio();
        rc.turnOn();
        rc.setMute(true);
        rc.setMute(false);
        rc.turnOff();
        System.out.println("-------------------------------#3");

        // 정적 메소드 인터페이스로 호출
        System.out.println("-------------------------------#4");
        Remotecontrol.changeBattery();
        System.out.println("-------------------------------#4");
    }
}
