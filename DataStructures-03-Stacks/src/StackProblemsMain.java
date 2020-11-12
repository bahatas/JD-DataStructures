

public class StackProblemsMain {

    public static void main(String[] args) {
        System.out.print("Postfix notation of  D-E   : ");
        System.out.print(Infix2PostfixConverter.convert2Postfix(("D-E")));
        System.out.println();
        /*System.out.print("Prefix notation of A*(B+C) is : ");
        System.out.print(Infix2PrefixConverter.convert2Prefix(("A*(B+C)")));*/
       /* var myStack=new MyStack<Integer>();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.peek());*/

    }
}
