package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;



public class User_Insert {
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
            String sql = "" +
                    "INSERT INTO users(user_id, user_name, user_pw, user_age, user_email)" +
                    "VALUES(?, ?, ?, ?, ?)";

            // PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");
            pstmt.setString(2, "한겨울");
            pstmt.setString(3, "12345");
            pstmt.setInt(4, 25);
            pstmt.setString(5, "carpediem2001@nate.com");

            // SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 : " + rows);

            // PreparedStatement 닫기
            pstmt.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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



