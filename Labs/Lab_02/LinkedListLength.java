class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class LinkedListLength{
    Node head;
    public void Add(int data)
    {
        Node newnde=new Node(data);
        if(head==null)
        {
            head=newnde;
        }
        else
        {
            Node temp=head;
            while (temp.next!=null) {
                temp=temp.next;
            }
            temp.next=newnde;
        }
    }
    public int length()
    {
        int number=0;
        Node temp=head;
        while (temp!=null){
            number++;
            temp=temp.next;
        }
        return number;
    }
    public static void main(String[] args) {
        LinkedListLength list=new LinkedListLength();
        list.Add(3);
        list.Add(4);
        list.Add(5);
        list.Add(6);
        list.Add(7);
        System.out.println("length of this linklist is "+ " "+ list.length());
    }
}