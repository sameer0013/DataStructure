// 1                                               1
// 1       2                               2       1
// 1       2       3               3       2       1
// 1       2       3       4       3       2       1
import java.util.*;

public class Pattern16{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n =scn.nextInt();
     int nstars=1,nspaces=(n*2)-3;
     for(int r=1;r<=n;r++){
         int tmp=0;
         for(int c=1;c<=nstars;c++){
            tmp++;
             System.out.print(tmp+"\t");
             
         }
         for(int c=1;c<=nspaces;c++){
             System.out.print("\t");
         }
         tmp=r<n?tmp:tmp-1;
         nstars=r<n?nstars:nstars-1;
         for(int c=1;c<=nstars;c++){
             System.out.print(tmp+"\t");
             tmp--;
         }
         
         System.out.println();

         nstars+=1;
         nspaces -=2;
     }

 }
}
