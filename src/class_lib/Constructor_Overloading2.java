package class_lib;

public class Constructor_Overloading2 {

    //필드
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    //생성자
    Constructor_Overloading2() {
    }

    Constructor_Overloading2(String model) {
        this(model,null,0);
    }

    Constructor_Overloading2(String model, String color) {
        this(model,color,0);
    }

    Constructor_Overloading2(String model, String color, int maxSpeed){
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}


