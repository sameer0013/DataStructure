class Solution {
    public void sortColors(int[] nums) {
        int zcount=0,ocount=0;
        for(int vl:nums){
            if(vl==0) zcount++;
            if(vl==1) ocount++;
        }
        
        int i=0;
        while(i<zcount){
            nums[i]=0;
            i++;
        }
    
        for(int j=0;j<ocount;j++){
            nums[i++] =1;
        }
        
        while(i<nums.length){
            nums[i]=2;
            i++;
        }
        
    }
}