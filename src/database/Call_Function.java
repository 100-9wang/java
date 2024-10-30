package database;

import java.sql.*;

public class Call_Function {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "oracle"
            );
            System.out.println("연결 성공");

            String sql = "{? = call user_login(?, ?)}";
            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, "winter");
            cstmt.setString(3, "12345");

            cstmt.execute();
            int result = cstmt.getInt(1);
            System.out.println(result);
            cstmt.close();
            String message = switch (result) {
                case 0 -> "로그인 성공";
                case 1 -> "로그인 실패";
                default -> "아이디를 찾을 수 없음";
            };
            System.out.println(message);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
