package test;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Reservation {
    public void RsMovie(Movie mv) throws IOException {
        mv.Mvlist();
        System.out.print("예매하실 영화를 선택해주세요: ");
        Scanner scanner = new Scanner(System.in);
        int mvNum = scanner.nextInt();

        String[] names = mv.getMovieNames();
        if (mvNum > 0 && mvNum <= names.length) {
            int rsNum = randNum();
            System.out.println(names[mvNum - 1] + " 을 예매하셨습니다.");
            System.out.println("[ 발급번호: " + rsNum + " ] 입니다.");
            System.out.println("즐거운 관람 되십시오.");
            saveRsNum(names[mvNum], rsNum);
        } else {
            System.out.println("영화를 잘못 선택하셨습니다.");
        }
    }

    private int randNum() {
        return (int) ((Math.random() * 1000000) + 1000);
    }

    private void saveRsNum(String name, int num) throws IOException {
        HashMap<String, Integer> mvmap = new HashMap<String, Integer>();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/gwangmin/mvrsnum.txt", true))) {
            writer.write(name + "\t" + num + "\n");
        }
    }

    public void cancelRs() throws IOException {
        System.out.print("발급번호를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        int rsNum = scanner.nextInt();

        File mvrsFile = new File("C:/gwangmin/mvrsnum.txt");
        File tempFile = new File("C:/gwangmin/temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(mvrsFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length > 1) {
                    int inputNum = Integer.parseInt(parts[1]);
                    if (inputNum == rsNum) {
                        found = true;
                        continue;
                    }
                }
                writer.write(line + "\n");
            }

            if (found) {
                mvrsFile.delete();
                tempFile.renameTo(mvrsFile);
                System.out.println("예매 취소가 정상적으로 처리되었습니다.");
            } else {
                System.out.println("입력하신 발급번호가 정확하지 않습니다.");
            }
        }
    }

    public void checkRs() throws IOException {

        Scanner scanner = new Scanner(System.in);
        int rsNum = scanner.nextInt();
        System.out.print("발급 번호를 입력하세요: ");

        File mvrsFile = new File("C:/gwangmin/temp.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(mvrsFile))) {

            String line;
            String mvName = "";
            boolean found = false;

            while ((line = br.readLine()) != null) {
                String parts[] = line.split("\t");
                if (parts.length > 1) {
                    try {
                        int inputNum = Integer.parseInt(parts[1]);
                        if (inputNum == rsNum) {
                            found = true;
                            mvName = parts[0];
                            break;

                        }
                    } catch (NumberFormatException e) {
                        System.out.println("발급번호 못찾음");
                        e.printStackTrace();
                    }
                }
            }
            if (found) {
                System.out.println("예매하신 영화는 " + mvName + "입니다.");

            } else {
                System.out.println("입력하신 발급번호가 정확하지 않습니다.");
                System.out.println("다시 확인하여 주세요.");
            }
        }
    }
}