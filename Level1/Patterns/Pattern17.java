//                 *
//                 *       *
// *       *       *       *       *
//                 *       *
//                 *


import java.util.*;

public class Pattern17 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n =scn.nextInt();
        int row=1,nspaces=n/2,nstars=1;
        while(row<=n){
            for(int col=1;col<=nspaces;col++){
                if(row==(n/2)+1){
                    System.out.print("*\t");
                }
                else{
                     System.out.print("\t");
                }
               
            }
            for(int col=1;col<=nstars;col++)
            {
                System.out.print("*\t");
            }
            System.out.println();
            if(row<=n/2){
                nstars =nstars+1;
                
            }
            else{
                nstars =nstars-1;
            }
            row++;
        }
    }
}
