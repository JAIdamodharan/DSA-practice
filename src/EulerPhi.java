import java.util.*;
import java.io.*;

public class EulerPhi {
    public static int phi(int n){
        int res = n;
        for(int p = 2; p*p <=n; p++){
            if(n%p == 0){
                while(n%p == 0){
                    n /= p;
                }
                res -= res/p;
            }
        }
        if(n>1){
            res -= res/n;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(phi(15));
    }
}