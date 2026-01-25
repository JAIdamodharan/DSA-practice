import java.util.*;

public class MinStack{
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;

    public MinStack(){
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    //push
    public void push(int val){
        mainStack.push(val);
        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val);
        }
    }

    //pop
    public void pop(){
        if(mainStack.isEmpty()) return;
        int removed = mainStack.pop();
        if(!minStack.isEmpty() && removed == minStack.peek()){
            minStack.pop();
        }
    }

    //top
    public int top(){
        if(mainStack.isEmpty()){
            throw new RuntimeException("empty stack!");
        }
        return mainStack.peek();
    }
    //getMin
    public int getMin(){
        if(minStack.isEmpty()){
            throw new RuntimeException("empty stack!");
        }
        return minStack.peek();
    }
    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(5);
        ms.push(2);
        ms.push(10);
        ms.push(1);

        System.out.println(ms.top());
        System.out.println(ms.getMin());

        ms.pop();

        System.out.println(ms.getMin());

        ms.pop();

        System.out.println(ms.top());
        System.out.println(ms.getMin());

    }
}