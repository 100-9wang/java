package operator;

public class InputData_NaN {
    public static void main(String[] args) {
        // / 와 % 일 때의 주의점
        // NaN 과 Infinity 연산은 주의할 것
        String userInput = "NaN";
        double val = Double.valueOf(userInput);

        double currentBalance = 10000.0;

        currentBalance += val;
        System.out.println(currentBalance);

        System.out.println("-----------------------");

        String userInput1 = "NaN1";
        double val1 = Double.valueOf(userInput1);

        double currentBalance1 = 10000.0;

        if (Double.isNaN(val1)){
            System.out.println("NaN이 입력되어 처리할 수 없음");
            val1 = 0.0;
        }

        currentBalance1 += val;
        System.out.println(currentBalance1);


    }
}
