public class StackUsingArray{
    private int array[];
    private int top;
    private int capacity;
    StackUsingArray(int size)
    {
        array =new int[size]; 
        capacity=size;
        top=-1;
    }
    public void push(int x)
    {
      if(top+1<capacity)
      {
        array[++top] = x;
      }
      else{
        System.out.println("Stak is full");
      }
    }
    public int pop()
    {
        if (top<0){
            System.out.println("Stack is underflow");
            return 0;
        }
        else 
        {
            int x=array[top--];
            return x;
        }
    }
    public int top()
    {
        if(top<0)
        {
            System.out.println("Stack is underflow");
            return 0;
        }
        else{
            int x=array[top];
            return x;
        }
    }
    public int size()
    {
        //if(top==-1){
         //   System.out.println(":Stack is underflow:");
         //   return -1;
        //}
        return top+1;
    }
    public boolean isEmpty()
    {
        //boolean b = false;
        return top==-1;
    }
public boolean isFull()
    {
       // boolean b = false;
        return +1==capacity;
    }

    public static void main(String[] args) {
        StackUsingArray stack =new StackUsingArray(3);
        System.out.println("inserting 1");
        stack.push(1);
        System.out.println("inserting 2");
        stack.push(2);
        
        System.out.println("removing " + stack.pop());
        System.out.println("removing " + stack.pop());
        
        System.out.println("inserting 3");
        stack.push(3);

        System.out.println("Top element is " + stack.top());
        System.out.println("Stack size is " + stack.size());

        System.out.println("removing " + stack.pop());
        if(stack.isEmpty())
        {
            System.out.println("stack is empty");
        }
        else{
            System.out.println("Stack is not empty ");
        }

    }
}
