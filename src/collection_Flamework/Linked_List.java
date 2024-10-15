package collection_Flamework;
import java.util.*;

public class Linked_List {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new LinkedList<String>();

        long startTime;
        long endTime;
        //Array_List
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++){
            list1.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList 걸린시간 : " + (endTime - startTime) + "ns");

        //Linked_List
        startTime = System.nanoTime();
        for (int i = 0; i < 10000; i++){
            list2.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList 걸린시간 : " + (endTime - startTime) + "ns");
    }
}
