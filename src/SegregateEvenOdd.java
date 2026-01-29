class OddEvenLinkedList {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Function to rearrange odd and even indexed nodes
    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;          // 1st node
        ListNode even = head.next;    // 2nd node
        ListNode evenHead = even;     // store start of even list

        while (even != null && even.next != null) {
            odd.next = even.next;     // link odd nodes
            odd = odd.next;

            even.next = odd.next;     // link even nodes
            even = even.next;
        }

        odd.next = evenHead;          // attach even list after odd list
        return head;
    }

    // Utility function to print the linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main function
    public static void main(String[] args) {

        // Example 1: [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original List: ");
        printList(head);

        head = oddEvenList(head);

        System.out.print("Odd-Even List: ");
        printList(head);
    }
}