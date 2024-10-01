package Operator;

public class Accuracy {
    public static void main(String[] args) {
//        정확한 계산을 위해서는 정수를 사용하는게 좋다

        //실수 사용
        int apple = 1;
        double pieceUnit = 0.1;
        int number = 7;

        double result = apple - number * pieceUnit;

        System.out.println("사과 한개에서 ");
        System.out.println("0.7 조각을 빼면, ");
        System.out.println(result + " 조각이 남는다. ");

        //정수 사용
        int banana = 1;

        int totalPieces = banana * 10;
        int num = 7;
        int temp = totalPieces - num;

        double result1 = temp / 10.0;

        System.out.println("바나나 한개에서 ");
        System.out.println("0.7 조각을 빼면, ");
        System.out.println(result1 + " 조각이 남는다. ");
    }
}
