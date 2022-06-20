package InterviewQuestionsWithAlumni.week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayDifference {
    public static void main(String[] args) {
        int[] differenceOfArrays = getDifferenceOfArrays(new int[]{1, 2}, new int[]{1});
        System.out.println("Arrays.toString(differenceOfArrays) = " + Arrays.toString(differenceOfArrays));
    }



    public static int[] getDifferenceOfArrays(int[] array1, int[] array2) {
        ArrayList arrayList = new ArrayList();
//        for (int i : array2) {
//            !List.of(array1).contains(i)?arrayList.add(Integer.valueOf());
//        }

//        Stream.concat(Arrays.stream(array1),Arrays.stream(array2))        ;
//        return Arrays.stream(Stream.of(array1, array2).flatMap(Stream::of)
//                .mapToInt().toArray();
//
//        for (int k : array2) {
//            for (int i : array1) {
//                if (i == k) {
//
//                }
//            }
//        }


        return new int[]{};
    }
}
/**
 * Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
 * <p>
 * It should remove all values from list a, which are present in list b keeping their order.
 * <p>
 * Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
 * If a value is present in b, all of its occurrences must be removed from the other:
 * <p>
 * Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */