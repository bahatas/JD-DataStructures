

public class StackProblemsMain {

    public static void main(String[] args) {
        System.out.print("Postfix notation of A*(B+C) is : ");
        System.out.print(Infix2PostfixConverter.convert2Postfix(("A*(B+C)")));
        System.out.println();
        System.out.print("Prefix notation of A*(B+C) is : ");
        System.out.print(Infix2PrefixConverter.convert2Prefix(("A*(B+C)")));
    }
}
