package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create_Transaction {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "system",
                    "oracle"
            );
            //트렌젝션 시작 --------------------------------
            //자동커밋 꺼주기
            conn.setAutoCommit(false);

            //출금 작업
            String sql1 = "UPDATE accounts SET balance=balance-? " +
                    "WHERE ano=?";
            PreparedStatement pstsmt1 = conn.prepareStatement(sql1);
            pstsmt1.setInt(1, 10000);
            pstsmt1.setString(2, "111-111-1111");
            int rows1 = pstsmt1.executeUpdate();
            if (rows1 == 0) throw new Exception("출금되지 않았음");
            pstsmt1.close();

            //입금 작업
            String sql2 = "UPDATE accounts SET balance=balance+?" +
                    "WHERE ano=?";
            PreparedStatement pstsmt2 = conn.prepareStatement(sql2);
            pstsmt2.setInt(1, 10000);
            pstsmt2.setString(2, "222-222-2222");
            int rows2 = pstsmt2.executeUpdate();
            if (rows2 == 0) throw new Exception("입금되지 않았음");
            pstsmt2.close();

            //수동 커밋 => 모두 성공 처리
            conn.commit();
            System.out.println("계좌 이체 성공");
            //트렌젝션 종료 --------------------------------
        }catch(Exception e){
                try {
                    //수동 롤백 => 모두 실패 처리
                    conn.rollback();
                } catch (SQLException e1) {}
                System.out.println("계좌 이체 실패");
                e.printStackTrace();
            } finally {
                if(conn != null) {
                    try {
                        //원래대로 자동 커밋 켜주기
                        conn.setAutoCommit(true);
                        conn.close();
                    } catch (SQLException e) {}
                }
            }
        }
    }
