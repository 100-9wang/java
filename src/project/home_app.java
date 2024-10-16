package project;

import class_lib.B;
import control_flow.Switch_Case_Nobreak;

import javax.management.relation.RelationSupport;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileReader;


public class home_app {
    // 예매 확인 단계에서 발급번호를 입력했을때 예매 정보가 나오게 하려면 키맵을 써야한다는걸 까먹ㅇ므
    private static Map<Integer, String> mvMap = new HashMap<>();

    public static void main(String[] args) throws Exception {

        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("프로그램이 시작됩니다.");
            System.out.println("-----------광민 극장-----------");
            System.out.println("     1. 영화 예매");
            System.out.println("     2. 예매 취소");
            System.out.println("     3. 예매 확인");
            System.out.println("     4. 관리자 설정");
            System.out.println("-----------광민 극장-----------");
            System.out.print("이용하시려는 메뉴 번호를 입력해주세요 : ");
            System.out.println();
            System.out.println("-----------------------------------");

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
//                    Check();
                    System.out.println("확인라인");
                    System.out.println();
                    break;
                case 4:
                    System.out.println("관리자 기능은 현재 개발중입니다.");
                    System.out.println();
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.out.println();
                    s.close();
                    return;
            }
        }
    }


    // 영화 예약 메소드
    private static void RsMovie() throws Exception {
        File mv_nameFile = new File("D:/Java_/java/mvName.txt");
    // 줄 수가 많지 않은데 굳이 StringBuilder를 써야하나 싶은 의문이 듬
//        try (BufferedReader rd = new BufferedReader(new FileReader(mv_nameFile))) {
//            StringBuilder sb = new StringBuilder();
//            String line;
//
//            while ((line = rd.readLine()) != null) {
//                sb.append(line).append("\n");
//            }
//
//            String data = sb.toString();
//            String[] names = data.split("\n");

        //배열 형식
        int line = 0;
        try(BufferedReader rd = new BufferedReader(new FileReader(mv_nameFile))) {
            while (rd.readLine() != null) {
                line++;
            }
        }
        String names[] = new String[line];

        try (BufferedReader rd = new BufferedReader(new FileReader(mv_nameFile))){
            for (int i = 0; i < line; i++){
                names[i] = rd.readLine();
            }

            System.out.println("영화 목록 : ");
            for (int i = 0; i < names.length; i++) {
                System.out.println(names[i]);
            }

            System.out.print("예매하실 영화를 선택해주세요 : ");
            Scanner s1 = new Scanner(System.in);
            int mvNum = s1.nextInt();

            // 조건이 두가지이기 떄문에  조건식을 and를 써야함
            // 키 입력 수가 0보다 작으면 인덱스 주소값은 -1됨
            // 키 입력 수가 배열 인덱스의 길이보다 작거나 같아야함
            if (mvNum > 0 && mvNum <= names.length) {
                String mvname = names[mvNum - 1];
                int Rsnum = RandomNum();
                System.out.println(mvname + " 을 예매 하셨습니다.");
                System.out.println("[ 발급번호 : " + Rsnum + " ] 입니다.");
                System.out.println("즐거운 관람 되십시오.");
                SaveMvNum(Rsnum);
            } else {
                System.out.println("영화를 잘못 선택 하셨습니다.");
            }
        }
    }

    //예매번호 난수 추출
    private static int RandomNum() {
        return (int)((Math.random() * 1000000)  + 1000);
    }

    // 예매번호를 mvrsnum에 저장
    private static void SaveMvNum(int num) throws IOException{
        try(BufferedWriter wt = new BufferedWriter(new FileWriter("D:/Java_/java/mvrsnum.txt",true))){
            wt.write(num + "\n");
        }
    }

    // 예매 취소
    private static void Cancel() throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.print("발급번호를 입력하세요 : ");
        int RsNum = s.nextInt();

        File mvrsFile = new File("d:/java_/java/mvrsnum.txt");
        File tempFile = new File("d:/java_/java/temp.txt");

        try (BufferedReader rd = new BufferedReader(new FileReader(mvrsFile));
             BufferedWriter wt = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            boolean found = false; // 요건 파일을 비교할때 찾았는지 못찾았는지를
                                                // 알려줄 변수 초깃값을 못찾음으로 설정

            while ((line = rd.readLine()) != null) {
                if (Integer.parseInt(line) == RsNum) {
                    found = true;
                    continue;
                }
                wt.write(line);
                wt.newLine();
            }
            if (found) {
                System.out.println("예매 취소가 정상적으로 처리되었습니다.");
            } else {
                System.out.println("발급 번호를 다시 확인해주세요.");
            }
        }
    }

        private static void Check () {
        Scanner s = new Scanner(System.in);
        System.out.println("발급 번호를 입력하세요 : ");
        int RsNum = s.nextInt();

            File mvrsFile = new File( "D:/Java/java_/mvrsnum.txt");
            try(BufferedReader br = new BufferedReader(new FileReader(mvrsFile))) {
                boolean found = false;
                while (found);
            }
    }
    }


