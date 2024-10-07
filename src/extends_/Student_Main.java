package extends_;

public class Student_Main {
    public static void main(String[] args) {
        Student student1 = new Student("홍길동", "123456 - 1234567", 1);
        System.out.println("name : " + student1.name);
        System.out.println("ssn : " + student1.ssn);
        System.out.println("studentNo : " + student1.studentNo);

        Student student2 = new Student("백광민", "011110 - 1234567", 109);
        System.out.println("name : " + student2.name);
        System.out.println("ssn : " + student2.ssn);
        System.out.println("studentNo : " + student2.studentNo);


    }
}
