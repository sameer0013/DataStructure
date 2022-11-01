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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //Bellman ford 
        int[] ans = new int[n];
        int[] copy = new int[n];
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[0]=0;
        for(int i=1;i<=n;i++){
            for(int[] edge : edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if(ans[u] != Integer.MAX_VALUE && ans[u]+wt < ans[v]){
                    ans[v] = ans[u]+ wt;
                    
                }
            }
        
            if(i == n-1){
                for(int idx=0;idx<copy.length;idx++)
                {
                    copy[idx] = ans[idx];
                }
            }
        }
        
        for(int i=0;i<copy.length;i++){
            if(copy[i]!=ans[i]) return 1;
        }
        return 0;
    }
}