package iostream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;





public class FileWriter_ {
    private static final Logger logger = Logger.getLogger(FileWriter_.class.getName());
    public static void main(String[] args) {

        try {
            File file = new File("C:/gwangmin/Java_/src/file.txt");
            FileWriter fw = new FileWriter(file, true);
            fw.write("fileWriter는 한글로 된 " + "\r\n");
            fw.write("문자열을 바로 출력할 수 있다." + "\r\n");
            fw.flush();
            fw.close();
            System.out.println("파일에 정상적으로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, "파일 작성 중 오류 발생", e);
        }
    }
}
