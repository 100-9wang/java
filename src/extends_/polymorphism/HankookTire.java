package extends_.polymorphism;

public class HankookTire extends Tire {
    //Tire 의 자식클래스

    //필드
    //생성자
    public HankookTire(String location, int maxRotation){
        super(location, maxRotation);
    }


    //메소드
    @Override
    public boolean roll(){
        ++accmulatedRatation;
        if(accmulatedRatation < maxRotation){
            System.out.println(location + "HankookTire 수명 : " + (maxRotation - accmulatedRatation) + "회");
            return true;
        } else {
            System.out.println("*** " + location + "HankookTire 펑크 ***");
            return false;
        }
    }
}
