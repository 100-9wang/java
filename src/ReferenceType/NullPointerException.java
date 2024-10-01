package ReferenceType;

public class NullPointerException {
    public static void main(String[] args) {
       /* 잘못된 조작이나 코딩으로 발생하는 오류
        배열 상황에 제일 많이 일어남

         정의 : 참조변수가 null값을 가지고 있을 때, 객체의 필드나
        메소드를 사용하려고 하면 발생
    ex)
    int[] intArray = null;
    intArray[0] = 10;
    -> null인 intArray의 인덱스 값에 접근하려 하였으므로
        NullPointerException 발생

    String str = null;
    System.out.println("총 문자수 : " + str.length());
    -> null인 문자열 str변수에 str.length()메소드로 접근하려 하였으므로
        NullPointerException 발생

    **NPE 방지방법**

    1. null이 발생할 것 같은 값에 대해서 미리 null체크 하는 습관 들이기
    ex) if(str.equals("a") || str != null){} //x
        if(str != null || str.equals("a")){} //o

    2. toString() 대신 String.valueOf() 사용하기
    toString은 NPE가 발생하고 String.valueOf()는 null 스트링 값 자체가 리턴됨

    int i = null;
    System.out.println(String.valueOf(i)); // null
    System.out.println(i.toString()); // NPE




        */
    }
}
