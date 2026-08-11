package Array.leetcode;

import java.util.Arrays;

public class LeetCode_238 {
    public  static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int left[]=new int[n];
    int right[] = new int[n];
    left[0]=1;
    for(int i=1;i<nums.length;i++){
        left[i]=left[i-1]*nums[i-1];
    }
    right[n-1]=1;
    for(int i=nums.length-2;i>-1;i--){
        right[i]=right[i+1]*nums[i+1];
    }
    int ans[]= new int[n];
    for(int i=0;i<ans.length;i++){
        ans[i]=left[i]*right[i];
    }
    return ans;
  }
  public static void main(String[] args){
        int[] nums={1,2,3,4};
        int[] result=productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
  }
}

