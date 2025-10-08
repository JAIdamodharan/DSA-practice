public class BlockSwapRotate {

    // Function to rotate array by d elements
    public static void leftRotate(int[] arr, int d, int n) {
        if (d == 0 || d == n)
            return;
        rotateRec(arr, 0, d, n);
    }

    // Recursive block swap rotation
    private static void rotateRec(int[] arr, int i, int d, int n) {
        // Base cases
        if (d == 0 || d == n)
            return;

        int n_d = n - d;

        // Case 1: A and B are of same size
        if (d == n_d) {
            swap(arr, i, i + d, d);
            return;
        }

        // Case 2: A is shorter
        if (d < n_d) {
            swap(arr, i, i + n_d, d);
            rotateRec(arr, i, d, n_d);
        }
        // Case 3: B is shorter
        else {
            swap(arr, i, i + d, n_d);
            rotateRec(arr, i + n_d, d - n_d, d);
        }
    }

    // Function to swap two blocks of length 'd'
    private static void swap(int[] arr, int fi, int si, int d) {
        for (int i = 0; i < d; i++) {
            int temp = arr[fi + i];
            arr[fi + i] = arr[si + i];
            arr[si + i] = temp;
        }
    }

    // Driver method
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int d = 2;
        int n = arr.length;

        leftRotate(arr, d, n);

        System.out.print("Rotated array: ");
        for (int num : arr)
            System.out.print(num + " ");
    }
}