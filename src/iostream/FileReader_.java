package iostream;
import java.io.FileReader;
import java.io.IOException;

public class FileReader_ {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("C:/gwangmin/Java_/src/iostream/FileReader_.java");

            int readCharNo;
            char[] cbuf = new char[100];
            while ((readCharNo = fr.read(cbuf)) != -1) {
                String data = new String(cbuf, 0, readCharNo);
                System.out.print(data);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
