import java.util.*;

class ChineseRemainder {
    public int calc(int size, int div[], int rem[]) {
        int x = 1;
        while (true) {
            int j;
            for (j = 0; j < size; j++) {
                if (x % div[j] != rem[j]) {
                    break;
                }
            }
            if (j == size) {  // means all conditions satisfied
                return x;
            }
            x++;
        }
    }
}
public class CRT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] div = new int[n];
        for(int i=0; i<n; i++){
            div[i] = sc.nextInt();
        }
        int[] rem = new int[n];
        for(int j=0; j<n; j++){
            rem[j] = sc.nextInt();
        }
        ChineseRemainder c = new ChineseRemainder();
        System.out.println(c.calc(n,div,rem));
    }


}
