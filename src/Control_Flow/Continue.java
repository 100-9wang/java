package Control_Flow;

public class Continue {
    public static void main(String[] args) {
// 짝수 출력
        System.out.println("***짝수***");
        for (int i = 1; i <= 10; i++){
            if(i % 2 != 0){
                continue;
            }
            System.out.println(i);
        }
        System.out.println();


// 홀수 출력
        System.out.println("***홀수***");
        for (int j = 1; j <= 9; j++){
            if(j % 2 != 1){
               continue;
            }
            System.out.println(j);
        }
    }
}
