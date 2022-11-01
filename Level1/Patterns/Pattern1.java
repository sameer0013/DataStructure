// *
// *       *
// *       *       *
// *       *       *       *
// *       *       *       *       *
import java.util.*;

public class Pattern1 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n = scn.nextInt();
        for(int row=1;row<=n;row++){
            int nst=row;
            for(int col=1;col<=nst;col++){
                System.out.print("*\t");
            }
            System.out.println();
        }

    }
}
