//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            for(int i = 0;i < N;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < N;j++)
                    graph[i][j] = Integer.parseInt(a[j]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.eulerPath(N, graph));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int eulerPath(int N, int graph[][]){
        // code here
        int deg[] = new int[N+1];
        for(int i=0;i<graph.length;i++){
            int[] edges = graph[i];
            for(int j=0;j<edges.length;j++){
                if(edges[j]==1){
                    deg[i+1] += 1;
                }
            }
        }
        // System.out.println(Arrays.toString(deg));
        int ecount =0;
        int ocount =0;
        for(int vl:deg){
            if(vl%2==0) ecount++;
            else ocount++;
        }
        return  (ocount==2)?1:0;
    }
}