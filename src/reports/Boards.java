package reports;


import java.util.Date;

public class Boards {

    //no get-set
    public int getB_no() {
        return b_no;
    }
    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    //contetn get-set
    public String getB_content() {
        return b_content;
    }
    public void setB_content(String b_content) {
        this.b_content = b_content;
    }

    //writer get-set
    public String getB_writer() {
        return b_writer;
    }
    public void setB_writer(String b_writer) {
        this.b_writer = b_writer;
    }

    //date get-set
    public Date getB_date() {
        return b_date;
    }
    public void setB_date(Date b_date) {
        this.b_date = b_date;
    }

    //title get-set
    public String getB_title() {
        return b_title;
    }
    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    private int b_no;
    private String b_content;
    private String b_writer;
    private Date b_date;
    private String b_title;


    @Override
    public String toString() {
        return "Boards [ 번호 : " + b_no + ", 글쓴이 : " + b_writer + ", 주제 : " + b_content + ", 제목 : " + b_title + ", 날짜 : " + b_date
                + "]";
    }
}

