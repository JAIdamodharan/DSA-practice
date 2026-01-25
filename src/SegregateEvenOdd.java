public class SegregateEvenOdd {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to segregate even and odd nodes
    static Node segregateEvenOdd(Node head) {
        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;

        Node curr = head;

        while (curr != null) {
            int val = curr.data;

            if (val % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            }
            curr = curr.next;
        }

        // If there are no even or no odd nodes
        if (evenStart == null)
            return oddStart;
        if (oddStart == null)
            return evenStart;

        evenEnd.next = oddStart;
        oddEnd.next = null;

        return evenStart;
    }

    // Function to print the linked list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {

        // Creating linked list: 17 -> 15 -> 8 -> 12 -> 10 -> 5 -> 4
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        head = segregateEvenOdd(head);

        System.out.println("After Segregating Even and Odd:");
        printList(head);
    }
}