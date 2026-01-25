import java.util.*;

public class NaturalSort {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("A2", "A10", "A1");
        Collections.sort(items, Comparator.comparingInt(s -> Integer.parseInt(s.replaceAll("\\D", ""))));
        System.out.println(items);
    }
}
