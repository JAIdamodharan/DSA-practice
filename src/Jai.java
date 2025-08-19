public class Jai {
    public static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }
    public static class linkedList{
        private int length;
        private Node head;
        private Node tail;
        public linkedList(int value){
            Node newNode = new Node(value);
            head = newNode;
            tail = newNode;
            length = 1;
        }
        public void getHead(){
            System.out.println("Head: "+head.value);
        }
        public void getTail(){
            System.out.println("Tail: "+tail.value);
        }
        public void getLength(){
            System.out.println("Length: "+length);
        }
        public void append (int value){ //for appending first we will create a new node and if length is 0 then we will change the head and tail if not then we change the tail and tail.next to null also increment the length by one
            Node newNode = new Node(value);
            if (length == 0){
                head = newNode;
                tail = newNode;
            } else{
                tail = newNode;
                tail.next = null;
            }
            length++;
        }
        public void printList(){ // for printing the list we need to take a temp node and set it as head
            Node temp = head;
            while(temp.next != null){
                System.out.println(temp.value);
                temp = temp.next;
            }
        }
        public Node removeLast(){
            if (length == 0) return null;
            Node temp = head;
            Node pre = head;
            while(temp.next != null){
                pre = temp;
                temp = temp.next;
            }
            tail = pre;
            tail.next = null;
            length--;
            if (length == 0){
                head = null;
                tail = null;
            }
            return temp;
        }
    }
}
