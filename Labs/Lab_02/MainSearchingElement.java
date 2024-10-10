
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    Node head;  
    public LinkedList() {
        this.head = null;
    }
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    public boolean search(int key) {
        Node temp = head;  
        while (temp != null) {
            if (temp.data == key) {  
                return true;
            }
            temp = temp.next;  
        }

        return false;  
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class MainSearchingElement {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        System.out.print("Linked List: ");
        list.printList();

        int searchElement = 30;
        if (list.search(searchElement)) {
            System.out.println(searchElement + " is found in the linked list.");
        } else {
            System.out.println(searchElement + " is not found in the linked list.");
        }
        
    }
}
