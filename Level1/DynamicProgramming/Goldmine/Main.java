import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] cost = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                cost[i][j]=scn.nextInt();
            }
        }
        System.out.println(goldMine(cost));
    }

    public static int goldMine(int[][] cost){
        int nr = cost.length,nc=cost[0].length;
        int[][] mem = new int[nr][nc];

        int max=0;
        for(int c =nc-1;c>=0;c--){
            for(int r=0;r<nr;r++){
                if(c==nc-1){
                    mem[r][c]=cost[r][c];
                }else if(r==0){
                    mem[r][c]=cost[r][c]+Math.max(mem[r][c+1],mem[r+1][c+1]);
                }else if(r==nr-1){
                    mem[r][c]=cost[r][c]+Math.max(mem[r][c+1],mem[r-1][c+1]);
                }
                else{
                    mem[r][c]=Math.max(mem[r-1][c+1],Math.max(mem[r][c+1],mem[r+1][c+1]))+cost[r][c];
                }
            }
        }

        for(int r =0;r<nr;r++){
            if(max<mem[r][0]){
                max=mem[r][0];
            }
        }

        return max;   
    }
        //2nd Approach

    // public static int goldMine(int[][] cost){
    //     int nr = cost.length,nc=cost[0].length;
    //     int[][] mem = new int[nr][nc];

    //     int max=0;
    //     for(int c =0;c<nc;c++){
    //         for(int r=0;r<nr;r++){
                
    //             if(c==0){
    //                 mem[r][c]=cost[r][c];
    //             }else if(r==0){
    //                 mem[r][c]=cost[r][c]+Math.max(mem[r][c-1],mem[r+1][c-1]);
    //             }else if(r==nr-1){
    //                 mem[r][c]=cost[r][c]+Math.max(mem[r][c-1],mem[r-1][c-1]);
    //             }
    //             else{
    //                 mem[r][c]=Math.max(mem[r-1][c-1],Math.max(mem[r][c-1],mem[r+1][c-1]))+cost[r][c];
    //             }
    //         }
    //     }

    //     for(int r =0;r<nr;r++){
    //         if(max<mem[r][nc-1]){
    //             max=mem[r][nc-1];
    //         }
    //     }

    //     return max;  
    // }

    // public static int goldMine_OptTab(int[][] cost){
    //     int nr = cost.length,nc=cost[0].length;
    //     int[][] dp = new int[nr][2];

    //     int count=0;
    //     for(int c =nc-1;c>=0;c--){
    //         if(count ==2){
    //             dp[]
    //         }
    //     }
    // }

}