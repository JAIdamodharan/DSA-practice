import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeightedSubString {

    // Stores weight values for letters A-Z
    static int[] values = new int[26];

    public static void main(String[] args) {
        insertValues(); // Fill weights for letters

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int k = scanner.nextInt();

        List<Character> result = new ArrayList<>();
        generateString(result, k);

        // Print result in correct order
        System.out.print("Generated String: ");
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i));
        }
    }

    // Generates weights for A-Z based on pattern
    static void insertValues() {
        values[0] = 1; // Weight of 'A'
        int prev = 1;

        for (int i = 1; i < 26; i++) {
            values[i] = (i + 1) * prev + prev;
            prev = values[i];
        }
    }

    // Forms the weighted substring representation of k
    static void generateString(List<Character> list, int k) {
        int low = 0;
        int high = 25;

        while (k > 0) {
            int index = findFloor(k, low, high); // Largest weight ≤ k
            list.add((char) (index + 'A'));      // Add corresponding letter
            k -= values[index];                  // Reduce k
        }
    }

    // Binary search to find the largest value <= k
    static int findFloor(int k, int low, int high) {
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (values[mid] <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}