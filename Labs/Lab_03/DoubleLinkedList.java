 class Node { 
    String name; 
    Node prev, next; 

    Node (String name) { 
        this.prev = null; 
        this.next = null; 
        this.name = name; 
    } 
}    
     public class DoubleLinkedList { 
          Node head;  
    public void insertAtBeginning(String name) { 
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }    // Add node in beginning of linkedlist, node as parameter  
    public void insertAtBeginning(Node node) { 
        if (head == null) {
            head = node;
            node.prev = null;
            node.next = null;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }  // Add node in end of linkedlist, name as parameter   
    public void insertAtEnd(String name) { 
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    } // Add node in end of linkedlist, node as parameter   
    public void insertAtEnd(Node node) { 
        if (head == null) {
            head = node;
            node.prev = null;
            node.next = null;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }   // Add node after name which is provided as param, name and node as params   
    public void insertAfterName(String name, Node node) { 
        Node temp = head;
        while (temp != null && !temp.name.equals(name)) {
            temp = temp.next;
        }
        if (temp != null) {
            node.next = temp.next;
            node.prev = temp;
            if (temp.next != null) {
                temp.next.prev = node;
            }
            temp.next = node;
        }
    } // Add node before name which is provided as param, name and node as params   
    public void insertBeforeName(String name, Node node) { 
        Node temp = head;
        while (temp != null && !temp.name.equals(name)) {
            temp = temp.next;
        }
        if (temp != null) {
            node.prev = temp.prev;
            node.next = temp;
            if (temp.prev != null) {
                temp.prev.next = node;
            } else {
                head = node;
            }
            temp.prev = node;
        }
    } // Make double linkedlist as Circular Double LinkedList   
    public void makeCircular() { 
        if (head != null) {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = head;
            head.prev = temp;
        }
    }  // Print all the nodes in linkedlist, make sure it works on circular double linkedlist   
    public void printAll() { 
        if (head != null) {
            Node temp = head;
            do {
                System.out.print(temp.name + " ");
                temp = temp.next;
            } while (temp != null && temp != head);
        }
    }
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        list.insertAtBeginning("Apple");
        list.insertAtBeginning("Banana ");
        list.insertAtBeginning("Charry");
        list.insertAtEnd("jouice");
        list.insertAtEnd("Mango"); 
        Node fruite = new Node("Fruite");
        list.insertAfterName("Charry", fruite);
        Node grapes = new Node("Grapes");
        list.insertBeforeName("jouice", grapes);

        
       
        list.printAll();
    }
}