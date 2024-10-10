class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class LinkedListNth {
    Node head;
    int size = 0;

    public void Add(int data) {
        Node newnde = new Node(data);
        if (head == null) {
            head = newnde;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnde;
        }
        size++;
    }

    int nthFromLast(int index) {
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return 0;
        } else if (index > size) {
            System.out.println("Index out of bounds");
            return 0;
        } else {
            Node temp = head;
            for (int i = 0; i < size - index; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public static void main(String[] args) {
        LinkedListNth list = new LinkedListNth();
        list.Add(10);
        list.Add(20);
        list.Add(30);
        list.Add(40);
        list.Add(50);
        System.out.println("From the last, second node contains the data is " + list.nthFromLast(2));
    }
}
