package api;
import java.util.*;

public class IsNull {
        public static void main(String[] args) {
            String str1 = null;
            String str2 = "hello";

            System.out.println(Objects.isNull(str1));
            System.out.println(Objects.isNull(str2));

            String[] arr = {"Hello", null, "Objects", null, "isNull"};
            long count = Arrays.stream(arr)
                    .filter(Objects::isNull)
                    .count();
            System.out.println("Number of null values: " + count);
        }
    }
