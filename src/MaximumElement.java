public class MaximumElement {
    public static int maxElement(int[] arr){
        int max = arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int secondLargest(int[] arr){
        if(arr.length < 2){
            return -1;
        }
        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0; i < arr.length; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        if(secondLargest == Integer.MIN_VALUE){
            return -1;
        }
        return secondLargest;
    }
    public static void main(String[] args) {
        int[] arr = {10, 50, 70, 80, 13, 17};
        System.out.println(maxElement(arr));
        System.out.println(secondLargest(arr));
    }
}
