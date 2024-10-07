package operator;

public class Logic_Operator {
    public static void main(String[] args) {

        int charCode = 'A';

        if((charCode >= 65) & (charCode <= 90)) {
            System.out.println("대문자 이군요");
        }
        if((charCode >= 97) & (charCode <= 122)) {
            System.out.println("소문자 이군요");
        }
        if((charCode < 48) & (charCode > 57)) {
            System.out.println("0 ~ 9의 숫자 이군요");
        }

        int val = 6;

        if ((val % 2 == 0) | (val % 3 == 0)) {
            System.out.println("2 또는 3의 배수 이군요");
        }
        if ((val % 2 == 0) || (val % 3 == 0)) {
            System.out.println("2 또는 3의 배수 이군요");
        }
    }
}
