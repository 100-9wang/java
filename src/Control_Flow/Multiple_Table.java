package Control_Flow;

public class Multiple_Table {
    public static void main(String[] args) {

            // 구구단
            for (int i = 5; i < 6; i++){
                System.out.println("***" + i + "단 ***");
                for(int j = 1; j < 10; j++){
                    System.out.println(i + " * " + j + " = " + (i * j));
                }
                System.out.println();
        }
    }
}
