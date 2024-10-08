package interface_;

public class Audio implements Remotecontrol {

    //필드
    private int volume;
    private boolean mute;

    //turnOn() 추상 메소드의 실체 메소드
    public void turnOn() {
        System.out.println("Audio를 켭니다.");
    }

    //turnOff() 추상 메소드의 실체 메소드
    public void turnOff() {
        System.out.println("Audio를 끕니다.");
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
        System.out.println("현재 Audio 볼륨 : " + volume);
    }

    @Override
    public void setMute(boolean mute){
        this.mute = mute;
        if(mute) {
            System.out.println("Audio 무음 처리 합니다.");
        } else {
            System.out.println("Audio 무음 해제 합니다.");
        }
    }
}
