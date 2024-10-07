public class Lab1Ex2 {
    int [] noDup(int arr[][]){
        int a[]=new int [20];
        int index=0;
        for(int i=0;i<arr.length;i++){
            for (int j=0;j<arr[i].length;j++){
                for(int k=0;k<index+1;k++){
                    if(k==index){
                        a[index]=arr[i][j];
                        index++;
                        break;
                    }
                    else if(a[k]==arr[i][j]){
                        break;
                    }
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        Lab1Ex2 ob=new Lab1Ex2();
        int arr[][]={{1,2,3,4,5},{5,6,7,8,9},{9,10,11,12,13},{13,14,15,16,17}};
        int noDup[];
        noDup=ob.noDup(arr);
        for(int i=0;i< noDup.length;i++){
            if(noDup[i]==0){
                continue;
            } else System.out.print(noDup[i]+"  ");
        }
    }
}
