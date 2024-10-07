package referenceType;

public class Array_Copy_System {
    public static void main(String[] args) {

        String[] oldStrArr = {"java", "array", "copy"};
        String[] newStrArr = new String[5];

        System.arraycopy(oldStrArr, 0, newStrArr,0,oldStrArr.length);

        for (int i = 0; i < newStrArr.length; i++){
            System.out.print("|" + newStrArr[i] + "| ");
        }
    }
}
