package report;

import java.sql.*;
import java.util.Scanner;

public class function_boards {
    Scanner s = new Scanner(System.in);
    Boards boards = new Boards();
    users users = new users();
    private Connection conn;
    private Connection1 con;
    private boolean isSignedUp = false;

    //boards
    public function_boards() {
        this.con = new Connection1();
        this.conn = con.getConnection();
    }

    public void list() {
        System.out.println("[ 광민 게시판 ]");
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-14s%-23s%-29s\n", "번호", "글쓴이", "주제", "날짜", "제목");
        System.out.println("-------------------------------------------------------------------------");

        try {
            String sql = "SELECT b_no, b_writer, b_content, b_title, b_date FROM boards";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                boards.setB_no(rs.getInt("b_no"));
                boards.setB_writer(rs.getString("b_writer"));
                boards.setB_content(rs.getString("b_content"));
                boards.setB_date(rs.getDate("b_date"));
                boards.setB_title(rs.getString("b_title"));
                System.out.printf("%-6s%-12s%-14s%-23s%-29s\n",
                        boards.getB_no(),
                        boards.getB_writer(),
                        boards.getB_content(),
                        boards.getB_date(),
                        boards.getB_title());
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        main_menu();
    }

    public void main_menu() {

        if (!isSignedUp) { // 회원가입이 되어 있지 않으면
            while (!isSignedUp) {
                isSignedUp = singUp(); // 회원가입 시도
                if (!isSignedUp) {
                    System.out.println("회원 가입에 실패했습니다. 다시 시도해주세요.");
                }
            }
        }
        while (true){
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("메인 메뉴 : 1. 게시글 생성 | 2. 게시글 수정 | 3. 게시글 삭제 | 4. 게시판 목록 | 0. 종료");
        System.out.print("메뉴를 선택하세요 : ");
        String inputNum = s.nextLine();
        System.out.println("-------------------------------------------------------------------------");

        switch (inputNum) {
            case "1":
                create();
                list();
                break;
            case "2":
                update();
                list();
                break;
            case "3":
                delete();
                list();
                break;
            case "4":
                list();
                break;
            case "0":
                exit();
                break;
        }
    }
}

    public void exit() {
        System.out.println("게시판 프로그램을 종료합니다.");
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public void create() {
        System.out.println("게시글 생성을 선택하셨습니다.");
        System.out.print("번호 : ");
        boards.setB_no(Integer.parseInt(s.nextLine()));
        System.out.print("글쓴이 : ");
        boards.setB_writer(s.nextLine());
        System.out.print("주제 : ");
        boards.setB_content(s.nextLine());
        System.out.print("제목 : ");
        boards.setB_title(s.nextLine());

        try {
            String sql = "INSERT INTO boards (b_no, b_content, b_writer, b_date, b_title) VALUES (?, ?, ?, SYSDATE, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boards.getB_no());
            pstmt.setString(2, boards.getB_content());
            pstmt.setString(3, boards.getB_writer());
            pstmt.setString(4, boards.getB_title());

            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("게시글이 성공적으로 생성되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        System.out.println("게시글 수정하기를 선택하셨습니다.");
        System.out.print("변경할 게시글의 번호를 입력해주세요 : ");
        boards.setB_no(Integer.parseInt(s.nextLine()));

        System.out.println("수정할 내용을 입력해주세요.");
        System.out.print("글쓴이 : ");
        boards.setB_writer(s.nextLine());
        System.out.print("주제 : ");
        boards.setB_content(s.nextLine());
        System.out.print("제목 : ");
        boards.setB_title(s.nextLine());

        try {
            String sql = "UPDATE boards SET b_writer = ?, b_content = ?, b_title = ? WHERE b_no = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boards.getB_writer());
            pstmt.setString(2, boards.getB_content());
            pstmt.setString(3, boards.getB_title());
            pstmt.setInt(4, boards.getB_no());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("게시글이 성공적으로 수정되었습니다.");
        } catch (SQLException e) {
            System.out.println("게시글 수정중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    public void delete() {
        System.out.println("게시글 삭제를 선택하셨습니다.");
        System.out.print("번호 : ");
        boards.setB_no(Integer.parseInt(s.nextLine()));

        try {
            String sql = "DELETE FROM boards WHERE b_no = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, boards.getB_no());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("게시글이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //User
    public boolean singUp() {
        try {
            while (true) {
                System.out.println("회원 가입을 시작합니다.");
                System.out.print("아이디 : ");
                String user_ID = s.nextLine();

                // 중복 검사
                if (userid_dupl(user_ID)) {
                    System.out.println("이미 사용중인 아이디 입니다.");
                } else {
                    users.setUser_ID(user_ID);
                    break;
                }
            }

            System.out.print("비밀번호 : ");
            users.setUser_PW(s.nextLine());

            System.out.print("이름 : ");
            users.setUser_Name(s.nextLine());

            System.out.print("만 나이 : ");
            int age;
            try {
                age = Integer.parseInt(s.nextLine());
                users.setUser_Age(age);
            } catch (NumberFormatException e) {
                System.out.println("나이는 숫자여야 합니다. 다시 입력해주세요.");
                return false; // 회원가입 실패
            }

            System.out.print("이메일 : ");
            String email = s.nextLine();
            if (!isValidEmail(email)) {
                System.out.println("유효하지 않은 이메일입니다. 다시 입력해주세요.");
                return false; // 회원가입 실패
            }
            users.setUser_Email(email);

            String sql = "INSERT INTO users (user_id, user_name, user_pw, user_age, user_email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, users.getUser_ID());
            pstmt.setString(2, users.getUser_Name());
            pstmt.setString(3, users.getUser_PW());
            pstmt.setInt(4, users.getUser_Age());
            pstmt.setString(5, users.getUser_Email());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("회원 가입이 정상적으로 처리되었습니다.");
            return true; // 회원가입 성공
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // SQL 예외로 인해 실패
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 일반 예외로 인해 실패
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$";
        return email.matches(emailRegex);
    }

    private boolean userid_dupl(String user_ID) {
        try {
            String sql = "SELECT COUNT(*) FROM users WHERE user_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_ID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                boolean found = rs.getInt(1) > 0;
                rs.close();
                pstmt.close();
                return found; // 중복이면 true
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // 중복이 아니면 false
    }
}
