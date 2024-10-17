package test;

import java.io.IOException;

public class MainMenu extends AbstractMenu {
    private Reservation reservation = new Reservation();
    private Movie movie;

    public MainMenu() throws IOException {
        try {
            movie = new Movie();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void display() {
        while (true) {
            try {
                System.out.println("-----------광민 극장-----------");
                System.out.println("     1. 영화 예매");
                System.out.println("     2. 예매 취소");
                System.out.println("     3. 예매 확인");
                System.out.println("     4. 관리자 설정");
                System.out.println("     0. 종료");
                System.out.print("메뉴 번호를 입력해주세요: ");

                int choice = scanner.nextInt();
                processInput(choice);
            } catch (Exception e) {
                System.out.println("알 수 없는 오류가 발생했습니다: " + e.getMessage());
            }
        }
    }

    @Override
    public void processInput(int choice) {
        try {
            switch (choice) {
                case 1:
                    reservation.RsMovie(movie);
                    break;
                case 2:
                    reservation.cancelReservation();
                    break;
                case 3:
                    reservation.checkReservation();
                    break;
                case 4:
                    System.out.println("관리자 기능은 현재 개발중입니다.");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
                    break;
            }
        } catch (IOException e) {
            System.out.println("입출력 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
