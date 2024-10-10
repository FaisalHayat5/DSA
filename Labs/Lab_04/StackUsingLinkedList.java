class Node {
      int data;
      Node next;
  
      Node(int data) {
          this.data = data;
          this.next = null;
      }
  }
  
  public class StackUsingLinkedList {
      private int size;
      Node head;
  
      public StackUsingLinkedList() {
          this.size = 0;
          this.head = null; // Initialize head to null
      }
  
      // Push method to add data to the stack
      public void push(int data) {
          Node node = new Node(data);
          if (head == null) {
              head = node; // If stack is empty, assign node as head
          } else {
              node.next = head; // Link the new node to the current head
              head = node; // Move the head to the new node
          }
          size++;
          System.out.println("Inserting: " + data);
      }
  
      // Utility function to check if the stack is empty or not
      public boolean isEmpty() {
          return head == null; // Stack is empty if head is null
      }
  
      // Peek method to get the top element
      public int peek() {
          if (isEmpty()) {
              throw new RuntimeException("Stack is empty");
          }
          return head.data; // Return the data of the top element
      }
  
      // Pop method to remove top element from the stack
      public void pop() {
          if (isEmpty()) {
              throw new RuntimeException("Stack is empty");
          }
          System.out.println("Removing: " + head.data);
          head = head.next; // Move the head to the next node
          size--;
      }
  
      public static void main(String[] args) {
          StackUsingLinkedList stack = new StackUsingLinkedList();
  
          // Test push operation
         
          stack.push(1);
          
          stack.push(2);
          
          stack.push(3);
  
          // Test peek operation
          System.out.println("Top element is " + stack.peek());
  
          // Test pop operation
         
          stack.pop();
         
          stack.pop();
          
          stack.pop();
  
          // Test if stack is empty
          if (stack.isEmpty()) {
              System.out.print("Stack is empty");
          } else {
              System.out.print("Stack is not empty");
          }
      }
  }
  