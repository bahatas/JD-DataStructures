package InterviewQuestionsWithAlumni;

import java.util.Stack;

public class Oracle2 {
    public static void main(String[] args) {
        System.out.println("countBracketSequence(\"()())\") = " + countBracketSequence("()())"));
    }

    public static int countBracketSequence(String s){
        int index = 0, sum = 0;
        if (s.length() == 0){                   // edge case: empty string is also correct
            return 1;
        }
        while (index <= s.length()){
            sum += howManyCorrectSequence(s.substring(0, index) + "(" + s.substring(index))     // "(" adding
                    + howManyCorrectSequence(s.substring(0, index) + ")" + s.substring(index));    // ")" adding
            index++;
        }
        return sum;
    }
    public static int howManyCorrectSequence(String s){         // method to find whether is correct sequence
        int index = 0;
        Stack<Character> stack = new Stack();
        if (s.charAt(index) == ')'){                            // if first char is ")" return 0;
            return 0;
        }
        stack.push(s.charAt(index));                            // first char to stack
        index++;
        while(index < s.length()){
            if (s.charAt(index) == '('){                        // if char is "(", always push to stack
                stack.push(s.charAt(index));
                index++;
                continue;
            }else if (s.charAt(index) == ')'){                  // if char is ")"
                if (stack.empty()){                             // check if stack is empty
                    return 0;                                   // so return 0
                }else if (stack.pop()=='('){
                    index++;
                    continue;
                }
            }
        }
        return stack.empty() ? 1 : 0;                           // however, if stack is not empty, smt wrong so return 0
    }
}
