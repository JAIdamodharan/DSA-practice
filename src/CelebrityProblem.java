import java.util.*;

public class CelebrityProblem {
    public static int celebrity(int m[][], int n){
        int top = 0;
        int down = n - 1;
        while(top < down){
            if(m[top][down] == 1){
                top = top + 1;
            } else {
                down = down - 1;
            }
        }
        int candidate = top;
        for(int i=0; i<n; i++){
            //there is no point in checking if I know myself
            if(i != candidate){
                if(m[candidate][i] == 1 || m[i][candidate] == 0){
                    return -1;
                }
            }
        }
        return top;
    }

    public static void main(String[] args) {
        System.out.println("Enter the size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m[][]= new int[n][n];
        for(int i=0; i<n; i++){
            System.out.println("Enter values for row "+i+": ");
            for(int j=0; j<n; j++){
                m[i][j] = sc.nextInt();
            }
        }
        int len = m.length;
        int res = celebrity(m, len);
        if (res == -1){
            System.out.println("No celebrity found");
        } else {
            System.out.println("Celebrity is found at index: "+res);
        }
    }
}
