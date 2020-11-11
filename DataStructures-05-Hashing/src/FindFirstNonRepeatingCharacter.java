import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class FindFirstNonRepeatingCharacter {
    public static void main(String[] args) {
        System.out.println(findFirstNonRepeatingChar("a green apple"));
    }
    public static  char findFirstNonRepeatingChar(@NotNull String str) {
        Map<Character, Integer> map = new HashMap<>();
        int count=0;
        var chars = str.toCharArray();
        for (var ch : chars) {
            if (map.containsKey(ch)) {
                count =map.get(ch);
                map.put(ch, count + 1); // if I have the ch then increase the counter

            } else map.put(ch,1); // if this is the first time  I see this ch then put 1 as count.

        }
        /* Find the first non repeating ch else return min count */
        for (var ch : chars)
            if (map.get(ch) == 1)
                return ch;

        return Character.MIN_VALUE;
    }
}
