public class Infix2PrefixConverter {

    // Function to check if
    // given character is
    // an operator or not.
    static boolean isOperator(Character c) {
        return (!(c >= 'a' && c <= 'z') &&
                !(c >= '0' && c <= '9') &&
                !(c >= 'A' && c <= 'Z'));
    }

    // Function to find priority
    // of given operator.
    static int getPriority(Character C) {
        if (C == '-' || C == '+')
            return 1;
        else if (C == '*' || C == '/')
            return 2;
        else if (C == '^')
            return 3;
        return 0;
    }

    // Function that converts infix
    // expression to prefix expression.
    static String convert2Prefix(String infix) {
        // stack for operators.
        MyStack<Character> operators = new MyStack<Character>();

        // stack for operands.
        MyStack<String> operands = new MyStack<String>();

        for (int i = 0; i < infix.length(); i++) {

            // If current character is an
            // opening bracket, then
            // push into the operators stack.
            if (infix.charAt(i) == (Character) '(') {
                operators.push((Character) infix.charAt(i));
            }

            // If current character is a
            // closing bracket, then pop from
            // both stacks and push result
            // in operands stack until
            // matching opening bracket is
            // not found.
            else if (infix.charAt(i) == ')') {
                while (!operators.isEmpty() &&
                        operators.peek() != (Character) '(') {

                    // operand 1
                    String op1 = operands.peek();
                    operands.pop();

                    // operand 2
                    String op2 = operands.peek();
                    operands.pop();

                    // operator
                    Character op = (Character) operators.peek();
                    operators.pop();

                    // Add operands and operator
                    // in form operator +
                    // operand1 + operand2.
                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                // Pop opening bracket
                // from stack.
                operators.pop();
            }

            // If current character is an
            // operand then push it into
            // operands stack.
            else if (!isOperator(infix.charAt(i))) {
                operands.push(infix.charAt(i) + "");
            }

            // If current character is an
            // operator, then push it into
            // operators stack after popping
            // high priority operators from
            // operators stack and pushing
            // result in operands stack.
            else {
                while (!operators.isEmpty() &&
                        getPriority(infix.charAt(i)) <=
                                getPriority((Character) operators.peek())) {

                    String op1 = operands.peek();
                    operands.pop();

                    String op2 = operands.peek();
                    operands.pop();

                    Character op = (Character) operators.peek();
                    operators.pop();

                    String tmp = op + op2 + op1;
                    operands.push(tmp);
                }

                operators.push(infix.charAt(i));
            }
        }

        // Pop operators from operators
        // stack until it is empty and
        // operation in add result of
        // each pop operands stack.
        while (!operators.isEmpty()) {
            String op1 = operands.peek();
            operands.pop();

            String op2 = operands.peek();
            operands.pop();

            char op = operators.peek();
            operators.pop();

            String tmp = op + op2 + op1;
            operands.push(tmp);
        }

        // Final prefix expression is
        // present in operands stack.
        return operands.peek();
    }
}
