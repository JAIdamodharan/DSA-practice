import java.util.*;

public class BoundaryTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void boundaryTraversal(TreeNode root) {
        if (root == null) return;

        System.out.print(root.val + " ");

        // Left Boundary
        printLeftBoundary(root.left);

        // Leaf Nodes
        printLeaves(root.left);
        printLeaves(root.right);

        // Right Boundary (reverse)
        printRightBoundary(root.right);
    }

    // LEFT BOUNDARY (excluding leaf)
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

    // RIGHT BOUNDARY (excluding leaf, reverse)
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

    // LEAF NODES
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

        /*
                1
              /   \
             2     3
            / \   / \
           4   5 6   7
              / \
             8   9
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);

        System.out.print("Boundary Traversal: ");
        boundaryTraversal(root);
    }
}