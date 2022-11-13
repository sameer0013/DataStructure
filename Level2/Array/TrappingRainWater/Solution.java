class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
       
        for(int i=1;i<height.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        int n = height.length;
        
        for(int i=n-2;i>=0;i--){
            rightMax[i]  = Math.max(rightMax[i+1],height[i+1]);
        }
        
        
//         System.out.println(Arrays.toString(leftMax));
//         System.out.println(Arrays.toString(rightMax));
        int ans =0;
        for(int i=0;i<n;i++){
            int min = Math.min(leftMax[i], rightMax[i]);
            int amt = min- height[i];
            if(amt>0) ans+=amt;
        }
        return ans;
    }
}