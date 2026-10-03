package EasyLevel;
import java.util.*;
public class SearchInsertPosition {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i =0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int index = 0;
        int target = sc.nextInt();
        while(index<n && nums[index] < target){
            index++;
        }
        System.out.println(index);
    }
}

