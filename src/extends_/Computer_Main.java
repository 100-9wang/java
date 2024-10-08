package extends_;

public class Computer_Main {
    public static void main(String[] args) {
        int r = 10;
        Calculator1 calculator = new Calculator1();
        System.out.println("원면적 : " + calculator.areaCircle(r));
        System.out.println();

        Computer computer = new Computer();
        System.out.println("원면적 : " + computer.areaCircle(r));
    }
}
