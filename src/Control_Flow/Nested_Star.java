package Control_Flow;

public class Nested_Star {
    public static void main(String[] args) {
        //이중 반복문 사용
        // 별(*)로 사각형 만들기
        /*  * * * * *
            * * * * *
            * * * * *
            * * * * *
            * * * * *

         */
        for (int i = 1; i < 6; i++){
            for (int j = 1; j < 6; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }




        // 이중 반복문
        // 별(*)로 피라미드 만들기

        for(int i = 0; i < 5; i++){
            for (int j = 0; j < 10 - i; j++) {
                System.out.print("  ");
            }
            for (int k = 0; k <= i; k++){
                System.out.print(" *  ");
            }
            System.out.println();
            }
        }
    //                     *
    //                   *   *
    //                 *   *   *
    //               *   *   *   *
    //             *   *   *   *   *
    }

