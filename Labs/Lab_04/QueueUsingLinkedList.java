//A linked list node   
 class Node 
{ 
    int data;       // integer data   
    Node next;      // pointer to the next node   
 
    public  Node(int data) 
    { 
        // set the data in allocated node and return the node   
        this.data = data; 
        this.next = null; 
    } 
} 
 
public class QueueUsingLinkedList 
{ 
    private static Node rear = null, front = null; 
 
    // Utility function to remove front element from the queue and check for Queue Underflow   
    public static int dequeue()     // delete at the beginning   
    { 
        if(isEmpty())
        {
            System.out.println("Queue is UnderFlow:");
            return -1;
        }
        int frontData=front.data;
        front =front.next;
        if(front == null){
            rear=null;
        }
        return frontData;
    } 
 
    // Utility function to add an item in the queue   
    public static void enqueue(int item)    // insertion at the end   
    { 
        Node node=new Node( item);
        if(rear==null)
        {
            front=rear=node;
            return ;
           
        }
        rear.next=node;
        rear=node;

    } 
 
    // Utility function to return top element in a queue   
    public static int peek() 
    { 
       if(isEmpty()){
        System.out.println("Queue is Empty:");
        return -1;
       }
       return front.data;
    } 
 
    // Utility function to check if the queue is empty or not   
    public static boolean isEmpty() 
    { 
       return front==null; 
    } 

 
 
    public static void main(String[] args) 
    { 
        QueueUsingLinkedList q = new QueueUsingLinkedList(); 
        System.out.println("Inserting 1:");

        q.enqueue(1); 
        System.out.println("Inserting 2");
        q.enqueue(2); 
        System.out.println("inserting 3");
        q.enqueue(3); 
        System.out.println("inserting 4");
        q.enqueue(4); 
 
        System.out.printf("Front element is %d\n", q.peek()); 
         System.out.println("Removing 1");
        q.dequeue();
        System.out.println("removing 2"); 
        q.dequeue(); 
        System.out.println("removing 3");
        q.dequeue(); 
        System.out.println("removing 4");
        q.dequeue(); 
 
        if (q.isEmpty()) { 
            System.out.print("Queue is empty"); 
        } else { 
            System.out.print("Queue is not empty"); 
        } 
    } 
} 