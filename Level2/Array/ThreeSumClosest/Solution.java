import java.util.*;
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0;
        int small_ans =Integer.MIN_VALUE,big_ans = Integer.MAX_VALUE;
        while(i<nums.length-1){
            int l =i+1,r=nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum==target) return sum;
                else if(sum<target){
                    small_ans = Math.max(small_ans,sum);     
                    while(nums[l]==nums[++l]&&l<r);
                }else {
                    big_ans = Math.min(big_ans,sum);
                    while(nums[r]==nums[--r]&&l<r);
                }
                
                
            }
            
            while(nums[i]==nums[++i]&&i<nums.length-2);
        }
        
        if(small_ans== Integer.MIN_VALUE) return big_ans;
        else if(big_ans == Integer.MAX_VALUE) return small_ans;
        else{
            if(target-small_ans<big_ans-target) return small_ans;
            else return big_ans;
        }
    }
}