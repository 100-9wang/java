package reports;

import java.sql.*;
import java.util.Scanner;

public class function_boards {
    Scanner s = new Scanner(System.in);
    Boards boards = new Boards();
    users users = new users();
    private Connection conn;
    private Connection1 con;
    private boolean signin = false;
    private boolean login = false;
    private String login_userID;

    //boards
    public function_boards() {
        this.con = new Connection1();
        this.conn = con.getConnection();
    }

    public void list() {
        System.out.println("[ 광민 게시판 ]");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("%-6s%-12s%-14s%-23s%-29s\n", "번호", "글쓴이", "주제", "날짜", "제목");
        System.out.println("-------------------------------------------------------------------------------------");

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

    public void user_menu() {
        if (login == false) {
            log_in();
        } else {
            while (true) {
                System.out.println("-------------------------------------------------------------------------------------");
                System.out.println("회원 메뉴 : 1. 정보 수정 | 2. 회원 탈퇴 | 3. 메인 메뉴 | 4. 로그아웃 | 0. 종료 |");
                System.out.print("메뉴를 선택하세요 : ");
                String inputNum = s.nextLine();
                System.out.println("-------------------------------------------------------------------------------------");

                switch (inputNum) {
                    case "1":
                        log_in();
                        user_update();
                        user_menu();
                        break;
                    case "2":
                        log_in();
                        singout();
                        user_menu();
                        break;
                    case "3":
                        list();
                        break;
                    case "4":
                        logout();
                        list();
                        break;
                    case "0":
                        exit();
                        break;
                }
            }
        }
    }
    public void main_menu() {

        while (true) {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("메인 메뉴 : 1. 게시글 생성 | 2. 게시글 수정 | 3. 게시글 삭제 | 4. 게시판 목록 | 5. 회원 가입 | 6. 내 정보 | 0. 종료 |");
            System.out.print("메뉴를 선택하세요 : ");
            String inputNum = s.nextLine();
            System.out.println("-------------------------------------------------------------------------------------");

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
                case "5":
                    singUp();
                    list();
                    break;
                case "6":
                    user_menu();
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
        if (login == false) {
            log_in();
        } else {
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
    }

    public void update() {
        if (login == false) {
            log_in();
        } else {
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
    }

    public void delete() {
        if (login == false) {
            log_in();
        } else {
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
    }

    //User
    public boolean singUp() {
        try {
            while (true) {
                System.out.println("회원 가입을 시작합니다.");
                System.out.print("아이디 : ");
                String user_ID = s.nextLine();

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
                System.out.println("숫자로 다시 입력해주세요.");
                return false;
            }

            System.out.print("이메일 : ");
            String email = s.nextLine();
            if (!Email_ok(email)) {
                System.out.println("유효하지 않은 이메일입니다. 다시 입력해주세요.");
                return false;
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
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void sing_up(){
        if (!signin) {
            while (!signin) {
                signin = singUp();
                if (!signin) {
                    System.out.println("회원 가입에 실패했습니다. 다시 시도해주세요.");
                }
            }
        }
    }

    private boolean Email_ok(String email) {
        String emailok = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,4}$";
        return email.matches(emailok);
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
                return found;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void singout() {
        System.out.println("회원 탈퇴를 선택하셨습니다.");
        System.out.print("아이디 : ");
        users.setUser_ID(s.nextLine());
        System.out.print("비밀번호 : ");
        users.setUser_PW(s.nextLine());

        try {
            String sql = "DELETE FROM boards WHERE user_id = ?, user_pw = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, users.getUser_ID());
            pstmt.setString(2, users.getUser_PW());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("회원탈퇴가 완료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login_check(String user_id, String user_pw) {
        try {
            String sql = "SELECT * FROM users WHERE user_id = ? AND user_pw = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user_id);
            pstmt.setString(2, user_pw);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                rs.close();
                pstmt.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void user_update(){
            System.out.println("정보 수정하기를 선택하셨습니다.");
            System.out.println("수정할 정보를 입력해주세요 : ");
            System.out.print("비밀번호 : ");
            users.setUser_PW(s.nextLine());
            System.out.print("이름 : ");
            users.setUser_Name(s.nextLine());
            System.out.print("나이 : ");
            users.setUser_Age(Integer.parseInt(s.nextLine()));
            System.out.print("이메일 : ");
            users.setUser_Email(s.nextLine());

            try {
                String sql = "UPDATE users SET user_pw = ?, user_name = ?, user_age = ?, user_email = ? WHERE user_id =?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(5, login_userID);
                pstmt.setString(1, users.getUser_PW());
                pstmt.setString(2,users.getUser_Name());
                pstmt.setInt(3, users.getUser_Age());
                pstmt.setString(4, users.getUser_Email());
                pstmt.executeUpdate();
                pstmt.close();
                System.out.println("회원정보가 성공적으로 수정되었습니다.");
            } catch (SQLException e) {
                System.out.println("회원정보 수정중 오류가 발생했습니다.");
                e.printStackTrace();
                exit();
            }
        }

    public boolean login() {
        int count = 0;
        try {
            while (true) {
                System.out.println("로그인을 시작합니다.");
                System.out.print("아이디 : ");
                String user_id = s.nextLine();

                System.out.print("비밀번호 : ");
                String user_pw = s.nextLine();

                if (login_check(user_id, user_pw)) {
                    System.out.println("로그인 성공");
                    login = true;
                    login_userID = user_id;
                    return true;
                } else {
                    count++;
                    System.out.println("아이디, 비밀번호를 잘못입력하셨습니다.");

                    if (count > 3){
                        System.out.println("회원가입을 하시겠습니까 ?");
                        System.out.println("1. 예 | 2. 아니오 ");
                        System.out.print("선택 : ");
                        String response = s.nextLine();
                        switch (response) {
                            case "1":
                                sing_up();
                                break;
                            case "2":
                                System.out.println("다시 로그인을 진행합니다.");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public void log_in(){
        if (!login) {
            while (!login) {
                login = login();
                if (!login) {
                    System.out.println("로그인에 실패했습니다. 다시 시도해주세요.");
                }
            }
        }
    }

    public boolean logout(){
        login = false;
        return false;
    }
}
