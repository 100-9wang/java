package report;

import java.util.Date;
import java.sql.Blob;


public class Board {

    private int b_no;
    private String b_title;
    private String b_content;
    private String b_writer;
    private Date b_date;

    // b_no set-get
    public int getB_no() {
        return b_no;
    }
    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    // b_title set-get
    public String getB_title() {
        return b_title;
    }
    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    // b_content set-get
    public String getB_content() {
        return b_content;
    }
    public void setB_content(String b_content) {
        this.b_content = b_content;
    }

    // b_writer set-get
    public String getB_writer() {
        return b_writer;
    }
    public void setB_writer(String b_writer) {
        this.b_writer = b_writer;
    }

    // b_date set-get
    public Date getB_date() {
        return b_date;
    }
    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }


    @Override
    public String toString(){
        return String.format("번호 : " + this.b_no + "\n"
                + "글쓴이 : " + this.b_writer + "\n"
                + "날짜 : " + this.b_date + "\n"
                + "주제 : " + this.b_title + "\n"
        );
    }
}
