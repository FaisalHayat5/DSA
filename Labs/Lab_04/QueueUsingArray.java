// Class for queue  
class QueueUsingArray {
    private int arr[];
    private int front;
    private int rear;
    private int capacity;
    private int count;

    // Constructor to initialize queue   
    QueueUsingArray(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;  // initially, rear is set to -1 to indicate the queue is empty
        count = 0;  // no elements initially
    }

    // Utility function to remove front element from the queue 
    // and check for Queue Underflow   
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Removing " + arr[front]);
        front = (front + 1) % capacity;  // Circular increment
        count--;  // Decrease the queue size
    }

    // Utility function to add an item to the queue and check 
    // for queue overflow   
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % capacity;  // Circular increment
        arr[rear] = item;
        System.out.println("Inserting " + item);
        count++;  // Increase the queue size
    }

    // Utility function to return front element in the queue and 
    // check for Queue Underflow   
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;  // Return -1 to indicate empty queue
        }
        return arr[front];  // Return front element
    }

    // Utility function to return the size of the queue   
    public int size() {
        return count;  // Return the current size of the queue
    }

    // Utility function to check if the queue is empty or not   
    public Boolean isEmpty() {
        return (count == 0);  // Return true if queue is empty
    }

    // Utility function to check if the queue is full or not   
    public Boolean isFull() {
        return (count == capacity);  // Return true if queue is full
    }


    // main function   
    public static void main(String[] args) {
        // create a queue of capacity 5   
        QueueUsingArray q = new QueueUsingArray(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println("Front element is: " + q.peek());

        q.dequeue();
        System.out.println("Front element is: " + q.peek());

        System.out.println("Queue size is " + q.size());

        q.dequeue();
        q.dequeue();

        if (q.isEmpty())
            System.out.println("Queue Is Empty");
        else
            System.out.println("Queue Is Not Empty");
    }
}
