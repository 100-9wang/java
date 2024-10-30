package database;

import java.sql.*;

public class Call_Procedure {
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

            String sql = "{ call user_create(?, ?, ?, ?, ?, ?) }";
            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, "autumn");
            cstmt.setString(2, "한가을");
            cstmt.setString(3, "12345");
            cstmt.setInt(4, 27);
            cstmt.setString(5, "carpediem2001@nate.com");
            cstmt.registerOutParameter(6, Types.INTEGER);

            cstmt.execute();
            int rows = cstmt.getInt(6);
            System.out.println(rows);
            cstmt.close();
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
