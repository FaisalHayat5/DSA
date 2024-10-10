class Node{
    int data;
    Node next;
     
    Node(int data){
        this.data = data;
    }
}

public class ReverseLinklist{
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
    void reverse(){
        if(head != null){
           Node temp = head;
            for(int i=0; i<size/2; i++){
               Node tempLAst =head;
                for(int j=1; j<size-i; j++){
                   tempLAst = tempLAst.next;
               }
               int tempData = temp.data;
               temp.data = tempLAst.data;
               tempLAst.data = tempData;
               temp = temp.next;
            }
        }
        else{
           System.out.println("LIST_EMPTY");
       }
   }
   public static void main(String[] args) {
        ReverseLinklist list = new ReverseLinklist();
    
        // Add elements to the list
        list.addToBack(5);
        list.addToBack(4);
        list.addToBack(1);
        list.addToBack(2);
        list.addToBack(3);
        list.addToBack(1);
        System.out.println("Original List:");
        list.DisplayList();
        System.out.println("\n\nAfter reversing the list:");
        list.reverse();
        list.DisplayList();
   }
}