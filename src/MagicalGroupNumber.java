import java.util.*;

public class MagicalGroupNumber {
    public static int digitSum(int n){
        int sum = 0;
        while(n > 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static int countMagicalGroups(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            int sum = digitSum(num);
            if(sum % 3 == 0){
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int cnt = 0;
        for(int freq : map.values()){
            if(freq >= 2){
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();

        }

        System.out.println(countMagicalGroups(arr));

        sc.close();
    }
}
