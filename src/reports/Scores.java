package reports;

public class Scores {
    private String grades;
    private int korean;
    private int english;
    private int math;
    private int science;
    private int sc_avg;
    private int sc_total;
    private int sc_rank;
    private String sc_st_id;


    public String getSc_st_id() {
        return sc_st_id;
    }

    public void setSc_st_id(String sc_st_id) {
        this.sc_st_id = sc_st_id;
    }



    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public String getGrades() {
        return grades;
    }

    public void setGrades(String grades) {
        this.grades = grades;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSc_avg() {
        return sc_avg;
    }

    public void setSc_avg(int sc_avg) {
        this.sc_avg = sc_avg;
    }

    public int getSc_total() {
        return sc_total;
    }

    public void setSc_total(int sc_total) {
        this.sc_total = sc_total;
    }

    public int getSc_rank() {
        return sc_rank;
    }

    public void setSc_rank(int sc_rank) {
        this.sc_rank = sc_rank;
    }

    @Override
    public String toString() {
        return "Scores{" +
                "grades='" + grades + '\'' +
                ", korean=" + korean +
                ", english=" + english +
                ", math=" + math +
                ", science=" + science +
                ", sc_avg=" + sc_avg +
                ", sc_total=" + sc_total +
                ", sc_rank=" + sc_rank +
                ", sc_st_id='" + sc_st_id + '\'' +
                '}';
    }

}
