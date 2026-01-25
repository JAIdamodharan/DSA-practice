public class Floyd {
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static boolean hasCycle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null || fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        // STEP 1: Create nodes with data
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);

        // STEP 2: Link nodes (manually assign next)
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        // STEP 3: Create a cycle manually
        // 50 -> 30
        n5.next = n3;

        Node head = n1;

        // STEP 4: Detect cycle
        if (hasCycle(head)) {
            System.out.println("Cycle detected in the linked list");
        } else {
            System.out.println("No cycle detected in the linked list");
        }
    }
}
