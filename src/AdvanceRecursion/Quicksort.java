package AdvanceRecursion;
import java.util.*;
public class Quicksort {
    public static void quicksort(int arr[],int start,int end){
        if(start>=end){
            return;
        }
        int pivot = partition(arr,start,end);
        quicksort(arr,start,pivot-1);
        quicksort(arr,pivot+1,end);
    }
    public static int partition(int arr[],int start, int end){
        int pivot = arr[end];
        int i = start-1;

        for(int j=start;j<=end;j++) {
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
            int temp = arr[i+1];
            arr[i+1] = arr[end];
            arr[end] = temp;
            return i+1;
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {2,6,11,4,8,14};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
