import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<nums.length-2;){
            
            int l=i+1,r=nums.length-1;
           
            while(l<r){
                int sum = nums[i]+ nums[l]+nums[r];
                if(sum==0){
                    
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                   
                }
                
                while(sum<=0 &&(nums[l]==nums[++l])&&l<r);
                while(sum>=0&&(nums[r]==nums[--r])&&l<r);
            }
            
            while(nums[i]==nums[++i] && i<nums.length-1);
        }
        
        return ans;
    }
}