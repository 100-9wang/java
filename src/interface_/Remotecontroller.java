package interface_;

public class Remotecontroller {
    public static void main(String[] args) {
        Remotecontrol rc;
        rc = new Television();
        rc = new Audio();
        rc = new Misson();

        // 미션 1 ##
        rc.setVolume(5);
        System.out.println();
        rc.turnOn();
        rc.turnOff();
    }
}
