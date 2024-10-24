package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class boards_main {
    public static void main(String[] args) {

        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn  = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "system",
                    "oracle"
            );

            function_boards fuuction = new function_boards(conn);
            fuuction.list();

        }catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        } finally {
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
}
