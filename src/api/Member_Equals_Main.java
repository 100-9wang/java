package api;

public class Member_Equals_Main {
    public static void main(String[] args) {
        Member_Equals obj1 = new Member_Equals("blue");
        Member_Equals obj2 = new Member_Equals("blue");
        Member_Equals obj3 = new Member_Equals("red");

        if(obj1.equals(obj2)){
            System.out.println("obj1과 obj2는 동등합니다.");
        } else {
            System.out.println("obj1과 obj2는 동등하지 않습니다.");
        }

        if(obj1.equals(obj3)){
            System.out.println("obj1과 obj3은 동등합니다");
        } else {
            System.out.println("obj1과 obj3은 동등하지 않습니다.");
        }
    }
}
