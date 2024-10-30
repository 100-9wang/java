package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection_MysqlDB {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결
            conn = DriverManager.getConnection(
                    "jdbc:mysql:thin//@localhost:3306/servletex",
                    "root",
                    "1234"
            );

            System.out.println("연결 성공");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    //연결 끊어서 자원 낭비 줄이기
                    conn.close();
                    System.out.println("연결 종료");
                } catch (SQLException e) {
                }
            }
        }
    }
}