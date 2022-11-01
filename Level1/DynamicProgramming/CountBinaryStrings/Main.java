import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(countBinaryString_tab(n));
 }

public static int countBinaryString_tab(int n){
    int dp[][] = new int[2][n+1];
    for(int c=1;c<=n;c++){
        if(c==1){
            dp[0][c]=dp[1][c]=1;
        }else{
            dp[0][c]=dp[1][c-1];//for 0
            dp[1][c]=dp[0][c-1]+dp[1][c-1];//for 1
        }
    }
    
    return dp[0][n]+dp[1][n];
} 

}