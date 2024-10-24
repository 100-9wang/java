package test;

import java.sql.*;
import java.util.Scanner;

public class function_boards {
Scanner s = new Scanner(System.in);
    private Connection conn;

    // 생성자 추가
    public function_boards(Connection conn) {
        this.conn = conn;
    }

    public void list() {
        System.out.println("[ 광민 게시판 ]");
        System.out.println("----------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-25s%-40s\n", "No", "Writer", "Content", "Title", "Date");
        System.out.println("----------------------------------------------");

        try {
            String sql ="" + "SELECT b_no, b_writer, b_content, b_title, b_date FROM boards ";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Boards boards = new Boards();
                boards.setB_no(rs.getString("b_no"));
                boards.setB_writer(rs.getString("b_writer"));
                boards.setB_content(rs.getString("b_content"));
                boards.setB_date(rs.getDate("b_date"));
                boards.setB_title(rs.getString("b_title"));
                System.out.printf("%-6s%-12s%-16s%-25s%-40s\n",
                        boards.getB_no(),
                        boards.getB_writer(),
                        boards.getB_content(),
                        boards.getB_date(),
                        boards.getB_title());
            }
            //늦게 열었떤거 먼저 닫고
            rs.close();
            //그앞에꺼 닫기
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        main_menu();
    }

    public void main_menu(){
        System.out.println("----------------------------------------------");
        System.out.println("메인 메뉴 : 1. 게시글 생성 | 2. 게시글 수정 | 3. 게시글 삭제 | 0. 종료");
        System.out.print("메뉴를 선택하세요 : ");
        String inputNum = s.nextLine();
        System.out.println("----------------------------------------------");

        switch(inputNum) {
            case "1" :
                create();
                list();
                break;
            case "2" :
                update();
                list();
                break;
            case "3" :
                delete();
                list();
                break;
            case "0" :
                exit();
                list();
                break;
        }
    }

    public void exit(){
        System.out.println("게시판 프로그램을 종료합니다.");
        System.exit(0);
    }
    
    public void create() {
    Boards boards = new Boards();

        System.out.println("게시물 생성을 선택하셨습니다.");
        System.out.print("No : ");
        boards.setB_no(s.nextLine());
        System.out.print("Writer : ");
        boards.setB_writer(s.nextLine());
        System.out.print("Contents : ");
        boards.setB_content(s.nextLine());
//        System.out.print("Date : ");
//        boards.setB_date(s.nextLine());
        System.out.print("Title : ");
        boards.setB_title(s.nextLine());

        try {
            String sql = "" + "INSERT INTO boards ( b_no, b_content, b_writer, b_date, b_title) "
                    + "VALUES (?, ?, ?, SYSDATE, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boards.getB_no());
            pstmt.setString(2, boards.getB_content());
            pstmt.setString(3, boards.getB_writer());
            pstmt.setString(4, boards.getB_title());

            pstmt.executeUpdate();
            //나중에 연거 먼저 닫기
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update() {
        Boards boards = new Boards();

        System.out.println("게시물 수정하기를 선택하셨습니다.");
        System.out.print("No : ");
        boards.setB_no(s.nextLine());
        System.out.println("Writer : ");
        boards.setB_writer(s.nextLine());
        System.out.println("Contents : ");
        boards.setB_content(s.nextLine());
        System.out.println("Title : ");
        boards.setB_title(s.nextLine());

        try {
            String sql = "" + "UPDATE boards SET b_no = ?, b_writer =?, b_content = ?, b_title = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boards.getB_no());
            pstmt.setString(2, boards.getB_writer());
            pstmt.setString(3, boards.getB_content());
            pstmt.setString(4, boards.getB_title());
            pstmt.executeUpdate();

            pstmt.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        Boards boards = new Boards();

        try {
            String sql = "" + "DELETE FROM boards "
                    + "WHERE b_no = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, boards.getB_no());
            pstmt.executeUpdate();

            pstmt.close();

        }catch(Exception e ) {
            e.printStackTrace();
        }
    }
}
