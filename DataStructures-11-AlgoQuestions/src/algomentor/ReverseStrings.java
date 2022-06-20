package algomentor;

public class ReverseStrings {

    public static void main(String[] args) {
        System.out.println("getReverseString(\"the sky is blue\") = " + getReverseString("the sky is blue"));
    }

    
    public static  String getReverseString(String phrase){

        String result = "";
        String word = "";

        for (int i = 0; i <phrase.length() ; i++) {
            
            if(phrase.charAt(i)== ' '){
                result=word+" "+result;
                word="";
                continue;
            }
            word+=phrase.substring(i,i+1);
        }
        return (word+" "+result).trim();
    }
    /**
     * Example 1:
     * Input: s = "the sky is blue"  Output: "blue is sky the"
     * Example 2:
     * Input: s = "  hello world  " Output: "world hello"
     * Explanation: Your reversed string should not contain leading or trailing spaces.
     * Example 3:
     * Input: s = "a good   example"   Output: "example good a"
     * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
     */

}
