package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Blob;
import java.io.*;

public class Update_Data {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "oracle"
            );
            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("b_no=?, ")
                    .append("b_content=?, ")
                    .append("b_filename=?, ")
                    .append("WHERE b_title=?")
                    .toString();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 1);
            pstmt.setString(2, "함박눈이 내려요");
            pstmt.setString(3, "snow.jpg");
            pstmt.setString(4, "눈오는 날");

            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수 : " + rows);

            pstmt.close();

        } catch (ClassNotFoundException e) {
            System.out.println("클래스 못찾음");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println();
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("연결 종료");
                } catch (SQLException e){
                }
            }
        }
    }
}
