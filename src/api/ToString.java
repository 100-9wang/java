package api;
import java.util.*;

public class ToString {
    public static void main(String[] args) {
        String str1 = "홍길동";
        String str2 = null;

        //Object 형으로 받아야 하는데 String 변수를 넣었기 때문에
        //casting 연산이  Object.toString()안에서 실행 되고 있음
        System.out.println(Objects.toString(str1));
        System.out.println(Objects.toString(str2));
        System.out.println(Objects.toString(str2, "이름이 없습니다."));
    }
}
