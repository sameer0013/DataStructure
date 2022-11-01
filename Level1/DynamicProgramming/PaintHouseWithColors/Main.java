import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int cost[][] = new int[n][k];
        for(int i=0;i<n;i++){
            for(int j=0;j<k;j++){
                cost[i][j]=scn.nextInt();
            }
        }

        // System.out.println(paintHouseColors(cost));
        System.out.println(paintHouseColors_OptTab(cost));

    }

    //time complexcity=O(n*k),spc comp =O(n*k)
    public static int paintHouseColors(int[][] cost){
        int n = cost.length;
        int k = cost[0].length;

        int dp[][] = new int[n][k];
        int min =Integer.MAX_VALUE,smin=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int nmin=Integer.MAX_VALUE,nsmin=Integer.MAX_VALUE;

            for(int c=0;c<k;c++){
                if(i==0){
                    dp[i][c]=cost[i][c];
                    
                }else{
                    if(dp[i-1][c]!= min){
                        dp[i][c]=cost[i][c]+min;
                    }else{
                         dp[i][c]=cost[i][c]+smin;
                    }

                }

                if(nmin > dp[i][c]){
                    nsmin=nmin;
                    nmin=dp[i][c];
                }else if(dp[i][c] < nsmin){
                    nsmin=dp[i][c];
                }

            }

            min=nmin;
            smin=nsmin;
        }

        return min;
    }

    //optimised space comp.
    //time complexcity=O(n*k),spc comp =O(2*k)
    public static int paintHouseColors_OptTab(int[][] cost){
        int n = cost.length;
        int k = cost[0].length;

        int dp[][] = new int[2][k];
        int min =Integer.MAX_VALUE,smin=Integer.MAX_VALUE;
        int count =0;
        for(int i=0;i<n;i++){
            if(count ==2){
                dp[0]=dp[1];
                dp[1]=new int[k];
                count=1;
            }
            int nmin=Integer.MAX_VALUE,nsmin=Integer.MAX_VALUE;

            for(int c=0;c<k;c++){
                if(i==0){
                    dp[i][c]=cost[i][c];
                    
                }else{
                    if(dp[count-1][c]!= min){
                        dp[count][c]=cost[i][c]+min;
                    }else{
                         dp[count][c]=cost[i][c]+smin;
                    }

                }

                if(nmin > dp[count][c]){
                    nsmin=nmin;
                    nmin=dp[count][c];
                }else if(dp[count][c] < nsmin){
                    nsmin=dp[count][c];
                }

            }
            count++;
            min=nmin;
            smin=nsmin;
        }

        return min;
    }
}