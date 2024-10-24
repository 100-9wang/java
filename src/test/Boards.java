package test;

import java.util.Date;

public class Boards {
    public String getB_no() {
        return b_no;
    }

    public void setB_no(String b_no) {
        this.b_no = b_no;
    }

    public String getB_content() {
        return b_content;
    }

    public void setB_content(String b_content) {
        this.b_content = b_content;
    }

    public String getB_writer() {
        return b_writer;
    }

    public void setB_writer(String b_writer) {
        this.b_writer = b_writer;
    }

    public Date getB_date() {
        return b_date;
    }

    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }

    public String getB_title() {
        return b_title;
    }

    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    private String b_no;
    private String b_content;
    private String b_writer;
    private Date b_date;
    private String b_title;


    @Override
    public String toString() {
        return "Boards [no = " + b_no + ", writer = " + b_writer + ", content = " + b_content + ", title = " + b_title + ", date = " + b_date
                + "]";
    }
}
