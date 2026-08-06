package Array.logicbuilding;
import java.util.Scanner;
public class RemoveDuplicate {
    public static void removeduplicate(int arr[]){
        Scanner sc = new Scanner(System.in);
       for(int i=0;i<arr.length;i++){
           for(int j=i+1;j<arr.length;j++){
               if(arr[i]==arr[j]){
                   arr[i]=-1;
                   arr[j]=-1;
               }
           }
       }
       for(int i=0;i<arr.length;i++){
           if(arr[i] == -1){
               System.out.println("not duplicate");
           }
           else {
               System.out.println("duplicate");
           }
       }
    }
    public static void main(String[] args){
        arr[] ={1,2,3,4,3,2,1};
    }
}
