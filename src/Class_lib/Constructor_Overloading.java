package Class_lib;

public class Constructor_Overloading {

    //필드
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    //생성자
    Constructor_Overloading() {
    }
        Constructor_Overloading(String model) {
            this.model = model;
        }

        Constructor_Overloading(String model, String color) {
            this.model = model;
            this.color = color;
        }

        Constructor_Overloading(String model, String color, int maxSpeed){
            this.model = model;
            this.color = color;
            this.maxSpeed = maxSpeed;
        }
    }

