package iostream;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class File_ {
    public static void main(String[] args) throws Exception {
        File dir = new File("C:/gwangmin/Dir");
        File file1 = new File("C:/gwangmin/file1.txt");
        File file2 = new File("C:/gwangmin/file2.txt");
        File file3 = new File("C:/gwangmin/file3.txt");

        if (dir.exists() == false) {dir.mkdirs();}
        if (file1.exists() == false) {file1.createNewFile();}
        if (file2.exists() == false) {file2.createNewFile();}
        if (file3.exists() == false) {file3.createNewFile();}

        File temp = new File("C:/gwangmin");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  a  HH:mm");
        File[] contents = temp.listFiles();
        System.out.println("날짜            시간       형태   크기    이름" );
        System.out.println("----------------------------------------------------------");
        for (File file : contents){
            System.out.print(sdf.format(new Date(file.lastModified())));
            if(file.isDirectory()){
                System.out.print("\t<DIR>\t\t\t" + file.getName());
            } else {
                System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
            }
            System.out.println();
        }
    }
}
