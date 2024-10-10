package Exception;

public class Try_Catch_Exception {
    public static void main(String[] args) {
        String data1 = null;
        String data2 = null;
        try {
            data1 = args[0];
            data2 = args[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough parameters provided.");
            System.out.println("[Usage]");
            System.out.println("Java TryCatchFinallyRuntimeExceptionExample num1, num2");
            return;
        }

        try {
            int val1 = Integer.parseInt(data1);
            int val2 = Integer.parseInt(data2);
            int result1 = val1 + val2;
            int result2 = val1 - val2;
            int result3 = val1 / val2;
            int result4 = val1 * val2;
            System.out.println(data1 + " + " + data2 + "=" + result1);
            System.out.println(data1 + " - " + data2 + "=" + result2);
            System.out.println(data1 + " / " + data2 + "=" + result3);
            System.out.println(data1 + " * " + data2 + "=" + result4);
        } catch (NumberFormatException e) {
            System.out.println("Cannot convert to number.");
        } finally {
            System.out.println("Please run again.");
        }
    }
}
