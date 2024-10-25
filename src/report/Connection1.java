package report;

import java.sql.*;

class Connection1 {
    private Connection conn = null;

    public Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", // URL 수정
                    "system",
                    "oracle"
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void close(PreparedStatement pstmt){
        try {
            pstmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void close(ResultSet rs, PreparedStatement pstmt){
        try {
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            pstmt.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
