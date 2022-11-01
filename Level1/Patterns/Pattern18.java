// *       *       *       *       *       *       *
//         *                               *
//                 *               *
//                         *
//                 *       *       *
//         *       *       *       *       *
// *       *       *       *       *       *       *
import java.util.*;

public class Pattern18{

public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);

     // write ur code here
     int n =scn.nextInt();
     int nspaces=0,nstars=n;
     for(int r=1;r<=n;r++){
         for(int c=1;c<=nspaces;c++){
             System.out.print("\t");
         }
         for(int c=1;c<=nstars;c++){
             if(r>1 &&r<n/2+1){
                 if(c==1||c==nstars){
                     System.out.print("*\t");
                 }else{
                     System.out.print("\t");
                 }
             }else{
                  System.out.print("*\t");
             }
            
         }
         System.out.println();
         if(r<=n/2){
             nstars -=2;
             nspaces +=1;
         }
         else{
             nstars +=2;
             nspaces-=1;
         }
     }

 }
}
