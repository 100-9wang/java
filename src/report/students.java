package report;

public class students {
    private String st_id;
    private String st_pw;
    private String st_name;
    private String st_grade;

    public String getst_id() {
        return st_id;
    }

    public void setst_id(String st_id) {
        this.st_id = st_id;
    }

    public String getst_pw() {
        return st_pw;
    }

    public void setst_pw(String st_pw) {
        this.st_pw = st_pw;
    }

    public String getst_grade() {
        return st_grade;
    }

    public void setst_grade(String st_grade) {
        this.st_grade = st_grade;
    }

    public String getst_name() {
        return st_name;
    }

    public void setst_name(String st_name) {
        this.st_name = st_name;
    }

    @Override
    public String toString() {
        return "students{" +
                "st_id='" + st_id + '\'' +
                ", st_pw='" + st_pw + '\'' +
                ", st_name='" + st_name + '\'' +
                ", st_grade='" + st_grade + '\'' +
                '}';
    }
}
