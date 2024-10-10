public interface List {
    boolean isEmpty();
    int size();
    void add(Object item);
    void add(int index, Object item);
    void remove(int index);
    void remove(Object item);
    List duplicate();
    List duplicate_reverse();
}

class LL implements List {
    private node head;
    private static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public boolean isEmpty() {
        return head == null;
    }
    public int size() {
        int length = 0;
        node curr_node = head;
        while (curr_node != null) {
            curr_node = curr_node.next;
            length++;
        }
        return length;
    }
    public void add(Object item) {
        node new_node = new node((Integer) item);
        if (head == null) {
            head = new_node;
            return;
        }
        node curr_node = head;
        while (curr_node.next != null) {
            curr_node = curr_node.next;
        }
        curr_node.next = new_node;
    }
    public void add(int index, Object item) {
        if (index < 0 || index > size()) {
            System.out.println("Index undefined");
            return;
        }
        node new_node = new node((Integer) item);
        if (index == 0) { // Insert at the head
            new_node.next = head;
            head = new_node;
            return;
        }
        node curr_node = head;
        for (int dis = 0; dis < index - 1; dis++) {
            curr_node = curr_node.next;
        }
        new_node.next = curr_node.next;
        curr_node.next = new_node;
    }
    public void remove(int index) {
        if (head == null) {
            System.out.println(": List is empty :");
            return;
        }
        if (index < 0 || index >= size()) {
            System.out.println("Index undefined");
            return;
        }
        if (index == 0) { // Remove the head
            head = head.next;
            return;
        }
        node curr_node = head;
        for (int dis = 0; dis < index - 1; dis++) {
            curr_node = curr_node.next;
        }
        if (curr_node.next != null) {
            curr_node.next = curr_node.next.next; // Remove the node
        }
    }

   
    public void remove(Object item) {
        if (head == null) {
            System.out.println(": List is empty :");
            return;
        }
        if (head.data == (Integer) item) {
            head = head.next; // Remove head
            System.out.println(item + " is removed from the list");
            return;
        }
        node curr_node = head;
        while (curr_node.next != null) {
            if (curr_node.next.data == (Integer) item) {
                curr_node.next = curr_node.next.next; // Remove the node
                System.out.println(item + " is removed from the list");
                return;
            }
            curr_node = curr_node.next;
        }
        System.out.println(item + " not found in the list");
    }

    public LL duplicate() {
        LL duplist = new LL();
        node curr_node = head;
        while (curr_node != null) {
            duplist.add(curr_node.data);
            curr_node = curr_node.next;
        }
        return duplist;
    }
    public LL duplicate_reverse() {
        LL duplist = new LL();
        node curr_node = head;
        while (curr_node != null) {
            duplist.addFirst(curr_node.data);
            curr_node = curr_node.next;
        }
        return duplist;
    }

    
    public void addFirst(Object item) {
        node new_node = new node((Integer) item);
        new_node.next = head;
        head = new_node;
    }

 
    public void print() {
        node curr_node = head;
        while (curr_node != null) {
            System.out.print(curr_node.data + " ");
            curr_node = curr_node.next;
        }
        System.out.println();
    }

    public static void main(String args[]){

        LL l1 = new LL();
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(3);
        l1.add(6);
        System.out.println("Original list");
        l1.print();

        System.out.println("Duplicate list");
        LL l2 = l1.duplicate();
        l2.print();

        System.out.println("Reversed duplicate list");
        LL l3 = l1.duplicate_reverse();
        l3.print();

        System.out.println("The size is: " + l1.size());

        l1.add(8); 
        l1.add(4); 
        l1.add(2, 8); 
        System.out.println("Size after additions: " + l1.size());
        l1.print();
    }
}
