public class BinaryTree {
    class Node{
        int data;
        Node left, right;
        Node(int val){
            data = val;
            left = right= null;
        }
    }
    Node root;
    BinaryTree(){
        root = null;
    }
    void insertRoot(int val){
        root = new Node(val);
    }
    void insertLeft(Node parent, int val){
        parent.left = new Node(val);
    }
    void insertRight(Node parent, int val){
        parent.right = new Node(val);
    }
}
