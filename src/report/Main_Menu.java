package report;

import java.sql.*;
import java.util.Scanner;


import static report.Delete.exit;

public class Main_Menu {

    public static void list() throws Exception {
        Connection conn = null;
        Scanner s = new Scanner(System.in);
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "system",
                    "oracle"
            );
            String sql = ""
                    + "SELECT * "
                    + "FROM boards ";

            System.out.println(" [ 광민 게시판 ] ");
            System.out.printf("-6%s-12%s-17%s-40%s\n", "No", "Writer", "Date", "Title");
            System.out.println("-------------------------------");

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Board board = new Board();
                    board.setB_no(rs.getInt("b_no"));
                    board.setB_writer(rs.getString("b_writer"));
                    board.setB_date(rs.getDate("b_date"));
                    board.setB_title(rs.getString("b_title"));
                    System.out.println(board);
                }
                rs.close();
                pstmt.close();

                mainMenu();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                    }
                }
            }
        } catch (SQLException e) {
        }
        System.out.println("-------------------------------");
    }

    public static void mainMenu() throws Exception {


        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "system",
                    "oracle"
            );
            Scanner s = new Scanner(System.in);
            System.out.println("-------------------------------");
            System.out.println("메인메뉴 : 1. Create | 2. Read | 3. Clear | 4. Exit");
            System.out.print("메뉴 선택 : ");
            String menuNum = s.nextLine();
            System.out.println(menuNum + "을 선택하셨습니다.");

                switch (menuNum) {
                    case "1":
                        create();
                        break;
                    case "2":
                        read();
                        break;
                    case "3":
                        delete();
                        break;
                    case "0":
                        exit();
                }
        }catch (Exception e) {}
    }

    public static void read() throws Exception{
        Connection conn = null;
        Scanner s = new Scanner(System.in);

        String sql ="" + "SELECT * FROM boards WHERE b_no=? ";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        System.out.println("No : ");
        String b_no = s.nextLine();
        pstmt.setString(1, b_no);

        int rows = pstmt.executeUpdate();
        System.out.println(rows + "개의 게시글이 있습니다.");
    }

    public static void delete() throws Exception {
        Connection conn = null;
        Scanner s = new Scanner(System.in);

        String sql ="" + "DELETE FROM boards WHERE b_no=? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);

        System.out.println("No : ");
        String b_no = s.nextLine();
        pstmt.setString(1, b_no);

        int rows = pstmt.executeUpdate();
        System.out.println(rows + "개의 게시글이 삭제 되었습니다.");

        pstmt.close();
        list();
    }

    public static void create () throws Exception {
                Connection conn = null;
                Scanner s = new Scanner(System.in);
                String sql = "INSERT INTO boards (b_no, b_writer, b_date, b_title) " +
                        "VALUES (SEQ_BNO.NEXTVAL, ? ? ?, )";

                System.out.println("No : ");
                String b_no = s.nextLine();
                System.out.println();

                System.out.print("Writer : ");
                String b_writer = s.nextLine();
                System.out.println();

                System.out.println("Date : ");
                String b_date = s.nextLine();
                System.out.println();

                System.out.println("Title : ");
                String b_title = s.nextLine();

                PreparedStatement pstmt = conn.prepareStatement(sql);
                Board board = null;
                pstmt.setString(1, b_no);
                pstmt.setString(2, b_writer);
                pstmt.setString(3, b_date);
                pstmt.setString(4, b_title);
                int rows = pstmt.executeUpdate();
        System.out.println(rows + "개의 게시글이 저장되었습니다.");

                pstmt.close();
                list();
            }

    }