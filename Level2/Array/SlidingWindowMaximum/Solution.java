import java.util.*;

class Solution {
    
    public int[] NGRE(int[] nums){
        Stack<Integer> st = new Stack<>();
        int[] ngre = new int[nums.length];
        
        for(int i=nums.length-1;i>=0;i--){
            while(st.size()>0 && nums[i]>nums[st.peek()]){
                st.pop();
            }
            
            if(st.size()==0) ngre[i] = nums.length;
            else{
                ngre[i] = st.peek();
            }
            
            st.push(i);
        }
        return ngre;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ngre = NGRE(nums);
        
        int sidx =0,gidx=0;
        int[] ans = new int[nums.length-k+1];
        
        while(sidx<=nums.length-k){
            if(sidx>gidx){
                gidx = sidx;
            }
            
            while(ngre[gidx]<sidx+k){
                gidx = ngre[gidx];
            }
            ans[sidx] = nums[gidx];
            sidx++;
            
        }
        
        return ans;
    }
}