 class Node {
    String name;
    Node next,pre;
    Node(String name){
        this.name=name;
        this.next=null;
        this.pre=null;
    }

}

public class Cycle {
    public static Node head;
    public static Node tail;
    public static int size=0;
    public static void Add(String name){
        Node newNode=new Node(name);
        if(head==null){
            head=tail=newNode;
            size++;
        }else {
            tail.next=newNode;
            tail=newNode;
            size++;
        }
    }
    public static void Print(){
        if(head==null){
            System.out.println("Linked list is empty ");
        }else {
            Node temp=head;
            while (temp!=null){
                System.out.println(temp.name+" ");
                temp=temp.next;
            }
        }
    }
    public static void MakeCycle(){
        if (head==null){
            System.out.println(" ");
        }else {
            Node temp=head;
            Node temp1=null;
            while (temp.next!=null){
                temp1=temp;
                temp=temp.next;

            }
            temp.next=temp1;

        }
    }
    public static void Cycle(){
        Node temp=head;
        Node temp1=null;
        int i;
        for(i=1;i<size-1;i++){
            temp1=temp;
            temp=temp.next;
        if(temp1.next==temp.next.next){
            System.out.println("Cycle exists");
            break;
        }}if(i==size-1){
            System.out.println("Cycle does not exist");
}    }    public static void main(String arg[]){
        Add("Ismail");
        Add("Faheem");
        Add("Zohaib");
        Add("Asad ");
        Add("Ali"); 
        Print();
        System.out.println();
        MakeCycle();
        Cycle();
    }
}
