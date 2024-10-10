import java.util.Stack;

class QueueUsingTwoStacks {
    private Stack s1, s2;

    // Constructor
    QueueUsingTwoStacks() {
        s1 = new Stack();
        s2 = new Stack();
    }

    // Enqueue an item to the queue
    public void enqueue(int data) {
        // Push the data into stack s1
        s1.push(data);
    }

    // Dequeue an item from the queue
    public int dequeue() {
        // If both stacks are empty, the queue is empty
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; // Returning -1 to indicate that the queue is empty
        }

        // If s2 is empty, move all elements from s1 to s2
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        // Return the top element from s2
        return s2.pop();
    }

    public static void main(String[] args) {
        int[] keys = {1, 2, 3, 4, 5};
        QueueUsingTwoStacks q = new QueueUsingTwoStacks();

        // Insert keys into the queue
        for (int key : keys) {
            q.enqueue(key);
        }

        // Dequeue and print elements
        System.out.println(q.dequeue()); // print 1
        System.out.println(q.dequeue()); // print 2
    }
}
