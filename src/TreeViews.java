import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class TreeViews {

    // LEFT VIEW
    public static void leftView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (i == 0) {
                    System.out.print(node.val + " ");
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
    }

    // RIGHT VIEW
    public static void rightView(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (i == size - 1) {
                    System.out.print(node.val + " ");
                }

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
    }

    // TOP VIEW
    public static void topView(TreeNode root) {
        if (root == null) return;

        class Pair {
            TreeNode node;
            int hd;

            Pair(TreeNode n, int h) {
                node = n;
                hd = h;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            if (!map.containsKey(p.hd)) {
                map.put(p.hd, p.node.val);
            }

            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.hd + 1));
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    // BOTTOM VIEW
    public static void bottomView(TreeNode root) {
        if (root == null) return;

        class Pair {
            TreeNode node;
            int hd;

            Pair(TreeNode n, int h) {
                node = n;
                hd = h;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.put(p.hd, p.node.val); // overwrite

            if (p.node.left != null)
                q.add(new Pair(p.node.left, p.hd - 1));

            if (p.node.right != null)
                q.add(new Pair(p.node.right, p.hd + 1));
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.print("Left View: ");
        leftView(root);

        System.out.print("\nRight View: ");
        rightView(root);

        System.out.print("\nTop View: ");
        topView(root);

        System.out.print("\nBottom View: ");
        bottomView(root);
    }
}