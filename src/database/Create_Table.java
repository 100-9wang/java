package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Table {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");

            // 데이터베이스 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "oracle"
            );
            System.out.println("연결 성공");

            // CREATE TABLE SQL 문
            String sql = "CREATE TABLE accounts (" +
                    "ano varchar(20) PRIMARY KEY, " +
                    "owner varchar(20) not null, " +
                    "balance number not null " +
                    ")";

            // Statement 객체 생성
            Statement stmt = conn.createStatement();

            // SQL 문 실행
            stmt.executeUpdate(sql);
            System.out.println("테이블 'accounts'가 성공적으로 생성되었습니다.");

            // 자원 해제
            stmt.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("연결 끊기");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}