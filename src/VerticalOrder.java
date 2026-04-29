import java.util.*;

public class VerticalOrder {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Pair {
        TreeNode node;
        int hd;

        Pair(TreeNode n, int h) {
            node = n;
            hd = h;
        }
    }

    public static void verticalOrder(TreeNode root) {
        if (root == null) return;

        // Map: HD → list of nodes
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.putIfAbsent(p.hd, new ArrayList<>());
            map.get(p.hd).add(p.node.val);

            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.hd + 1));
        }

        // Print result
        for (List<Integer> list : map.values()) {
            for (int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \   \
            4   5   6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println("Vertical Order Traversal:");
        verticalOrder(root);
    }
}