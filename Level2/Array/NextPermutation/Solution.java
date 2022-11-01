import java.util.*;
class Solution {
    public void reverse(int nums[],int lo,int hi){
        while(lo<hi){
            swap(nums,lo,hi);
            lo++;hi--;
        }
    }
    public void swap(int nums[],int i,int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void nextPermutation(int[] nums) {
        int i=-1;
        for(int idx =nums.length-2;idx>=0;idx--){
            if(nums[idx]<nums[idx+1]) {
                i=idx;
                break;
            }
        }
        
        if(i==-1){
            reverse(nums,0,nums.length-1);
        }else{
            int j=-1;
            for(int idx =nums.length-1;idx>=i;idx--){
                if(nums[idx]>nums[i]){
                    j=idx;
                    break;
                }
            }
            
            swap(nums,i,j);
            reverse(nums,i+1,nums.length-1);
        }
    }
}