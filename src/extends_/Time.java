package extends_;

class Time {
    /*
    구간이 정해져 있기 때문에 setter를 이용해 유효성 검사를 해야함.
    구간을 넘어서는 수가 들어가면 안됌
    필드의 값을 private 처리하고 값을 바꾸려면 setter-getter를 사용
     */
    private int hour;
    private int minute;
    private int second;

    Time(int hour, int minute, int second){
        setHour(hour);
        setMinute(minute);
        setSecond(second);
    }

    public int getHour() {return hour;}
    public void setHour(int hour) {
        if(hour < 0 || hour > 23) return;
        this.hour = hour;
    }

    public int getMinute() {return minute;}
    public void setMinute(int minute) {
        if(minute < 0 || minute > 59) return;
        this.minute = minute;
    }

    public int getSecond() {return second;}
    public void setSecond(int second) {
        if(second < 0 || second > 59) return;
        this.second = second;
    }


    /*
    Obj class 의 String toString을 재정의 함
    오버라이딩할때 오타 없이 칠 수 있으면 @Override 생략가능
     */
    public String toString(){
        return hour + ":" + minute + ":" + second;
    }
}
