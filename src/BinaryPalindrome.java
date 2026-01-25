public class BinaryPalindrome {
    public static boolean isBP(int x){
        int original = x;
        int reversed = 0;
        while(x > 0){
            reversed <<= 1;
            reversed |= (x&1);
            x >>= 1;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println(isBP(5));
    }
}
