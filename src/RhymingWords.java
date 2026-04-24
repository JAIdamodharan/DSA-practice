import java.util.*;

public class RhymingWords {

    public static List<String> findRhymingWords(String[] words, String target, int k) {
        List<String> res = new ArrayList<>();

        // Edge case: if target length < k
        if (target.length() < k) {
            return res;
        }

        // Get last k characters of target
        String suffix = target.substring(target.length() - k);

        // Compare with each word
        for (String word : words) {
            if (!word.equals(target) && word.length() >= k) {
                String wordSuffix = word.substring(word.length() - k);

                if (wordSuffix.equals(suffix)) {
                    res.add(word);
                }
            }
        }

        // Sort lexicographically
        Collections.sort(res);

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // number of test cases

        while (t-- > 0) {

            int n = sc.nextInt(); // number of words
            sc.nextLine(); // consume newline

            String[] words = sc.nextLine().split(" ");

            String target = sc.nextLine();

            int k = sc.nextInt();

            List<String> ans = findRhymingWords(words, target, k);

            if (ans.isEmpty()) {
                System.out.println("No Match Found");
            } else {
                for (String word : ans) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
        }

        sc.close();
    }
}