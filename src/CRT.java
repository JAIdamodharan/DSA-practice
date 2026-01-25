public class CRT {
    public static int calc(int size, int[] div, int[] rem){
        int x = 1;
        while(true){
            int j;
            for(j=0; j<size; j++){
                if(x % div[j] != rem[j]){
                    break;
                }
            }
            if(j == size){
                return x;
            }
            x++;
        }
    }
    public static void main(String[] args) {
        int[] div = {1,2,3};
        int[] rem = {0,0,0};
        System.out.println(calc(3,div,rem));
    }


}
