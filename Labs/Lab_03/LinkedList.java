class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    Node head;
    int size = 0;

    void addFront(int data) {
        Node newNode = new Node(data);
        size++;
        newNode.next = head;
        head = newNode;
    }

    void addToBack(int data) {
        Node newNode = new Node(data);
        size++;
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

    void displayList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    int nthFromLast(int index) {
        if (head == null) {
            System.out.println("LIST_EMPTY");
            return -1;
        }

        if (index > size || index <= 0) {
            System.out.println("Invalid index");
            return -1;
        }

        Node temp = head;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    void reverse() {
        if (head != null) {
            Node prev = null;
            Node current = head;
            Node next = null;
            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        } else {
            System.out.println("LIST_EMPTY");
        }
    }

    void removeDuplicates() {
        if (head != null) {
            Node point = head;

            while (point != null) {
                Node dataCheck = point;
                while (dataCheck.next != null) {
                    if (dataCheck.next.data == point.data) {
                        dataCheck.next = dataCheck.next.next;
                        size--;  // Update the size of the list
                    } else {
                        dataCheck = dataCheck.next;
                    }
                }
                point = point.next;
            }

        } else {
            System.out.println("LIST_EMPTY");
        }
    }

    void sort() {
        if (head != null) {
            for (int i = 0; i < size - 1; i++) {
                Node current = head;
                Node next = head.next;
                for (int j = 0; j < size - 1 - i; j++) {
                    if (current.data > next.data) {
                        int temp = current.data;
                        current.data = next.data;
                        next.data = temp;
                    }
                    current = next;
                    next = next.next;
                }
            }
        } else {
            System.out.println("LIST_EMPTY");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the back
        list.addToBack(10);
        list.addToBack(20);
        list.addToBack(30);
        list.addToBack(40);
        list.addToBack(50);

        System.out.println("Initial List:");
        list.displayList();
        int n = 2;
        System.out.println("The " + n + "th node from the end is: " + list.nthFromLast(n));

        // Sorting the list
        System.out.println("After Sorting:");
        list.sort();
        list.displayList();

        // Adding element to the front
        System.out.println("After Adding 10 to the Front:");
        list.addFront(10);
        list.displayList();

        // Reversing the list
        System.out.println("After Reversing:");
        list.reverse();
        list.displayList();

        // Removing duplicates
        System.out.println("After Removing Duplicates:");
        list.removeDuplicates();
        list.displayList();

        // Getting the 2nd element from the last
        //int n = 2;
        //System.out.println("The " + n + "th node from the end is: " + list.nthFromLast(n));
    }
}
