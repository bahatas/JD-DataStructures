package jd1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class Q1_StringGenerateDocument {

    public static void main(String[] args) {
        String characters = "!veDJaCyd vaeo perelo xw";
        String document = "Cydeo Java Developer!";

        String chars = "docudocu"; // true
        String doc = "document"; //false
        System.out.println(isGenerated(characters, document));
        System.out.println(isGenerated(chars, doc));
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

    public static boolean isGenerated(String givenChars, String doc){

        Map<Character, Integer> counterMap = new HashMap<>();

        for(int i =0; i<givenChars.length();i++){
            char character = givenChars.charAt(i);
            counterMap.put(character,counterMap.getOrDefault(character,0)+1);

        }
        for (int i = 0; i <doc.length() ; i++) {
            char character = doc.charAt(i);
            if(!counterMap.containsKey(character) || counterMap.get(character)==0){
                return false;
            }
            counterMap.put(character,counterMap.get(character)-1);
        }
        return true;
    }

    static boolean compareDocument(String characters, String document){

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : characters.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for (char ch : document.toCharArray()){
            if (map.put(ch, map.getOrDefault(ch,0)-1) == -1) return false;
        }
        return true;
    }
// This is my first Solution before using getordefault in map
    public static boolean isGenerated2(String chars, String doc) {
/**
 *
 * O(N) time
 *
 */
        Map<Character, Integer> mapOfDoc = new HashMap<>();
        Map<Character, Integer> mapOfChar = new HashMap<>();

        int lengthOfDoc = doc.length();
        int lengthOfChars = chars.length();
        char charKeyOfMap;
        int freqValOfMap = 1;

        if (lengthOfDoc > lengthOfChars) return false;
        else {
            for (int i = 0; i < lengthOfChars; i++) {
                charKeyOfMap = chars.charAt(i);

                if (!mapOfChar.containsKey(charKeyOfMap))
                    mapOfChar.put(charKeyOfMap, freqValOfMap);
                else {
                    mapOfChar.replace(charKeyOfMap, mapOfChar.get(charKeyOfMap) + 1);
                }
            }

            for (int i = 0; i < lengthOfDoc; i++) {
                charKeyOfMap = doc.charAt(i);

                if (!mapOfDoc.containsKey(charKeyOfMap))
                    mapOfDoc.put(charKeyOfMap, freqValOfMap);
                else {
                    mapOfDoc.replace(charKeyOfMap, mapOfDoc.get(charKeyOfMap) + 1);
                }
            }

            /**
             * get or default method provides better
             */
            try {
                for (char k : mapOfDoc.keySet()) {
                    if (mapOfDoc.get(k) > mapOfChar.get(k))
                        return false;
                }
            } catch (NullPointerException np) {
                return false;
            }
            return true;
//            String a = "";
//            a.concat("abcabc");

        }

//Generate documents
//        public static boolean genDocs(String ch, String docs){
//            List<String> chS = new ArrayList<>(Arrays.asList(ch.split(""))); //n
//            for (String s : docs.split("")) { //n
//                if (chS.contains(s)) chS.remove(s); //n
//                else return false;
//            }
//            return true; //result n2
//        }
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