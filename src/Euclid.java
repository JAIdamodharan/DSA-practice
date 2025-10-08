public class Euclid{
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
    public static int lcm (int a, int b){
        return (a*b) / gcd(a,b);
    }
    public static int gcdArray(int[] arr){
        int res = arr[0];
        for(int i=1; i<arr.length; i++){
            res = gcd(res, arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lcm(48,18));
        int[] arr = {12,14,16,18};
        System.out.println(gcdArray(arr));
    }
}