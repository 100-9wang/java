package report;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class function_scores {
    //생성자
    Scanner s = new Scanner(System.in);
    teacher th = new teacher();
    students st = new students();
    Scores sc = new Scores();
    private Connection conn;
    private Connection1 con;
    private boolean signin = false;
    private boolean login = false;
    private String login_userID;
    private int count = 0;
    private String user_Type;
    public function_scores() {
        this.con = new Connection1();
        this.conn = con.getConnection();
    }

    //공용
    public void update() {
        if (user_Type.equals("th")) {
            th_update();
        } else if (user_Type.equals("st")) {
            st_update();
        }
    }
    public void signout() {
        if (user_Type.equals("th")) {
            th_singout();
        } else if (user_Type.equals("st")) {
            st_singout();
        }
    }
    public void return_menu() {
            if (user_Type == null) {
                System.out.println("로그인 상태가 아닙니다. 메인 메뉴로 돌아갑니다.");
                main_menu();
                return;
            }
            if (user_Type.equals("th")) {
                th_menu();
            } else if (user_Type.equals("st")) {
                st_menu();
            }
        }
    public boolean logout() {
        if (login) {
            login = false;
            login_userID = null;
            user_Type = null;
            System.out.println("로그아웃 되었습니다.");
            return true;
        } else {
            System.out.println("이미 로그아웃 상태입니다.");
            return false;
        }
    }
    public void exit() {
        System.out.println("성적조회 프로그램을 종료합니다.");
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
    public boolean singUp() {
        if (true) {
            System.out.println("[ 회원가입 ]");
            System.out.println("------------------------");
            System.out.println("1. 선생용 | 2. 학생용 ");
            System.out.println("------------------------");
            System.out.print("선택 : ");
            String response = s.nextLine();
            switch (response) {
                case "1":
                    th_sing_up();
                    break;
                case "2":
                    st_sing_up();
                    break;
            }
        }
        return false;
    }
    public String login_check(String ID, String PW) {
        try {
            String sql_th = "SELECT * FROM teacher WHERE th_id = ? AND th_pw = ?";
            String sql_st = "SELECT * FROM students WHERE st_id = ? AND st_pw = ?";

            PreparedStatement pstmt_th = conn.prepareStatement(sql_th);
            PreparedStatement pstmt_st = conn.prepareStatement(sql_st);

            pstmt_th.setString(1, ID);
            pstmt_th.setString(2, PW);
            ResultSet rs_th = pstmt_th.executeQuery();
            if (rs_th.next()) {
                return "th";
            }

            pstmt_st.setString(1, ID);
            pstmt_st.setString(2, PW);
            ResultSet rs_st = pstmt_st.executeQuery();
            if (rs_st.next()) {
                return "st";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "false";
    }

    public boolean login_() {
        System.out.print("아이디: ");
        String ID = s.nextLine();
        System.out.print("비밀번호: ");
        String PW = s.nextLine();

        String result = login_check(ID, PW);
        if (result.equals("th")) {
            user_Type = "th";
            login = true;
            login_userID = ID;
            th_menu(); // 로그인 성공 후 교육자 메뉴 호출
            return true;
        } else if (result.equals("st")) {
            user_Type = "st";
            login = true;
            login_userID = ID;
            st_menu(); // 로그인 성공 후 학생 메뉴 호출
            return true;
        } else {
            count++;
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다. 다시 시도하세요.");
            if (count >= 3) {
                System.out.println("회원가입을 하시겠습니까 ? (1. 예 | 2. 아니오) ");
                String response = s.nextLine();
                switch (response) {
                    case "1":
                        singUp();
                        break;
                    case "2":
                        System.out.println("다시 로그인을 진행합니다.");
                        return false; // 메인 루프 종료
                }
            }
        }
        return false; // 로그인 실패
    }

    public void login() {
        count = 0; // 로그인 시도 횟수 초기화
        while (!login) {
            boolean success = login_(); // 로그인 시도
            if (success) {
                break; // 로그인 성공하면 루프 종료
            }
        }
    }


    // ㅔㅁ뉴
    public void th_menu() {
        while(true) {
            System.out.println("[ 교육자 메뉴 ]");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("1. 과목점수 입력 | 2. 점수평균 입력 | 3. 점수합계 입력 | 4. 등수입력 | 5. 내 정보 | 0. 종료 ");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");
            String inputNum = s.nextLine();

            switch (inputNum) {
                case "1":
                    put_scores();
                    break;
                case "2":
                    put_avg();
                    break;
                case "3":
                    put_total();
                    break;
                case "4":
                    //put_rank();
                    break;
                case "5":
                    my_menu();
                    break;
                case "0":
                    exit();
                    return;
            }
        }
    }
    public void st_menu() {
        while (true) {
            System.out.println("[ 학생 메뉴 ]");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("1. 과목점수 조회 | 2. 과목평균 조회 | 3. 과목합계 조회 | 4. 등수 조회 | 5. 내 정보 | 0. 종료 ");
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");
            String inputNum = s.nextLine();

            switch (inputNum) {
                case "1":
                    view_scores();
                    break;
                case "2":
                    view_avg();
                    break;
                case "3":
                    view_total();
                    break;
                case "4":
                    //view_rank();
                    break;
                case "5":
                    my_menu();
                    break;
                case "0":
                    exit();
                    break;
            }
        }
    }
    public void main_menu() {
        System.out.println("[ 성적 조회 프로그램 ]");
        System.out.println("------------------------");
        System.out.println(" 1. 회원 가입 | 2. 로그인 ");
        System.out.println("------------------------");
        System.out.print("선택 : ");
        String inputNum = s.nextLine();
        switch (inputNum) {
            case "1":
                singUp();
                break;
            case "2":
                login();
                break;
        }
    }
    public void my_menu() {
        while (true) {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("회원 정보 메뉴 : 1. 정보 수정 | 2. 회원 탈퇴 | 3. 메인 메뉴 | 4. 로그아웃 | 0. 종료 |");
            String inputNum = s.nextLine();
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.print("메뉴를 선택하세요 : ");

            switch (inputNum) {
                case "1":
                    update();
                    break;
                case "2":
                    signout();
                    break;
                case "3":
                    return_menu();
                    break;
                case "4":
                    logout();
                    return_menu();
                    break;
                case "0":
                    exit();
                    break;
            }
        }
    }

    //teacher
    public boolean th_singUp() {
        try {
            while (true) {
                System.out.println("회원 가입을 시작합니다.");
                System.out.print("아이디 : ");
                String th_id = s.nextLine();

                if (th_id_dupl(th_id)) {
                    System.out.println("이미 사용중인 아이디 입니다.");
                } else {
                    th.setth_id(th_id);
                    break;
                }
            }

            System.out.print("비밀번호 : ");
            th.setth_pw(s.nextLine());

            System.out.print("이름 : ");
            th.setth_name(s.nextLine());

            System.out.print("과목 : ");
            th.setth_class(s.nextLine());

            System.out.print("이메일 : ");
            String email = s.nextLine();
            if (!Email_ok(email)) {
                System.out.println("유효하지 않은 이메일입니다. 다시 입력해주세요.");
                return false;
            }
            th.setth_email(email);

            String sql = "INSERT INTO teacher (th_id, th_pw, th_class, th_name, th_email) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, th.getth_id());
            pstmt.setString(2, th.getth_pw());
            pstmt.setString(3, th.getth_class());
            pstmt.setString(4, th.getth_name());
            pstmt.setString(5, th.getth_email());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("회원 가입이 정상적으로 처리되었습니다.");
            th_menu();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void th_sing_up() {
        if (!signin) {
            while (!signin) {
                signin = th_singUp();
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
    private boolean th_id_dupl(String th_ID) {
        try {
            String sql = "SELECT COUNT(*) FROM teacher WHERE th_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, th_ID);
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
    public void th_update() {
        System.out.println("정보 수정하기를 선택하셨습니다.");
        System.out.println("수정할 정보를 입력해주세요 : ");
        System.out.print("비밀번호 : ");
        th.setth_pw(s.nextLine());
        System.out.print("과목 : ");
        th.setth_class(s.nextLine());
        System.out.print("이름 : ");
        th.setth_name(s.nextLine());
        System.out.print("이메일 : ");
        th.setth_email(s.nextLine());

        try {
            String sql = "UPDATE teacher SET th_pw = ?, th_class = ?, th_name = ?, th_email = ? WHERE th_id =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(5, login_userID);
            pstmt.setString(1, th.getth_pw());
            pstmt.setString(2, th.getth_class());
            pstmt.setString(3, th.getth_name());
            pstmt.setString(4, th.getth_email());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("회원정보가 성공적으로 수정되었습니다.");
        } catch (SQLException e) {
            System.out.println("회원정보 수정중 오류가 발생했습니다.");
            e.printStackTrace();
            exit();
        }
    }
    public void th_singout() {
        System.out.println("회원 탈퇴를 선택하셨습니다.");
        System.out.print("아이디 : ");
        th.setth_id(s.nextLine());
        System.out.print("비밀번호 : ");
        th.setth_pw(s.nextLine());

        try {
            String sql = "DELETE FROM teacher WHERE th_id = ?, th_pw = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, th.getth_id());
            pstmt.setString(2, th.getth_pw());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("회원탈퇴가 완료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //teacher 기능
    public void put_scores() {
        System.out.println("[ 과목점수 입력을 선택하셨습니다. ]");
        System.out.print("학년 - 반을 입력해주세요 : ");
        sc.setGrades(s.nextLine());
        System.out.print("점수매길 학생의 아이디를 입력해주세요 : ");
        sc.setSc_st_id(s.nextLine());
        System.out.print("국어 : ");
        sc.setKorean(s.nextInt());
        System.out.print("영어 : ");
        sc.setEnglish(s.nextInt());
        System.out.print("수학 : ");
        sc.setMath(s.nextInt());
        System.out.print("과학 : ");
        sc.setScience(s.nextInt());
        s.nextLine();
        try {
            String sql = "INSERT INTO scores (grades, korean, english, math, science, st_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sc.getGrades());
            pstmt.setInt(2, sc.getKorean());
            pstmt.setInt(3, sc.getEnglish());
            pstmt.setInt(4, sc.getMath());
            pstmt.setInt(5, sc.getScience());
            pstmt.setString(6, sc.getSc_st_id());
            pstmt.executeUpdate();

            System.out.println("과목별 점수 입력을 완료했습니다.");
            pstmt.close();

            th_menu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put_avg() {
        System.out.println("[ 평균점수 입력을 선택하셨습니다. ]");
        System.out.print("평균을 입력할 학생의 아이디를 입력하세요 : ");
        sc.setSc_st_id(s.nextLine());

        try {
            String sql = "" + "UPDATE scores SET sc_avg = (SELECT (korean + english + math + science) / 4 FROM scores WHERE st_id = ?) WHERE st_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sc.getSc_st_id());
            pstmt.setString(2, sc.getSc_st_id());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("평균 점수 입력을 완료했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void put_total() {
        System.out.println("[ 총합 점수 입력을 선택하셨습니다. ]");
        System.out.print("총합 점수를 입력할 학생의 아이디를 입력하세요 : ");
        sc.setSc_st_id(s.nextLine());

        try {
            String sql = "" + "UPDATE scores \n" +
                    "SET sc_total = (SELECT SUM(korean + english + math + science) FROM scores WHERE st_id = ?) WHERE st_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sc.getSc_st_id());
            pstmt.setString(2, sc.getSc_st_id());

            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("총합 점수 입력을 완료했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void put_rank() {
//        System.out.println("[ 등수 입력을 선택하셨습니다. ]");
//
//        try {
//            String sql = "" + "UPDATE scores SET sc_rank = RANK() OVER (PARTITION BY grades ORDER BY (korean + english + math + science) DESC)";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//
//            pstmt.executeUpdate();
//            pstmt.close();
//            System.out.println("등수 입력을 완료했습니다.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    //students
    public boolean st_singUp() {
        try {
            while (true) {
                System.out.println("회원 가입을 시작합니다.");
                System.out.print("아이디 : ");
                String st_id = s.nextLine();

                if (st_id_dupl(st_id)) {
                    System.out.println("이미 사용중인 아이디 입니다.");
                } else {
                    st.setst_id(st_id);
                    break;
                }
            }

            System.out.print("비밀번호 : ");
            st.setst_pw(s.nextLine());

            System.out.print("이름 : ");
            st.setst_name(s.nextLine());

            System.out.print("학년 반 : ");
            st.setst_grade(s.nextLine());

            String sql = "INSERT INTO students (st_id, st_pw, st_name, st_grade) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, st.getst_id());
            pstmt.setString(2, st.getst_pw());
            pstmt.setString(3, st.getst_name());
            pstmt.setString(4, st.getst_grade());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("회원 가입이 정상적으로 처리되었습니다.");
            st_menu();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void st_sing_up() {
        if (!signin) {
            while (!signin) {
                signin = st_singUp();
                if (!signin) {
                    System.out.println("회원 가입에 실패했습니다. 다시 시도해주세요.");
                }
            }
        }
    }
    private boolean st_id_dupl(String st_ID) {
        try {
            String sql = "SELECT COUNT(*) FROM students WHERE st_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, st_ID);
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
    public void st_update() {
        System.out.println("정보 수정하기를 선택하셨습니다.");
        System.out.println("수정할 정보를 입력해주세요 : ");
        System.out.print("비밀번호 : ");
        st.setst_pw(s.nextLine());
        System.out.print("이름 : ");
        st.setst_name(s.nextLine());
        System.out.print("학년 반 : ");
        st.setst_grade(s.nextLine());

        try {
            String sql = "UPDATE students SET st_pw = ?, st_name = ?, st_grade = ? WHERE st_id =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(4, login_userID);
            pstmt.setString(1,st.getst_pw());
            pstmt.setString(2, st.getst_name());
            pstmt.setString(3, st.getst_grade());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("학생정보가 성공적으로 수정되었습니다.");
        } catch (SQLException e) {
            System.out.println("학생정보 수정중 오류가 발생했습니다.");
            e.printStackTrace();
            exit();
        }
    }
    public void st_singout() {
        System.out.println("회원 탈퇴를 선택하셨습니다.");
        System.out.print("아이디 : ");
        st.setst_id(s.nextLine());
        System.out.print("비밀번호 : ");
        st.setst_pw(s.nextLine());

        try {
            String sql = "DELETE FROM students WHERE st_id = ?, st_pw = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, st.getst_id());
            pstmt.setString(2, st.getst_pw());
            pstmt.executeUpdate();
            pstmt.close();
            System.out.println("회원탈퇴가 완료되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //students 기능
    public  void  view_scores() {
        System.out.println( "과목 점수 조회를 선택하셨습니다.");
        System.out.print("과목 성적을 조회 할 아이디를 입력해주세요 : ");
        st.setst_id(s.nextLine());
        try{
            String sql = "SELECT korean, english, math, science FROM scores WHERE st_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, st.getst_id());
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                sc.setKorean(rs.getInt("korean"));
                sc.setEnglish(rs.getInt("english"));
                sc.setMath(rs.getInt("math"));
                sc.setScience(rs.getInt("science"));
                System.out.println(
                        "국어 : " + sc.getKorean()  + "\n" +
                        "영어 : " + sc.getEnglish() + "\n"+
                        "수학 : " + sc.getMath() + "\n" +
                        "과학 : " + sc.getScience());
            }
            rs.close();
            pstmt.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void view_avg(){
        System.out.println("과목 평균 조회를 선택하셨습니다.");
        System.out.print("과목 평균을 조회 할 아이디를 입력해주세요 : ");
        st.setst_id(s.nextLine());
        try{
            String sql = "SELECT sc_avg FROM scores WHERE st_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, st.getst_id());
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                sc.setSc_avg(rs.getInt("sc_avg"));
                System.out.println(
                        "과목 평균 : " + sc.getSc_avg());
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void view_total() {
        System.out.println("과목 총합 조회를 선택하셨습니다.");
        System.out.print("과목 총합을 조회 할 아이디를 입력해주세요 : ");
        st.setst_id(s.nextLine());
        try {
            String sql = "SELECT sc_total FROM scores WHERE st_id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, st.getst_id());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                sc.setSc_total(rs.getInt("sc_total"));
                System.out.println(
                        "과목 총합 : " + sc.getSc_total());
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //view_rank(){}
}

