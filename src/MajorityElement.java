public class MajorityElement {
    public static int findMajorityElement(int[] nums) {
        int candidate = -1;
        int count = 0;

        // Step 1: Find candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Step 2: Verify candidate
        for (int num : nums) {
            if (num == candidate) count++;
        }

        if (count > nums.length / 2) {
            return candidate;
        } else {
            return -1; // No majority element
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int majority = findMajorityElement(arr);

        if (majority != -1) {
            System.out.println("Majority Element is: " + majority);
        } else {
            System.out.println("No Majority Element");
        }
    }
}