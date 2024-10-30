package reports;

public class teacher {
    private String th_id;
    private String th_pw;
    private String th_class;
    private String th_name;
    private String th_email;


    public String getth_id() {
        return th_id;
    }

    public void setth_id(String th_id) {
        this.th_id = th_id;
    }

    public String getth_pw() {
        return th_pw;
    }

    public void setth_pw(String th_pw) {
        this.th_pw = th_pw;
    }

    public String getth_class() {
        return th_class;
    }

    public void setth_class(String th_class) {
        this.th_class = th_class;
    }

    public String getth_name() {
        return th_name;
    }

    public void setth_name(String th_name) {
        this.th_name = th_name;
    }

    public String getth_email() {
        return th_email;
    }

    public void setth_email(String th_email) {
        this.th_email = th_email;
    }

    @Override
    public String toString() {
        return "teacher{" +
                "th_id='" + th_id + '\'' +
                ", th_pw='" + th_pw + '\'' +
                ", th_class='" + th_class + '\'' +
                ", th_name='" + th_name + '\'' +
                ", th_email='" + th_email + '\'' +
                '}';
    }

}
