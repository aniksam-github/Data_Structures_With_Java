package dataStructuresAndAlgorithms.ll_apna_college;

public class linked_list {
    static class Node{
        int data;
        Node next;

        // constructor
        public Node(int value){
            this.data = value;
            this.next = null;
        }
    }

    // creating head and tail Node

    public static Node head;
    public static Node tail;
    public static int size;

    // 1. insert node at first/ start

    public void insertAtStart(int value){
        Node newNode = new Node(value);
        size++;
        // first checking either ll is empty or not
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // 2. insert node at last/end

    public void insertAtEnd(int value){
        Node newNode = new Node(value);
        size++;
        if(head == null){
            head = tail = null;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    // 3. printing the linked list

    public void displayLL(){
        // base case
        if(head == null){
            System.out.println("Linked List is empty, first insert the value");
            return;
        }
        Node temp = head;
        while(temp!= null){
            System.out.print(STR."\{temp.data} -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // 5. insert in the middle
    public void insertAtMiddle(int index, int value){
        // if we want to add in the start
        if(index == 0){
            insertAtStart(value);
            return;
        }
        size++;
        Node newNode = new Node(value);
        Node temp = head;
        int i = 0;

        while (i<(index-1)){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // size
    int count = 0;
    public void sizeOfLL(){
        Node temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;

        }
        System.out.println("size of Linked List is: "   + count);
    }

    // deletion

    // 1. delete from fist
    public int deleteAtStart(){
        if(size == 0){
            System.out.println("linked list is empty");
            return Integer.MIN_VALUE; // -infinity OR we can return MAX_VALUE in other words, + infinity.
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // 2. remove from last

    public int deleteAtLast(){
        if(size == 0){
            System.out.println("linked list is empty. Insert the value first");
            return Integer.MIN_VALUE;
        }
        if (size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // we have to traverse till size-2;
        Node temp = head;
        for (int i = 0; i < size-2; i++) {
            temp = temp.next;
        }
        int val = temp.next.data; // storing tail data
        temp.next = null;
        tail= temp;
        size--;
        return val;
    }

    // finding a middle element of a linked list

//    public void middleOfLinkedList(){
//        Node temp = head;
//        int count = 0;
//        int mid = 0;
//        while(temp != null){
//            count++;
//            temp = temp.next;
//        }
//
//        if(count%2 == 0){
//            mid = (count/2) + 1;
//            System.out.println(mid);
//        }
//        else {
//            mid = count / 2;
//            System.out.println(mid);
//        }
//    }

    // searching (iterative)

    public int search(int target){
        Node temp = head;
        int position = 0;
        while(temp != null){
            if(temp.data == target){
                return position;
            }
            temp = temp.next;
            position++;
        }
        // key not found.
        return -1;
    }

/*    // searching (recursive)
    public int helper(Node head, int key){
        if(head == null){
            return -1;
        }
        if (head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
            if (idx == -1) return -1;

        return idx+1;
    }

    public int recSearch(int key){
        return helper(head, key);
    }
*/
    public int recSearch(Node head, int key, int pos){
        // base case
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return pos;
        }
        return recSearch(head.next, key, pos+1);
    }

    // reverse the linked list
    public void reverse(){ // complexity ==> O(n) big OH of n.
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    // Main function
    public static void main(String[] args) {
        linked_list ll = new linked_list();
        ll.insertAtStart(1);
        ll.insertAtEnd(3);
        ll.insertAtStart(2);
        ll.insertAtEnd(4);
        ll.insertAtMiddle(2,10);
        ll.displayLL();
        ll.insertAtMiddle(4,78);
        ll.insertAtMiddle(0,0);
        ll.insertAtMiddle(3, 78);

        ll.displayLL();
        System.out.println(STR."size of the linked list is: \{ll.size}");
        System.out.println("If it prints -1, that means item not present in the linked list");
        System.out.println(STR."where is 78 in the linked list: \{ll.search(78)}");
        System.out.println(STR."where is 56 in the linked list: \{ll.search(56)}");



        System.out.println("where is 56 in the linked list: " + ll.recSearch(head, 56, 0));
        ll.deleteAtLast();
        ll.deleteAtStart();
        ll.sizeOfLL();



//        for(int i=0; i<=6; i++){
//            ll.deleteAtLast();
//            ll.displayLL();
//            System.out.println("size of linked list: " + ll.size);
//        }
//        ll.middleOfLinkedList();


        ll.displayLL();
        ll.reverse();
        ll.displayLL();
    }
}
