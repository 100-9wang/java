package test;

public class String_IndexOf {
    public static void main(String[] args) {
        String sub = "자바 프로그래밍";

        int location = sub.indexOf("프로그래밍");
        System.out.println(location);
        String substring = sub.substring(location);
        System.out.println(substring);

        location = sub.indexOf("자바");
        if (location != 1){
            System.out.println("자바와 관련된 책이군요");
        } else {
            System.out.println("자바와 관련 없는 책이군요");
        }

        boolean result = sub.contains("자바");
        if(result) {
            System.out.println("자바와 관련된 책이군요");
        } else {
            System.out.println("자바와 관련 없는 책이군요");
        }
    }
}
