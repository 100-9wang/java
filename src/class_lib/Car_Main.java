package class_lib1;

public class Car_Main {
    public static void main(String[] args) {
        //객체 생성
        Car myCar = new Car();

        //필드 값 읽기
        System.out.println("제작 회사 : " + myCar.company);
        System.out.println("모델 : " + myCar.model);
        System.out.println("색상 : " + myCar.color);
        System.out.println("최고속도 : " + myCar.maxSpeed );
        System.out.println("현재속도 : " + myCar.speed);

        //필드 값 변경 해보기
        myCar.speed = 60;
        System.out.println("수정된 속도 : " + myCar.speed);
    }
}
