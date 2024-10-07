package class_lib1;

public class Creat_Constructor_Definition2_Main {
    public static void main(String[] args) {
        Creat_Constructor_Definition2 ccd1 = new Creat_Constructor_Definition2("박자바", "011110-1234567");
        System.out.println("ccd1.name : " + ccd1.name);
        System.out.println("ccd1.ssn : " + ccd1.ssn);


        Creat_Constructor_Definition2 ccd2 = new Creat_Constructor_Definition2("KIM JAVA", "011110-7654321");
        System.out.println("ccd2.name : " + ccd2.name);
        System.out.println("ccd2.ssn : " + ccd2.ssn);
    }
}
