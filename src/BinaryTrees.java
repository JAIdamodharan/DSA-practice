public class BinaryTrees {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree{
        static int idx = -1;
        public static TreeNode buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }
    public static void printTree(TreeNode root, int level){
        if(root == null){
            return;
        }
        printTree(root.right, level+1);
        for(int i=0; i < level; i++){
            System.out.print("  ");
        }
        System.out.println(root.data);
        printTree(root.left, level+1);
    }
    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) +  1;
    }
    public static void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    public static void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree.idx = -1;

        TreeNode root = BinaryTree.buildTree(nodes);
        System.out.println("Tree Output: ");
        printTree(root, 0);
        //printTreePretty(root);
        System.out.println("Pre-order: ");
        preOrder(root);
        System.out.println("\nIn-order: ");
        inOrder(root);
        System.out.println("\nPost-order: ");
        postOrder(root);
    }
}
