import java.util.*;

public class StackPermutations {
    public static boolean isStackPermuted(int[] input, int[] output){
        Stack<Integer> st = new Stack<>();
        int j=0;
        for(int i=0; i<input.length; i++){
            st.push(input[i]);
            while((!st.isEmpty()) && (st.peek() == output[j])){
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5};
        int[] output1 = {4, 5, 3, 2, 1};
        int[] output2 = {3, 1, 2, 5, 4};

        System.out.println("Output1 is stack permutation: " + isStackPermuted(input, output1));
        System.out.println("Output2 is stack permutation: " + isStackPermuted(input, output2));
    }
}
