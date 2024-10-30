package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Blob;
import java.io.*;

public class BlobToImg {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "oracle"
            );

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
