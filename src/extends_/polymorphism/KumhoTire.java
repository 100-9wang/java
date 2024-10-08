package extends_.polymorphism;

public class KumhoTire extends Tire {
    //Tire 의 자식클래스

    //필드
    //생성자
    public KumhoTire(String location, int maxRotation){
        super(location, maxRotation);
    }


    //메소드
    @Override
    public boolean roll(){
        ++accmulatedRatation;
        if(accmulatedRatation < maxRotation){
            System.out.println(location + "KumhoTire 수명 : " + (maxRotation - accmulatedRatation) + "회");
            return true;
        } else {
            System.out.println("*** " + location + "KumhoTire 펑크 ***");
            return false;
        }
    }
}

