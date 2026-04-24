import java.util.*;

public class MergeSortArray {
    public static void mergeSort(int[] arr, int low, int high){
        if(low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, mid,high);
    }
    public static void merge(int[] arr, int low, int mid, int high){
        int n1 = mid - low + 1;
        int n2 = high - mid;
        //create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        //copy elements into the arrays
        for(int i=0; i<n1; i++){
            L[i] = arr[low + i];
        }
        for(int j=0; j<n2; j++){
            R[j] = arr[mid+1 + j];
        }

        //reset i and j
        int i=0, j=0, k = low;
        //merge both the arrays
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //copy the remaining elements
        while(i < n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr,0, n-1);
        System.out.println(Arrays.toString(arr));
    }
}
