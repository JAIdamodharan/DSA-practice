import java.util.*;

public class BoundaryTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // BUILD TREE USING LEVEL ORDER INPUT
    public static TreeNode buildTree(Scanner sc) {
        System.out.println("Enter root value (-1 for null): ");
        int val = sc.nextInt();

        if (val == -1) return null;

        TreeNode root = new TreeNode(val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            System.out.println("Enter left child of " + current.val + " (-1 for null): ");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                current.left = new TreeNode(leftVal);
                queue.add(current.left);
            }

            System.out.println("Enter right child of " + current.val + " (-1 for null): ");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                current.right = new TreeNode(rightVal);
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void boundaryTraversal(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");

        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }

    static void printLeftBoundary(TreeNode node) {
        while (node != null) {
            if (!isLeaf(node)) {
                System.out.print(node.val + " ");
            }

            if (node.left != null)
                node = node.left;
            else
                node = node.right;
        }
    }

    static void printRightBoundary(TreeNode node) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.val);
            }

            if (node.right != null)
                node = node.right;
            else
                node = node.left;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void printLeaves(TreeNode node) {
        if (node == null) return;

        if (isLeaf(node)) {
            System.out.print(node.val + " ");
            return;
        }

        printLeaves(node.left);
        printLeaves(node.right);
    }

    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeNode root = buildTree(sc);

        System.out.print("Boundary Traversal: ");
        boundaryTraversal(root);
    }
}