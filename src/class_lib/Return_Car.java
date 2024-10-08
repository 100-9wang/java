package class_lib;

public class Return_Car {
    //필드
    int gas;

    //메소드
    void setGas(int gas){  //캡슐화
        this.gas = gas;
    }

    boolean isLeftGas(){
        if(gas == 0) {
            System.out.println("가스가 부족합니다.");
            return false;
        }
        System.out.println("가스가 충분합니다.");
        return true;
    }

    void run(){
        while(true){
            if (gas > 0){
                System.out.println("달립니다. (가스 잔량 : " + gas + ")");
                gas -= 1;
                if (gas == 4){
                    System.out.println("가스가 절반 이하로 내려갔습니다.");
                    System.out.println("주의하세요.");
                }
            } else {
                System.out.println("멈춥니다. (가스 잔량 : " + gas + ")");
                return;
            }
        }
    }
}
