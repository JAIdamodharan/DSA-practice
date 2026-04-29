public class WinnerTree {

    int[] tree;
    int n;

    public WinnerTree(int[] arr) {
        n = arr.length;
        tree = new int[2 * n];

        // Fill leaves
        for (int i = 0; i < n; i++) {
            tree[n + i] = arr[i];
        }

        // Build tree (bottom-up)
        for (int i = n - 1; i > 0; i--) {
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
    }

    // Get winner (minimum)
    public int getWinner() {
        return tree[1];
    }

    // Update value
    public void update(int index, int value) {
        int i = index + n;
        tree[i] = value;

        // Update upward
        while (i > 1) {
            i /= 2;
            tree[i] = Math.min(tree[2 * i], tree[2 * i + 1]);
        }
    }

    public static void main(String[] args) {

        int[] arr = {20, 15, 30, 10};

        WinnerTree wt = new WinnerTree(arr);

        System.out.println("Winner (Min): " + wt.getWinner());

        // Update element
        wt.update(3, 25); // change 10 → 25

        System.out.println("After Update Winner: " + wt.getWinner());
    }
}