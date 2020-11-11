
import java.util.*;
public class ExpressionBalanceCheck {

    public static void main(String[] args) {
        System.out.println("Please enter your expression.");
        Scanner scanner=new Scanner(System.in);

        String Exp = scanner.next();
        System.out.println(balanceCheck(Exp));

    }

    public static boolean balanceCheck(String expr){
        MyStack<Character> myStack=new MyStack<Character>();

        for (int i=0; i<expr.length();i++){
            Character ch=expr.charAt(i);
            if (ch != '(' || ch != '[' || ch != '{'|| ch != '}' || ch != ')' || ch != ']') continue;

            if (ch == '(' || ch == '[' || ch == '{')
            {
                // Push the element in the stack
                myStack.push(ch);
                continue;
            }
            // IF current current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (myStack.isEmpty())
                return false;
            char match;
            switch (ch) {
                case ')':
                    match = myStack.pop();
                    if (match == '{' || match == '[')
                        return false;
                    break;

                case '}':
                    match = myStack.pop();
                    if (match == '(' || match == '[')
                        return false;
                    break;

                case ']':
                    match = myStack.pop();
                    if (match == '(' || match == '{')
                        return false;
                    break;
            }
        }
        return (myStack.isEmpty());
    }
}
