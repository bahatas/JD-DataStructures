package algomentor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDif {
    public static void main(String[] args) {
        int[] a = {1,2,2,3,3};
        int[] b = {2, 3};
        System.out.println("a.toString() = " + Arrays.toString(a));
        System.out.println("b.toString() = " + Arrays.toString(b));
        System.out.println("arrayDiff(a, b) = " + Arrays.toString(arrayDiffBruteForce(a, b)));
    }

    public static int[] arrayDiffBruteForce(int[] a, int[] b) {
        if(a.length == 0) return a;
        List<Integer> tempList = new ArrayList<>();
        boolean flag = false;
        for (int elementA : a) {
            for (int elementB : b) {
                if (elementA == elementB) {
                    flag = true;
                    break;
                }
            }
            if(!flag) tempList.add(elementA);
            flag = false;
        }
        int[] result = new int[tempList.size()];
        int index = 0;
        for(int each : tempList){
            result[index] = each;
            index++;
        }
        return result;
    }

    // https://howtodoinjava.com/java8/java8-boxed-intstream/
    public static int[] arrayDiffWithListRemoveAll(int[] a, int[] b) {
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream()
                .mapToInt(e -> e)
                .toArray();
    }

    public static int[] arrayDiffWithStreamFilter(int[] a, int[] b) {
        List<Integer> b1 = Arrays.stream(b).boxed().collect(Collectors.toList());
        return Arrays.stream(a)
                .filter(each -> !b1.contains(each))
                .toArray();
    }

    // https://www.tutorialspoint.com/intstream-nonematch-method-in-java#:~:text=The%20noneMatch()%20method%20in,or%20the%20stream%20is%20empty.
    public static int[] arrayDiffWithIntStream1(int[] a, int[] b) {
        return IntStream.of(a)
                .filter(x -> IntStream.of(b).noneMatch(y -> y == x))
                .toArray();
    }

    public static int[] arrayDiffWithStreamFilter2(int[] a, int[] b) {
        if(a == null || b == null) return a;
        return Arrays.stream(a)
                .filter(elemA -> Arrays.stream(b).noneMatch(elemB -> Objects.equals(elemA, elemB)))
                .toArray();
    }
}
