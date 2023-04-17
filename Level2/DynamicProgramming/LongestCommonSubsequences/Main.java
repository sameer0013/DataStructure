import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for(int r = s1.length()-1;r>=0;r--){
            for(int c = s2.length()-1;c>=0;c--){
                if(s1.charAt(r)==s2.charAt(c)){
                    dp[r][c] = dp[r+1][c+1]+1;
                    
                }else{
                    dp[r][c] = Math.max(dp[r][c+1],dp[r+1][c]);
                }
            }
        }
        
        System.out.println(dp[0][0]);
    }

}