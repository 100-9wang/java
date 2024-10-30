package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Function {
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
            String sql ="" + "CREATE OR REPLACE FUNCTION user_login (" +
                    "a_user_id user.user_id%TYPE, " +
                    "a_user_pw user.user_pw%TYPE" +
                    ") " +
                    "RETURN PLS_INTEGER " +
                    "IS " +
                    "v_user_pw user.user_pw%TYPE; " +
                    "v_result PLS_INTEGER; " +
                    "BEGIN " +
                    "SELECT user_pw INTO v_user_pw " +
                    "FROM users " +
                    "WHERE user_id = a_user_id; " +
                    "IF v_user_pw = a_user_pw THEN " +
                    "RETURN 0; " +
                    "ELSE RETURN 1; " +
                    "END IF;" +
                    "EXCEPTION WHEN NO_DATA_FOUND THEN RETURN 2;" +
                    "COMMIT;" +
                    "END;";



            // Statement 객체 생성
            Statement stmt = conn.createStatement();

            // SQL 문 실행
            stmt.executeUpdate(sql);
            System.out.println("Function'이 성공적으로 생성되었습니다.");

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