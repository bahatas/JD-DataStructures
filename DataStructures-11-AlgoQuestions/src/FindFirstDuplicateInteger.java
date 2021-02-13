import java.util.HashSet;
import java.util.Set;

public class FindFirstDuplicateInteger {
    public int findDuplicate(int[] array) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int number : array) {
            if (seen.contains(number)) {
                return number;
            }
            seen.add(number);
        }

        return -1;
    }
}
