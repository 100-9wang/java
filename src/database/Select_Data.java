package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Select_Data {
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
                    "SELECT user_id, user_name, user_pw, user_age, user_email " +
                    "FROM users " +
                    "WHERE user_id=?";

            //PreparedStatement 얻기 및 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");

            //SQL 실행 후, ResultSet을 통해 데이터 읽기
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) { //만약 1개의 데이터 행을 가져왔을 경우
                User user = new User();
                user.setUser_ID(rs.getString("user_id"));
                user.setUser_Name(rs.getString("user_name"));
                user.setUser_PW(rs.getString("user_pw"));
                user.setUser_Age(rs.getInt("user_age"));
                user.setUser_Email(rs.getString("user_email"));
                System.out.println(user);

            } else { //만약 데이터 행을 가져오지 않았을 경우
                System.out.println("사용자의 아이디가 존재 하지 않음");
            }
            rs.close();
            pstmt.close();
        } catch(Exception e) {
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


