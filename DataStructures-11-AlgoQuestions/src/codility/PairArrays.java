package codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PairArrays {

    public static void main(String[] args) {
        System.out.println("getUniqElements(new int[]{9,3,9,2,3,2,5,6}) = " + Arrays.toString(getUniqElements(new int[]{9, 3, 9, 2, 3, 2, 5, 6})));
    }

    public static int[] getUniqElements(int[] A){

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            if(map.containsKey(number)){
                map.put(number,map.get(number)+1);
            }else{
                map.put(number,1);
            }
//            map.put(number,map.getOrDefault(map.get(number),0)+1);

        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            System.out.println("integerIntegerEntry = " + integerIntegerEntry);
        };
       return map.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue))
               .keySet().stream().mapToInt(Integer::intValue).toArray();




    }
 }
