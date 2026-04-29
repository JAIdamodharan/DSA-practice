public class BinomialHeap {
    class Node {
        int key, degree;
        Node parent, child, sibling;

        public Node(int key) {
            this.key = key;
            degree = 0;
            parent = child = sibling = null;
        }
    }

    Node head;

    // Merge root lists
    private Node merge(Node h1, Node h2) {
        if (h1 == null) return h2;
        if (h2 == null) return h1;

        Node head, tail;

        if (h1.degree <= h2.degree) {
            head = h1;
            h1 = h1.sibling;
        } else {
            head = h2;
            h2 = h2.sibling;
        }

        tail = head;

        while (h1 != null && h2 != null) {
            if (h1.degree <= h2.degree) {
                tail.sibling = h1;
                h1 = h1.sibling;
            } else {
                tail.sibling = h2;
                h2 = h2.sibling;
            }
            tail = tail.sibling;
        }

        tail.sibling = (h1 != null) ? h1 : h2;

        return head;
    }

    // Link two trees
    private void link(Node y, Node z) {
        y.parent = z;
        y.sibling = z.child;
        z.child = y;
        z.degree++;
    }

    // Union operation
    public void union(BinomialHeap heap) {
        head = merge(this.head, heap.head);

        if (head == null) return;

        Node prev = null;
        Node curr = head;
        Node next = curr.sibling;

        while (next != null) {
            if ((curr.degree != next.degree) ||
                    (next.sibling != null && next.sibling.degree == curr.degree)) {
                prev = curr;
                curr = next;
            } else {
                if (curr.key <= next.key) {
                    curr.sibling = next.sibling;
                    link(next, curr);
                } else {
                    if (prev == null)
                        head = next;
                    else
                        prev.sibling = next;

                    link(curr, next);
                    curr = next;
                }
            }
            next = curr.sibling;
        }
    }

    // Insert
    public void insert(int key) {
        BinomialHeap temp = new BinomialHeap();
        temp.head = new Node(key);
        union(temp);
    }

    // Display root list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print("B" + temp.degree + "(" + temp.key + ") ");
            temp = temp.sibling;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinomialHeap heap = new BinomialHeap();

        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.insert(30);

        System.out.print("Binomial Heap: ");
        heap.display();
    }
}