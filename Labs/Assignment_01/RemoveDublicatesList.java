class Node{
    int data;
    Node next;
     
    Node(int data){
        this.data = data;
       
      
    }
}

 public class RemoveDublicatesList{
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
    void removeDuplicates(){ 
        if(head != null){
            Node point = head;
            
            while(point != null){
                Node dataCheck = point;
                while(dataCheck.next != null){
                    if(dataCheck.next.data == point.data){
                        dataCheck.next = dataCheck.next.next;
                    }
                    else{
                        dataCheck = dataCheck.next;
                    }
                }
                point = point.next;
            }

        }
        else{
            System.out.println("LIST_EMPTY");
        }
    }
    public static void main(String[] args) {
        RemoveDublicatesList list = new RemoveDublicatesList();
        list.addToBack(5);
        list.addToBack(4);
        list.addToBack(1);
        list.addToBack(2);
        list.addToBack(3);
        list.addToBack(1); 
        System.out.println("Original List:");
        list.DisplayList();
        System.out.println("\n\nAfter removing duplicates:");
        list.removeDuplicates();
        list.DisplayList();
    }
}