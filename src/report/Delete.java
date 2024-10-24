package report;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    public static void exit(){
        System.out.println("연결을 종료합니다.");
        System.exit(0);
    }
}
