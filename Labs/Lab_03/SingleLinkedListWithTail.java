  class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        this.next = null;
    }
}

 public class SingleLinkedListWithTail {
    Node head, tail;

    public SingleLinkedListWithTail() {
        head = null;
        tail = null;
    }
    public void insertAtBeginning(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = tail = newNode; 
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void insertAtEnd(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = tail = newNode;  
        } else {
            tail.next = newNode;
            tail = newNode; 
        }
    }
    public void removeAtBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        head = head.next;  
        if (head == null) {
            tail = null;  
        }
    }
    public void removeAtEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            head = tail = null;  
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;  
            }
            current.next = null;
            tail = current;  
        }
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.name + " ");
            temp = temp.next;
        }
        System.out.println();
    }  public static void main(String[] args) {
        SingleLinkedListWithTail list = new SingleLinkedListWithTail();
        list.insertAtBeginning("Ismail");
        list.insertAtBeginning("Ali");
        list.insertAtEnd("Ahmed");
        list.insertAtEnd("Asad");
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
