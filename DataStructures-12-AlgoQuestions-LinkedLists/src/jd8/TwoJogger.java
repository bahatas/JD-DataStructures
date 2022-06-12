package jd8;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class TwoJogger {
    public static void main(String[] args) {
        int[] array = {5,3};
        System.out.println(Arrays.toString(nbrOfLaps(5, 3)));
        System.out.println(Arrays.toString(twoJoggers(array)));
    }

    public static int[] nbrOfLaps(int x, int y){
        int j=1,k=1;
        while (j*x!=y*k){
            if(j*x>y*k) k++;
            else j++;
        }
        return new int[]{j,k};
    }
    public static int[] twoJoggers(int[] array){
        int bobsLaps = array[0];
        int charlesLaps = array[1];
        for(int i=0 ; i<bobsLaps*charlesLaps ; i++){
            if(bobsLaps < charlesLaps) bobsLaps += array[0];
            else charlesLaps += array[1];
            if(bobsLaps == charlesLaps) break;
        }
        return new int[]{bobsLaps/array[0], charlesLaps/array[1]};
    }
    public static int[] findTheLaps(int[] arr){
        int countBob = 1;
        while((arr[0]*countBob) % arr[1] != 0){
            countBob++;
        }
        return new int[] {countBob,arr[0]*countBob/arr[1]};
    }

}
/**
 * Task
 * Your job is to complete the function nbrOfLaps(x, y) that, given the length of the laps for Bob
 * and Charles, finds the number of laps that each jogger has to complete before they meet each
 * other again, at the same time, at the start.
 * The function takes two arguments:
 * 1. The length of Bob's lap (larger than 0)
 * 2. The length of Charles' lap (larger than 0)
 * The function should return an array containing exactly two numbers:
 * 1. The first number is the number of laps that Bob has to run
 * 2. The second number is the number of laps that Charles has to run
 * Examples:
 * nbrOfLaps(5, 3); // returns [3, 5]
 * nbrOfLaps(4, 6); // returns [3, 2]
 */