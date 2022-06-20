package ZtHQuestions.week10;

public class PalindromeString {


    public static void main(String[] args) {
        for (int i = 0; i < 100000000000000l; i++) {
            String myWord = new String("number :"+i);
            System.out.println(isPalindrome("atta"));
        }

    }

    public static boolean isPalindrome(String str){

        int strLength = str.length();
        String reverseStr = "";
        for (int i = strLength-1; i >=0 ; i--) {
            reverseStr+=""+str.toLowerCase().charAt(i);
        }
        if(reverseStr.equals(str.toLowerCase())){
            return true;
        }
        return false;
    }

}
