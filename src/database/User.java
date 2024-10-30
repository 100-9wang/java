package database;

public class User {
    private String user_ID;

    private String user_Name;

    private String user_PW;

    private int user_Age;

    private String user_Email;


    // ID get-set
    public String getUser_ID() {
        return user_ID;
    }
    public void setUser_ID(String user_ID) {
        this.user_ID = user_ID;
    }

    // Name get-set
    public String getUser_Name() {
        return user_Name;
    }
    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    // PW get-set
    public String getUser_PW() {
        return user_PW;
    }
    public void setUser_PW(String user_PW) {
        this.user_PW = user_PW;
    }

    // Age get-set
    public int getUser_Age() {
        return user_Age;
    }
    public void setUser_Age(int user_Age) {
        this.user_Age = user_Age;
    }

    // Email get-set
    public String getUser_Email() {
        return user_Email;
    }
    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }

    @Override
    public String toString(){
        return String.format("아이디 : " + this.user_ID + "\n"
                + "이름 : " + this.user_Name + "\n"
                + "비밀번호 : " + this.user_PW + "\n"
                + "나이 : " + this.user_Age + "\n"
                + "이메일 : " + this.user_Email);
    }

}