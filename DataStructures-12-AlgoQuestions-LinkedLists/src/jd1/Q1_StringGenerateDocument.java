package jd1;

import java.util.concurrent.atomic.AtomicBoolean;

public class Q1_StringGenerateDocument {

    public static void main(String[] args) {

    }

    public static boolean generateDocument2(String givenCharacters, String documents){
        int[] charArray = new int[127];
        for(char c : givenCharacters.toCharArray()){
            if(charArray[c] < 1){
                return false;
            }
            charArray[c]--;
        }
        return true;
    }
    public  static AtomicBoolean checkDocument(String given, String doc) {

        AtomicBoolean result = new AtomicBoolean(false);
        doc.chars().forEach(value -> {
            if ((given.chars().filter(ch -> ch == value).count())>=(doc.chars().filter(ch -> ch == value).count()))
                result.set(true);
            else result.set(false);
        });
        return result;
    }
}
/**
 * Difficulty: Easy Category: Strings
 * You're given a string of available characters and a string representing a document
 * that you need to generate. Write a function that determines if you can generate the
 * document using the available characters. If you can generate the document, your function
 * should return true; otherwise, it should return false. You're only able to generate the
 * document if the frequency of unique characters in the characters string is greater than or
 * equal to the frequency of unique characters in the document string.
 * For example, if you're given characters = "abcabc" and document = "aabbccc" you
 * cannot generate the document because you're missing one c . The document that you need
 * to create may contain any characters, including special characters, capital letters, numbers,
 * and spaces. Note: you can always generate the empty string ( "" ).
 * Sample Input :
 * characters = "!veDJaCyd vaeo perelo xw"
 * document = "Cydeo Java Developer!"
 * Sample Output :
 * true
 */