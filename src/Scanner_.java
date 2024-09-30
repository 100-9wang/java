import java.util.Scanner;

public class Scanner_ {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("x 값 입력 : ");
        String strX = s.nextLine();
        int x = Integer.parseInt(strX);

        System.out.println("y 값 입력 : ");
        String strY = s.nextLine();
        int y = Integer.parseInt(strY);
        
        int result = x + y;
        System.out.println("x + y : " + result);
        System.out.println();
        
        while(true) {
            System.out.println("입력 문자열 : ");
            String data = s.nextLine();
            if(data.equals("q")) {
                break;
            }
            System.out.println("출력 문자열 : " + data);
            System.out.println();
        }
        System.out.println("종료");
    }
}