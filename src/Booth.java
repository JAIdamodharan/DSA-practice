public class Booth{

    public static long boothMultiply(int multiplicand, int multiplier) {
        int n = 32; // number of bits in int
        long A = 0;          // Accumulator
        long Q = multiplier & 0xFFFFFFFFL; // Multiplier
        long M = multiplicand & 0xFFFFFFFFL; // Multiplicand
        int Q_1 = 0;        // Extra bit for Booth
        int count = n;

        for (int i = 0; i < n; i++) {
            int Q0 = (int)(Q & 1);

            if (Q0 == 1 && Q_1 == 0) {
                A -= M; // Subtract M from A
            } else if (Q0 == 0 && Q_1 == 1) {
                A += M; // Add M to A
            }

            // Arithmetic right shift combined A, Q, Q-1
            long combined = (A << 33) | (Q << 1) | Q_1;
            combined >>= 1;

            // Extract A, Q, Q-1 after shift
            Q_1 = (int)(combined & 1);
            Q = (combined >> 1) & 0xFFFFFFFFL;
            A = combined >> 33;
        }

        // Combine A and Q for final product
        return (A << 32) | Q;
    }

    public static void main(String[] args) {
        int multiplicand = 3;
        int multiplier = -4;
        long product = boothMultiply(multiplicand, multiplier);
        System.out.println("Product: " + product); // Expected -12
    }
}