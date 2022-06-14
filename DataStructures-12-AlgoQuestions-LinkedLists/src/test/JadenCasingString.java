package test;

import java.util.Locale;

public class JadenCasingString {


    public static void main(String[] args) {
        System.out.println(getJadenString("How can mirrors be real if our eyes aren't real"));

    }

    public static String getJadenString(String str){
   String result = "";
        for (int i = 0; i <str.length() ; i++) {
            if(str.charAt(i)== ' '){
                String  nextCharAfterSpace = str.substring(i+1,i+2).toUpperCase(Locale.ROOT);
//                str=str.replace( nextCharAfterSpace,nextCharAfterSpace.toUpperCase());
            result+=" "+nextCharAfterSpace;
            i++;
            }else{

                result+=str.substring(i,i+1);
            }
        }
        return result;
    }
}
