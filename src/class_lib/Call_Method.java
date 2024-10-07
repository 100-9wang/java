package class_lib1;

public class Call_Method {
    int speed;

    //생성자 생략

    //캡슐화
    int getSpeed(){
        return speed;
    }


    void keyTurnOn(){
        System.out.println("키를 돌립니다.");
    }

    void run(){
        for(int i = 10; i <= 50; i+=10){
            speed = i;
            System.out.println("달립니다.(시속 : "+ speed +"km/h)");
        }
    }
}
