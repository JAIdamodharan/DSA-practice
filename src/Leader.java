public class Leader {
    public static void findLeader(int[] arr){
        int len = arr.length;
        int max = arr[len-1];
        System.out.println(max);
        for(int i=len-2; i>=0; i--){
            if(arr[i] > max){
                max = arr[i];
                System.out.println(max);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2};
        findLeader(arr);
    }
}
