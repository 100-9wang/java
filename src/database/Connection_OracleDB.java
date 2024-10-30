package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// oracle jdbc driver 다운 후 외부 라이브러리에 저장해야 함
// oracle 은 포트번호 1521


public class Connection_OracleDB {
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
        } catch (ClassNotFoundException e) {
            System.out.println("클래스 못찾음");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception 발생");
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
