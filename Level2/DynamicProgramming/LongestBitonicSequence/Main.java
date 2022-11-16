//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] nums)
    {
        // Code here
        int[] lis = LIS(nums);
        int[] revLis = RevLis(nums);
        int ans =0;
        
        for(int i=0;i<nums.length;i++){
            int blen = lis[i]+revLis[i]-1;
            ans = Math.max(ans,blen);
        }
        
        return ans;
    }
    
    public int[] LIS(int[] nums){
        int dp[] = new int[nums.length];
        
        for(int i=0;i<nums.length;i++){
            int maxLen =0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    maxLen = Math.max(maxLen,dp[j]);
                }
            }
            
            dp[i] = maxLen +1;
            
        }
        
        return dp;
    }
    
    public int[] RevLis(int[] nums){
        int dp[] = new int[nums.length];
        
        for(int i=nums.length-1;i>=0;i--){
            int maxLen =0;
            for(int j=i;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    maxLen = Math.max(maxLen,dp[j]);
                }
            }
            
            dp[i] = maxLen +1;
            
        }
        
        return dp;
    }
}