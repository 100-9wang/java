package iostream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStream_ {
    public static void main(String[] args) throws Exception {
        String originFileName = "C:/gwangmin/Java_/src/flower.jpg";
        String targetFileName = "C:/gwangmin/TestDir/flower.jpg";

        FileInputStream fis = new FileInputStream(originFileName);
        FileOutputStream fos = new FileOutputStream(targetFileName);

        int readByteNo;
        byte[] readBytes = new byte[100];
        while((readByteNo = fis.read(readBytes)) != -1){
            fos.write(readBytes, 0, readByteNo);
        }
        fos.flush();
        fos.close();
        fis.close();

        System.out.println("복사가 정상적으로 실행되었습니다.");
    }

}
