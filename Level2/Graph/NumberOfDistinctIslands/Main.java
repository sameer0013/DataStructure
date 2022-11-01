//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        // int count=0;
        HashSet<String> hs = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j,sb);
                    if(!hs.contains(sb.toString())){
                        hs.add(sb.toString());
                        // count++;
                    }
                }
            }
        }
        return hs.size();
    }
    private void dfs(int[][] grid,int r,int c,StringBuilder sb){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0){
            sb.append('.');
            return ;
        }
        grid[r][c]=0;
        dfs(grid,r-1,c,sb.append('u'));
        dfs(grid,r,c+1,sb.append('r'));
        dfs(grid,r+1,c,sb.append('b'));
        dfs(grid,r,c-1,sb.append('l'));
    }
}
