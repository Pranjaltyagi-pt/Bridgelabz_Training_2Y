package Array.logicbuilding;

public class LargestElement {
    public static int maxvalue(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if (arr[i] > max ) {
                max=arr[i];
            }

        }
        return max;
    }
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7};
                System.out.println("This is the Maximum Number in an Array: " + maxvalue(arr));
    }
}
