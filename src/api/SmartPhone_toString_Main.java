package api;

public class SmartPhone_toString_Main {
    public static void main(String[] args) {
        SmartPhone_toString myPhone = new SmartPhone_toString("애플", "ios");


        String strObj = myPhone.toString();
        System.out.println(strObj);

        System.out.println(myPhone);
    }
}
