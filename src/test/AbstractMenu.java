package test;

import java.util.Scanner;

public abstract class AbstractMenu implements Menu {
    protected Scanner scanner = new Scanner(System.in);
    public void display() {
        // 메뉴를 표시하는 기본적인 로직
    }

}
