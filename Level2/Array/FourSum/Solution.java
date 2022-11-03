package Level2.Array.FourSum;
import java.util.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int i=0;
        while(i<nums.length-3){
            int j=i+1;
            while(j<nums.length-2){
                int l=j+1,r=nums.length-1;
                long target2 = (long) target - nums[i]-nums[j];
                 while(l<r){
                    long sum = nums[l]+nums[r];
                
                     if(sum==target2){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[l],nums[r]);
                        ans.add(list);
                    }
                
                    while(sum<=target2 && nums[l]==nums[++l]&&l<r);
                    while(sum>=target2 && nums[r]==nums[--r]&&l<r);
                }
            
            
            while(nums[j]==nums[++j]&&j<nums.length-1);
            }
            while(nums[i]==nums[++i]&&i<nums.length-1);
        }
        
        return ans;
    }
}
