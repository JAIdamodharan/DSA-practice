import java.util.*;

public class AddTwoNumbers {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    public static ListNode insert(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        if(head == null){
            return newNode;
        }
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int x = (l1 != null)? l1.val : 0;
            int y = (l2 != null)? l2.val : 0;
            int sum = x+y+carry;
            carry = sum / 10;
            curr.next = new ListNode(sum %10);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode l1 = null;
        ListNode l2 = null;
        while(true){
            int x = sc.nextInt();
            if( x == -1 ) break;
            l1 = insert(l1, x);
        }
        while(true){
            int y = sc.nextInt();
            if ( y == -1 ) break;
            l2 = insert(l2, y);
        }
        printList(l1);
        printList(l2);
        ListNode res = addTwoNumbers(l1,l2);
        printList(res);
    }
}
