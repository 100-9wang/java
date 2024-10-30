package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Procedure {
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
            String sql = "CREATE OR REPLACE PROCEDURE user_create (" +
                    "a_user_id IN users.user_id%TYPE, " +
                    "a_user_name IN users.user_name%TYPE, " +
                    "a_user_pw IN users.user_pw%TYPE, " +
                    "a_user_age IN users.user_age%TYPE, " +
                    "a_user_email IN users.user_email%TYPE, " +
                    "a_rows OUT PLS_INTEGER " +
                    ") " +
                    "IS " +
                    "BEGIN " +
                    "INSERT INTO users (" +
                    "user_id, user_name, user_pw, user_age, user_email" +
                    ") " +
                    "VALUES (" +
                    "a_user_id, a_user_name, a_user_pw, a_user_age, a_user_email " +
                    "); " +
                    "a_rows := SQL%ROWCOUNT; " +
                    "COMMIT; " +
                    "END;";

            // Statement 객체 생성
            Statement stmt = conn.createStatement();

            // SQL 문 실행
            stmt.executeUpdate(sql);
            System.out.println("procedure'이 성공적으로 생성되었습니다.");

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