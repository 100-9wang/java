package project;

import java.io.*;
import java.util.Scanner;

public class home_app {
    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("프로그램이 시작됩니다.");
            System.out.println("-----------광민 극장-----------");
            System.out.println("  1. 영화 예매");
            System.out.println("  2. 예매 취소");
            System.out.println("  3. 예매 확인");
            System.out.println("  4. 관리자 설정");
            System.out.println("-----------광민 극장-----------");
            System.out.print("이용하시려는 메뉴 번호를 입력해주세요 : ");

            int click = s.nextInt();
            s.nextLine();

            switch (click) {
                case 1:
                    RsMovie();
                    break;
                case 2:
                    Cancel();
                    break;
                case 3:
                    System.out.println("확인라인");
                    break;
                case 4:
                    System.out.println("관리자 기능은 현재 개발중입니다.");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    s.close();
                    return;
                default:
                    System.out.println("잘못된 메뉴 번호입니다.");
                    break;
            }
        }
    }


    private static void RsMovie() throws Exception {
        FileReader mv_nameFile = new FileReader("C:/gwangmin/mvName.txt");
        int readMvNo;
        char[] cbuf = new char[100];
        StringBuilder sb = new StringBuilder();

        while ((readMvNo = mv_nameFile.read(cbuf)) != -1) {
            sb.append(cbuf, 0, readMvNo);
        }
        mv_nameFile.close();

        String data = sb.toString();
        String[] names = data.split("\n");

        System.out.println("영화 목록 : ");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        System.out.print("예매하실 영화를 선택해주세요 : ");
        Scanner s1 = new Scanner(System.in);
        int mvNum = s1.nextInt();

        if (mvNum > 0) {
            String MvName = names[mvNum-1];
            int RsNum = RandomNum();
            System.out.println(MvName + " 을 예약하셨습니다.");
            System.out.println("발급번호: " + RsNum);
        } else {
            System.out.println("잘못된 영화를 선택하셨습니당.");
        }
    }

    private static int RandomNum() {
        return (int)((Math.random() + 1000) * 10000);
    }

    private static int SaveMvNum() throws Exception{
        try {
            OutputStream SaveMvNum = new FileOutputStream("C:/gwangmin/mvrsnum.txt");
            int RanNum =
        }

    }

//    private static void ReadMvNum(){
//        FileReader fr = new FileReader("C:/gwangmin/")
//    }

    private static void Cancel() throws IOException {
        Scanner s2 = new Scanner(System.in);
        System.out.print("발급번호를 입력하세요: ");
        int Cancel_Num = s2.nextInt();

        File file = new File("C:/gwangmin/mvrsnum.txt");


//        private static void Check () { // 확인
//        }
    }
}

