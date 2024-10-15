package collection_Flamework;
import java.util.*;

public class HashMap_ {
    public static void main(String[] args) {
        //Map 컬렉션 생성
        Map<String, Integer> map = new HashMap<String, Integer>();

        //객체 저장
        map.put("신용권", 85);
        map.put("홍길동", 85);
        map.put("동장군", 85);
        map.put("홍길동", 85);
        System.out.println("총 Entry 수 : " + map.size());

        //객체 찾기
        System.out.println("\t홍길동 : " + map.get("홍길동"));
        System.out.println();

        //객체 하나씩 관리
        Set<String> keySet = map.keySet();
        Iterator<String> keyIterator = keySet.iterator();
        while(keyIterator.hasNext()){
            String key = keyIterator.next();
            Integer val = map.get(key);
            System.out.println("\t" + key + " : " + val);
        }
        System.out.println();

        //객체 삭제
        map.remove("홍길동");
        System.out.println("총 Entry 수 : " + map.size());

        //객체를 하나씩 처리
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> entryIterator = entrySet.iterator();
        while(entryIterator.hasNext()) {
            Map.Entry<String, Integer> entry = entryIterator.next();
            String key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println("\t" + key + " : " + val);
        }
        System.out.println();

        //객체 전체 삭제
        map.clear();
        System.out.println("총 Entry 수 : " + map.size());
        if (map.size() ==  0) {
            System.out.println("Entry가 비어있음");
        }

    }
}
