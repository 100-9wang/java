package interface_;

public class Remotecontroller {
    public static void main(String[] args) {
        Remotecontrol rc;
        rc = new Television();
        rc = new Audio();
        rc = new Misson();

        // 미션 1 ##
        System.out.println("#미션 1 \n" + "↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        rc.setVolume(5);
        System.out.println();

        System.out.println("#미션 2 \n" + "↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
        rc.turnOn();
        rc.setVolume(0);
        rc.turnOff();
    }
}
