import java.util.*;

public class CelebrityProblem {
    public static int celebrity(int m[][], int n){
        int top = 0;
        int down = n-1;
        while(top < down){
            if(m[top][down] == 1){
                top = top + 1;
            } else {
                down = down - 1;
            }
        }
        int candidate = top;
        for(int i=0; i<n; i++){
            if(i != candidate){
                if(m[candidate][i] == 1 || m[i][candidate] == 0){
                    return -1;
                }
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the matrix: ");
        int n = sc.nextInt();
        int m[][] = new int [n][n];
        for(int i=0; i<n; i++){
            System.out.println("Enter the values for the row "+i+": ");
            for(int j=0; j<n; j++){
                m[i][j] = sc.nextInt();
            }
        }
        int res = celebrity(m,n);
        if(res == -1){
            System.out.println("no celebrity! ");
        } else {
            System.out.println("celebrity is found at index "+res);
        }
    }
}
