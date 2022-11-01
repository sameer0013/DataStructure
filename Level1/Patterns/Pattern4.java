// *       *       *       *       *
//         *       *       *       *
//                 *       *       *
//                         *       *
//                                 *
import java.util.*;

public class Pattern4 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n= scn.nextInt();
        for(int i=1;i<=n;i++){
            int nsp= n+i-(n+1);
            int nst=n+1-i;
            for(int col=1;col<=nsp;col++){
                System.out.print("\t");
            }
            for(int col=1;col<=nst;col++){
                System.out.print("*\t");
            }
            System.out.println();
        }

    }
}
