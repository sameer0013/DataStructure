//                 *
//         *       *       *
// *       *       *       *       *
//         *       *       *
//                 *

import java.util.*;

public class Pattern5 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n =scn.nextInt();
        int row=1,nspaces=n/2,nstars=1;
        while(row<=n){

            // spaces
            for(int col=1;col<=nspaces;col++){
                System.out.print("\t");
            }
            for(int col=1;col<=nstars;col++){
                System.out.print("*\t");
            }

            System.out.println();
            if(row<=n/2){
                nspaces -=1;
                nstars +=2;
            }
            else{
                nspaces +=1;
                nstars -=2;
            }
            row++;

        }

    }
}
