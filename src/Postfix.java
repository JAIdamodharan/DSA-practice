import java.util.Stack;

public class Postfix {
    public static int evaluatePostfix(String exp){
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<exp.length(); i++){
            char ch = exp.charAt(i);
            if(ch == ' '){
                continue;
            }
            if(Character.isDigit(ch)){
                stack.push(ch - '0');
            }
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                switch(ch){
                    case '+':
                        stack.push(operand1+operand2);
                        break;
                    case '-':
                        stack.push(operand1-operand2);
                        break;
                    case '*':
                        stack.push(operand1*operand2);
                        break;
                    case '/':
                        stack.push(operand1/operand2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {

    }
}
