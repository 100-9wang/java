package import_;

import class_lib1.A;

public class C {
    public C(){

        A a = new A();
        a.field1 = 1;
        //a.field2 = 1; // default 접근자 -> 외부패키지에서 접근 불가
        //a.field3 = 1; // private로 선언 

        a.method1();
        //a.method2(); // default 접근자 -> 외부패키지에서 접근 불가
        //a.method3(); // private로 선언
    }
}
