package jd3;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RomanToInt {

//    I 1
//    V 5
//    X 10
//    L 50
//    C 100
//    D 500
//    M 1000

//    Input: s = "MCMXCIV"
//    Output: 1994

//    IV --> 5
//     VIII--> 8
//    ""--> 0

//    MCXI--> 1111

    public static void main(String[] args) {
        System.out.println(getRomanInteger2("MCMXCIV"));
        System.out.println(getRomanInteger2("MCXI"));
        System.out.println(getRomanInteger2("IV"));
        System.out.println(getRomanInteger2("LVIII"));
        System.out.println(getRomanInteger2("CMXCIV"));
        System.out.println(getRomanInteger2("MMCMLXXXIX"));
    }

    public static int getRomanInteger(String roman) {

        Map<Character, Integer> charIntegerMap = new HashMap<>();
        charIntegerMap.put('M', 1000);
        charIntegerMap.put('D', 500);
        charIntegerMap.put('C', 100);
        charIntegerMap.put('L', 50);
        charIntegerMap.put('X', 10);
        charIntegerMap.put('V', 5);
        charIntegerMap.put('I', 1);

        int result = charIntegerMap.get(roman.charAt(0));

        for (int i = 1; i < roman.length(); i++) {

            char c = roman.charAt(i);
            result += charIntegerMap.get(c);
            int value = charIntegerMap.get(c);
            if (value > charIntegerMap.get(roman.charAt(i - 1))) {
                result -= charIntegerMap.get(roman.charAt(i - 1)) * 2;
            }
        }
        return result;
    }

    public static int getRomanInteger2(String roman) {
//assume valid
        Map<Character, Integer> charIntegerMap =
                Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000);

        int result = charIntegerMap.get(roman.charAt(0));

        for (int i = 1; i < roman.length(); i++) {
            result += charIntegerMap.get(roman.charAt(i));
            int value = charIntegerMap.get(roman.charAt(i));
            int previousValue = charIntegerMap.get(roman.charAt(i - 1));
            if (value > previousValue) { // OPTIMIZE
                result -= previousValue * 2;
            }
        }
        return result;
    }


    /**
     * Fatih
     * @param s
     * @return
     */
        public static int romanToInt(String s) {
            Map<String, Integer> values = new HashMap<>();
            values.put("M", 1000);
            values.put("D", 500);
            values.put("C", 100);
            values.put("L", 50);
            values.put("X", 10);
            values.put("V", 5);
            values.put("I", 1);
            int sum = 0;
            int i = 0;
            while (i < s.length()) {
                String currentSymbol = s.substring(i, i + 1);
                int currentValue = values.get(currentSymbol);
                int nextValue = 0;
                if (i + 1 < s.length()) {
                    String nextSymbol = s.substring(i + 1, i + 2);
                    nextValue = values.get(nextSymbol);
                }
                if (currentValue < nextValue) { // evaluate both current and next
                    sum += (nextValue - currentValue);
                    i += 2; // Double Jump
                }
                else {
                    sum += currentValue;
                    i += 1; // Single Jump
                }
            }
            return sum;
        }

}


/**
 * Problem: Roman to Integer
 * Easy
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol Value
 * I 1
 * V 5
 * X 10
 * L 50
 * C 100
 * D 500
 * M 1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is
 * simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same
 * principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * • I can be placed before V (5) and X (10) to make 4 and 9.
 * • X can be placed before L (50) and C (100) to make 40 and 90.
 * • C can be placed before D (500) and M (1000) to make 400 and 900.
 * <p>
 * Given a roman numeral, convert it to an integer.
 * Example 1:
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * Constraints:
 */