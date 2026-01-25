class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class MergeSortDLL {

    // Insert node at the end
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) return newNode;

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    // Print the DLL
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Split the DLL into two halves
    static Node split(Node head) {
        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = slow.next;
        slow.next = null;
        if (second != null)
            second.prev = null;

        return second;
    }

    // Merge two sorted DLLs
    static Node merge(Node first, Node second) {
        if (first == null) return second;
        if (second == null) return first;

        if (first.data <= second.data) {
            first.next = merge(first.next, second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }

    // Merge Sort for DLL
    static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node second = split(head);

        head = mergeSort(head);
        second = mergeSort(second);

        return merge(head, second);
    }

    // MAIN FUNCTION
    public static void main(String[] args) {
        Node head = null;

        int[] values = {4, 3, 1, 7, 5};

        for (int val : values)
            head = insert(head, val);

        System.out.println("Original Doubly Linked List:");
        printList(head);

        head = mergeSort(head);

        System.out.println("Sorted Doubly Linked List:");
        printList(head);
    }
}