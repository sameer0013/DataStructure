import java.io.*;
import java.util.*;

public class Main {
    
    public static class Bridge implements Comparable<Bridge>{
        int np,sp;
        Bridge(int np,int sp){
            this.np = np;
            this.sp = sp;
        }
        
        public int compareTo(Bridge o){
            if(this.np!=o.np){
                return this.np-o.np;
            }else{
                return this.sp-o.sp;
            }
            
        }
    }

    public static void main(String[] args) throws Exception {
       Scanner scn = new Scanner(System.in);
       int n = scn.nextInt();
       Bridge bridges[] = new Bridge[n];
       for(int i=0;i<n;i++){
           int np = scn.nextInt();
           int sp = scn.nextInt();
           bridges[i] = new Bridge(np,sp);
       }
       
       Arrays.sort(bridges);
       
       int dp[] = new int[n];
       int ans =0;
       for(int i=0;i<n;i++){
           int maxLen =0;
           for(int j=0;j<i;j++){
               if(bridges[j].sp<bridges[i].sp)
                maxLen = Math.max(maxLen,dp[j]);
           }
           
           dp[i] = maxLen +1;
           ans = Math.max(ans,dp[i]);
       }
       
       System.out.println(ans);
    }

}