package class_lib1;

public class Constructor_Overloading2_Main {

        public static void main(String[] args) {

            Constructor_Overloading2 csol1 = new Constructor_Overloading2();
            System.out.println("csol1.company : " + csol1.company);
            System.out.println();

            Constructor_Overloading2 csol2 = new Constructor_Overloading2("자가용");
            System.out.println("csol2.company : " + csol2.company);
            System.out.println("csol2.model : " + csol2.model);
            System.out.println();

            Constructor_Overloading2 csol3 = new Constructor_Overloading2("자가용","빨강");
            System.out.println("csol3.company : " + csol3.company);
            System.out.println("csol3.model : " + csol3.model);
            System.out.println("csol3.color : " + csol3.color);
            System.out.println();

            Constructor_Overloading2 csol4 = new Constructor_Overloading2("택시", "검정", 200);
            System.out.println("csol4.company : " + csol4.company);
            System.out.println("csol4.model : " + csol4.model);
            System.out.println("csol4.color : " + csol4.color);
            System.out.println("scol4.maxSpeed : " + csol4.maxSpeed);
            System.out.println();
        }
    }


