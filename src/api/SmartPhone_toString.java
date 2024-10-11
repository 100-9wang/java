package api;

public class SmartPhone_toString {
    private String company;
    private String os;

    public SmartPhone_toString(String company, String os){
        this.company = company;
        this.os = os;
    }

    @Override
    public String toString(){
        return company + ", " + os;
    }
}
