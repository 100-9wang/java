package interface_;

public class Misson implements Remotecontrol{
    private int volume;

    /*
    #미션 1 : 활용 클래스에서 볼륨값 5를 넣은 후 출력하는 프로그램을 만드시오.

    #미션 2 : TV를 켜고 볼륨을 0으로 만든 후 출력하고 TV를 끄는 프로그램을 만드시오.
     */


    //turnOn() 추상 메소드의 실체 메소드
    public void turnOn() {
        System.out.println("Smart TV를 켭니다.");
    }

    //turnOff() 추상 메소드의 실체 메소드
    public void turnOff() {
        System.out.println("Smart TV를 끕니다.");
    }

    //setVolume() 추상 메소드의 실체 메소드
    public void setVolume(int volume) {
        if (volume > Remotecontrol.MAX_VOLUME) {
            this.volume = Remotecontrol.MAX_VOLUME;
        } else if (volume < Remotecontrol.MIN_VOLUME) {
            this.volume = Remotecontrol.MIN_VOLUME;
        } else {
            this.volume = volume;
        }

        System.out.println("현재 Smart TV 볼륨 : " + volume);
    }

    public void search(String url){
        System.out.println(url + "을 검색합니다.");
    }
}
