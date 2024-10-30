package database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Board_Insert {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 를 등록
            Class.forName("oracle.jdbc.OracleDriver");

            // 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "oracle"
            );
            System.out.println("연결 성공");

            // 매개변수화 된 SQL문 작성
            String sql = "" + "INSERT INTO boards(b_no, b_title, b_content, b_writer, b_date, b_filename, b_filedata)" +
                    "VALUES(SEQ_B_NO.NEXTVAL, ?, ?, ?, SYSDATE, ?, ?)";

            // PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(
                                       sql, new String[]{"b_no"});
            //b_title
            pstmt.setString(1, "눈오는 날");
            //b_content
            pstmt.setString(2, "함박눈이 내려요");
            //b_writer
            pstmt.setString(3, "winter");
            //b_filename
            pstmt.setString(4, "snow.jpg");
            //b_filedata
            pstmt.setBlob(5, new FileInputStream("C:/gwangmin/새 폴더/snow.jpg"));

            // SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 : " + rows);
            //bno값 얻기
            if(rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if(rs.next()) {
                    int bno= rs.getInt(1);
                    System.out.println("저장된 bno : " + bno);
                }
                rs.close();
            }
            // PreparedStatement 닫기
            pstmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    // 연결 끊기 (자원낭비)
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException e) {}
            }
        }
    }
}


