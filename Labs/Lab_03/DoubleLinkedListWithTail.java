 class DoubleNode {
    String name;
    DoubleNode prev, next;

    DoubleNode(String name) {
        this.name = name;
        this.prev = this.next = null;
    }
}

public class DoubleLinkedListWithTail {
    DoubleNode head, tail;

    public DoubleLinkedListWithTail() {
        head = null;
        tail = null;
    }
    public void insertAtBeginning(String name) {
        DoubleNode newNode = new DoubleNode(name);
        if (head == null) {
            head = tail = newNode;  
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void insertAtEnd(String name) {
        DoubleNode newNode = new DoubleNode(name);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void removeAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;  
        } else {
            head = head.next;
            head.prev = null;
        }}
    public void removeAtEnd() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;  
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    public void printList() {
        DoubleNode temp = head;
        while (temp != null) {
            System.out.print(temp.name + " ");
            temp = temp.next;
        }
        System.out.println();
    }    public static void main(String[] args) {
        DoubleLinkedListWithTail list = new DoubleLinkedListWithTail();
        list.insertAtBeginning("Ismail");
        list.insertAtBeginning("Faheem");
        list.insertAtEnd("Ali");
        list.insertAtEnd("Ahmed");
        System.out.println("After insertions:");
        list.printList();  
        list.removeAtBeginning();
        System.out.println("After removing at beginning:");
        list.printList(); 
        list.removeAtEnd();
        System.out.println("After removing at end:");
        list.printList(); 
    }
}
