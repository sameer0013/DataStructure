//               *	
// 			 *		 *	
// 		 *				 *	
// 	  *						 *	
// *					    	 *	
// 	 *						 *	
// 		 *			 	*	
// 			 *		 *	
// 				 *	

import java.util.*;Pa

public class Pattern10 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        // int n =scn.nextInt();
        // int nstars=1,nspaces=n/2,nspaces2=-1,nstars2=1;
        // for(int row=1;row<=n;row++){
        // for(int col=1;col<=nspaces;col++){
        // System.out.print("\t");
        // }
        // for(int col=1;col<=nstars;col++){
        // System.out.print("*\t");
        // }
        // for(int col=1;col<=nspaces2;col++){
        // System.out.print("\t");
        // }
        // for(int col=1;col<=nstars2;col++){
        // if(row>1 &&row<n)
        // {
        // System.out.print("*\t");
        // }

        // }

        // System.out.println();
        // if(row<=n/2){
        // nspaces2 +=2;
        // nspaces -=1;

        // }
        // else{
        // nspaces +=1;
        // nspaces2 -=2;
        // }
        // }

        // write ur code here
        int n = scn.nextInt();
        int nstars = 1, nspaces = n/2;
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= nspaces; col++) {
                System.out.print("\t");
            }
            for (int col = 1; col <= nstars; col++) {
                if (col == 1 || col == nstars) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
            if (row <= n / 2) {
                nstars += 2;
                nspaces -= 1;
            } else {
                nstars -= 2;
                nspaces += 1;
            }
        }

    }

}
