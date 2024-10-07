public class Lab1Ex1 {
    public static void main (String args[]){
        int arr[] ={1,2,3,5,7,2,2,7,8,9};
        int arr2[]=new int[10];
        int j=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2!=0){
                arr2[j]=arr[i];
                j++;
            }

        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2==0){
                arr2[j]=arr[i];
                j++;
            }

        }
        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+"  ");

        }
    }
}
