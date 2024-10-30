package database;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Select_Board {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "system",
                    "oracle"
                    );
            String sql = ""
                    +"SELECT b_no, b_title, b_content, b_writer, b_date, b_filename, b_filedata "
                    + "FROM boards "
                    + "WHERE b_writer=? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");

            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Board board = new Board();
                board.setB_no(rs.getInt("b_no"));
                board.setB_title(rs.getString("b_title"));
                board.setB_content(rs.getString("b_content"));
                board.setB_writer(rs.getString("b_writer"));
                board.setB_date(rs.getDate("b_date"));
                board.setB_filename(rs.getString("b_filename"));
                board.setB_filedata(rs.getBlob("b_filedata"));
                System.out.println(board);

                Blob blob = board.getB_filedata();
                if (blob != null) {
                    InputStream is = blob.getBinaryStream();
                    OutputStream os = new FileOutputStream("C:/gwangmin/새 폴더/" + board.getB_filename());
                    is.transferTo(os);
                    os.flush();
                    os.close();
                    is.close();
                }
            }
            rs.close();

            pstmt.close();
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
