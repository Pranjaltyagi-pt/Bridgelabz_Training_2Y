package Array;

public class PrintArray {
    public static void printInc(int arr[],int index){
        if(index==arr.length){
            return;
        }

        System.out.println(arr[index]);
        printInc(arr,index+1);
    }

    static void main(String[] args) {
        int[] arr = {1,3,23,45,56,85};
        printInc(arr,0);
    }
}
