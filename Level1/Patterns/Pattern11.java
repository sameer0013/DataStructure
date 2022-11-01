// 1
// 2       3
// 4       5       6
// 7       8       9       10
// 11      12      13      14      15

import java.util.*;

public class Pattern11 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int k=1;
        for(int i=1;i<=n;i++){
           
            for(int j=1;j<=n;j++){
                if(j<=i){
                    System.out.print(k+"\t");
                    k++;
                }
                else{
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

        // another way to do this pattern
        k=1;
        System.out.println();
        System.out.println();
        for(int row=1;row<=n;row++){
            int nst=row;
            for(int col=1;col<=nst;col++){
                System.out.print(k+"\t");
                k++;
            }
            System.out.println();
        }

    }
}
