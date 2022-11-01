import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=scn.nextInt();
            }
        }

        // System.out.println(minCostMaze_tab(mat));
        // System.out.println(minCostMaze_OptTab(mat));
        // System.out.println(minCostMaze_rec(0,0,mat.length-1,mat[0].length-1,mat));
        int mem[][] = new int[n][m];
        for(int[] ar: mem){
            Arrays.fill(ar,-1);
        }

        System.out.println(minCostMaze_mem(0,0,mat,mem));
       
    }

    public static int minCostMaze_rec(int r,int c,int dr,int dc,int arr[][]){
        if(r==dr && c==dc){
            return arr[r][c];
        }

        int min=Integer.MAX_VALUE;
        if(c+1 <= dc){
            min = Math.min(min,minCostMaze_rec(r,c+1,dr,dc,arr));
        }

        if(r+1 <= dr){
            min = Math.min(min,minCostMaze_rec(r+1,c,dr,dc,arr));
        }

        return min + arr[r][c];
    }

    public static int minCostMaze_mem(int r,int c,int[][] cost,int[][] mem){
        if(r == cost.length-1 && c==cost[0].length-1){
            return mem[r][c]=cost[r][c];
        }
        if(mem[r][c]!=-1){
            return mem[r][c];
        }

        int min = Integer.MAX_VALUE;
        if(c+1 <= cost[0].length-1){
            min = Math.min(min,minCostMaze_mem(r,c+1,cost,mem));
        }
        if(r+1 <= cost.length-1){
            min = Math.min(min,minCostMaze_mem(r+1,c,cost,mem));
        }

        return mem[r][c]=min+cost[r][c];
    }

    public static int minCostMaze_tab(int[][] mat){
        int dr = mat.length,dc=mat[0].length;
        int[][] mem = new int[dr][dc];

        for(int i =dr-1;i>=0;i--){
            for(int j = dc-1;j>=0;j--){
                if(i==dr-1&&j==dc-1){
                    mem[i][j]=mat[i][j];
                }else if(i==dr-1){
                    mem[i][j]=mem[i][j+1]+mat[i][j];
                }else if(j==dc-1){
                    mem[i][j]=mem[i+1][j]+mat[i][j];
                }
                else{
                    mem[i][j]=Math.min(mem[i][j+1],mem[i+1][j])+mat[i][j];
                
                }

            }
        }
        return mem[0][0];

    }

    public static int minCostMaze_OptTab(int mat[][]){
        int nr = mat.length,nc = mat[0].length;
        int dp[][] =new int[2][nc];
        int count=0;

        for(int r = nr-1;r>=0;r--){

            if(count==2){
                dp[1]=dp[0];
                dp[0]=new int[nc];
                count=1;
            }
            for(int c = nc-1;c>=0;c--){
                if(r==nr-1&&c==nc-1){
                    dp[1][c]=mat[r][c];
                }else if(r==nr-1){
                    dp[1][c]= dp[1][c+1]+mat[r][c];
                }
                else if(c==nc-1){
                    dp[0][c]=mat[r][c]+dp[1][c];
                }else{
                    dp[0][c]=mat[r][c]+Math.min(dp[0][c+1],dp[1][c]);
                }
            }
            count++;
        }
        return dp[0][0];
    }

}