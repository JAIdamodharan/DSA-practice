public class QuickSort {
    public static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);

        }
    }
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int lp = low - 1; // lp starts before the range because no element is confirmed as smaller yet.
        for(int rp = low; rp<high; rp++){
            if(arr[rp] < pivot){
                lp++;
                swap(arr, lp, rp);
            }
        }
        swap(arr, lp + 1, high);
        return lp+1;
    }
    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args){
        int[] arr = {1,4,7,89,2};
        System.out.println("Before sorting: ");
        for(int n : arr){
            System.out.print(n + " ");
        }
        quickSort(arr, 0 , arr.length-1);
        System.out.println("\nAfter Sorting: ");
        for(int n : arr){
            System.out.print(n + " ");
        }
    }
}
