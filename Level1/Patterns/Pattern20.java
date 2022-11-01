// *                               *
// *                               *
// *               *               *
// *       *               *       *
// *                               *
import java.util.*;

public class Pattern20 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n =scn.nextInt();
        int nstars=n;
        for(int row=1;row<=n;row++){
            //code each row
              //stars
              for(int col=1;col<=nstars;col++){
                  if(col==1||col==n){
                     System.out.print("*\t");
                  }
                  else if(row==col&&row>=n/2+1||row+col==n+1&&row>=n/2+1){
                      System.out.print("*\t");
                  }
                  else{
                      System.out.print("\t");
                  }
                 
              }
            //next line
            System.out.println();
            
        }

    }
}