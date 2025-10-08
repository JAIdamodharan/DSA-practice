public class Equilibrium {
    public static int getEquilibriumSum(int[] arr){
        int leftSum = 0;
        int totalSum = 0;
        for(int n : arr){
            totalSum += n;
        }
        for(int i=0; i<arr.length; i++){
            totalSum -= arr[i];
            if (totalSum == leftSum){
                return leftSum;
            }
            leftSum += arr[i];
        }
        return leftSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,6,5,6,3,2,1};
        System.out.println(getEquilibriumSum(arr));
    }
}