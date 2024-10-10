class Node{
    int data;
    Node next;
     
    Node(int data){
        this.data = data;
       
      
    }
}

 public class SortlinkedList{
    Node head;
    int size=0;

    void addFront(Node newNode){
        newNode.next = head;
        head = newNode;
    }

    void addFront(int data){
        Node newNode = new Node(data);
        size++;
        newNode.next = head;
        head = newNode;
    }

    void addToBack(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void DisplayList(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    void sort(){
        if(head != null){
            Node temp = head;
            for(int i=1; i<size; i++){
                Node curr = temp;
                while(curr.next != null){
                    if(temp.data > curr.next.data){
                        if(i==1){
                            // Node t = curr.next.next;
                             //curr.next.next = head.next;
                             //Node a = curr.next.next;
                             //curr.next = head;
                             //head= a;
                             //curr.next.next = t;



                        }
                        else{break;}
                    }
                    curr = curr.next;
                }
                temp = temp.next;
            }
        }
        else{
            System.out.println(" LIST_EMPTY");
        }
    }
      
    public static void main(String[] args) {
        SortlinkedList list = new SortlinkedList();
        list.addToBack(5);
        list.addToBack(4);
        list.addToBack(1);
        list.addToBack(2);
        list.addToBack(3);
        list.addToBack(1); 
        System.out.println("Original List:");
        list.DisplayList();    
      
        System.out.println("\n\nAfter sorting:");
        list.sort();
        list.DisplayList();

    }
}