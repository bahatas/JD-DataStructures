package test;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class JadenCasingString {


    public static void main(String[] args) {
        System.out.println(getJadenString("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase("How can mirrors be real if our eyes aren't real"));
        System.out.println(toJadenCase3(""));

    }

    //without array
    public static String getJadenString(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return "";
        }
        String result = "";
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) == ' ') {
                String nextCharAfterSpace = phrase.substring(i + 1, i + 2).toUpperCase(Locale.ROOT);
                result += " " + nextCharAfterSpace;
                i++;
            } else {
                result += phrase.substring(i, i + 1);
            }
        }
        return result;
    }

    public static String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return "";
        }
        char[] array = phrase.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i - 1] == ' ') {
                array[i] = Character.toUpperCase(array[i]);
            }
        }
        return new String(array);
    }
    public static String toJadenCase3(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return "";
        }else{
            return Arrays.stream(phrase.split(" "))
                    .map(e->e.substring(0,1).toUpperCase()+e.substring(1)+" ")
                    .collect(Collectors.joining()).trim();
        }
    }
}
