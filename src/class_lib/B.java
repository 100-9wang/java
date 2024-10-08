package class_lib;

public class B {
    public B(){
        A a = new A();
        a.field1 = 1;
        a.field2 = 1;
        //a.field3 = 1; // A class에서 private로 선언

        a.method1();
        a.method2();
        //a.method3(); //A class에서 private로 선언
    }
}
