import java.util.*;
import java.io.*;

public class Striver {
//    public static void printPattern(int n){
//        for(int i=0 ; i<n; i++){
//            for(int j=0 ; j<n; j++){
//                System.out.print("*");
//            }
//            System.out.println();
//        }
//    }
    //For Triangle pattern
    public static void printPattern(int n){
        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        Scanner o1 = new Scanner(System.in);
//        int t = o1.nextInt();
//        for (int i=0 ;i<t; i++){
//            int n = o1.nextInt();
//            printPattern(n);
//        }
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPattern(n);


    }
}
