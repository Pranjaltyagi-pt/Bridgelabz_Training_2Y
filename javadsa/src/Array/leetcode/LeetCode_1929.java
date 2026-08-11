package Array.leetcode;
import java.util.*;
public class LeetCode_1929 {
    public  static int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans= new int[2*n];
        int idx=0;
        for(int i=0;i<nums.length;i++){
            ans[idx]=nums[i];
            idx++;
        }
        for(int i=0;i<nums.length;i++){
            ans[idx]=nums[i];
            idx++;
        }
        return ans;
    }
    public static void main(String[] args){
        int[] nums={1,2,3};
        int[] result=getConcatenation(nums);
        System.out.println(Arrays.toString(result));
    }
}
