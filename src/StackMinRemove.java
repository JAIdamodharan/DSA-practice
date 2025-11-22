public class StackMinRemove {

    public static String minRemove(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0;

        // First pass: remove invalid ')'
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
                sb.append(c);
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        // Second pass: remove extra '(' from right side
        StringBuilder result = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (ch == '(' && balance > 0) {
                balance--;
            } else {
                result.append(ch);
            }
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "leet(code)((";
        System.out.println(minRemove(a));
    }
}