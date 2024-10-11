package api;
import java.util.*;
import java.util.regex.Pattern;

public class Pattern_ {

    /*
^[0-9]*$ <숫자>

^[a-zA-Z]*$ <영문자>

^[가-힣]*$ <한글>

\\w+@\\w+\\.\\w+(\\.\\w+)? <E-Mail>

^\d{2,3}-\d{3,4}-\d{4}$ <전화번호>

^01(?:0|1|[6-9])-(?:\d{3}|\d{4})-\d{4}$ <휴대전화번호>

\d{6} \- [1-4]\d{6} <주민등록번호>

^\d{3}-\d{2}$ <우편번호>

     */
    public static void main(String[] args) {
        String regExp = "(02|010)-\\d{3,4}-\\d{4}";
        String data = "010-5329-5798";
        boolean result = Pattern.matches(regExp, data);
        if (result) {
            System.out.println("정규식과 일치합니다.");
        } else {
            System.out.println("정규식과 일치하지 않습니다.");
        }

        regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        data = "carpediem2001@natecom";
        result = Pattern.matches(regExp, data);
        if(result) {
            System.out.println("정규식과 일치합니다.");
        } else {
            System.out.println("정규식과 일치하지 않습니다.");
        }
    }
}
