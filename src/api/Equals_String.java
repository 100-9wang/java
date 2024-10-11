package api;

public class Equals_String {
    public static void main(String[] args) {
        String strval1 = new String("백광민");
        String strval2 = "백광민";
        
        if (strval1 == strval2){
            System.out.println("같은 String 객체 참조");
        } else {
            System.out.println("다른 String 객체 참조");
        }
        
        if(strval1.equals(strval2)){
            System.out.println("같은 문자열을 가짐");
        } else {
            System.out.println("다른 문자열을 가짐");
        }
    }
}
