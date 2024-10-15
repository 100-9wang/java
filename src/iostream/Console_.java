package iostream;
import java.io.Console;

public class Console_ {
    public static void main(String[] args) {
        Console console = System.console();

        System.out.print("ID : ");
        String id = console.readLine();

        System.out.print("PASSWORD : ");
        char[] charPass = console.readPassword();
        String strPassword = new String(charPass);

        System.out.println("------------------------");
        System.out.println(id);
        System.out.println(strPassword);

    }
}
