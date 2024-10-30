package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.io.*;

public class Delete_Data {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "oracle"
            );
            String sql ="" + "DELETE FROM boards WHERE b_writer=? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");

            int rows = pstmt.executeUpdate();
            System.out.println("삭제된 행 수 : " + rows);

            pstmt.close();

        } catch (Exception e) {
            System.out.println("클래스 못찾음");
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
