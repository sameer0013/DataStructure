//                 1
//         2       3       2
// 3       4       5       4       3
//         2       3       2
//                 1

import java.util.*;

public class Pattern15 {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // write ur code here
        int n=scn.nextInt();
        int nstars=1,nspaces=n/2,k=1;
        for(int r=1;r<=n;r++){
            for(int c=1;c<=nspaces;c++){
                System.out.print("\t");
            }
            int tmp=k;
            for(int c=1;c<=nstars;c++){
                
                System.out.print(tmp+"\t");
                if(c<=nstars/2){
                    tmp++;
                }
                else{
                    tmp--;
                }
            }
            System.out.println();
            if(r<=n/2){
                nspaces -=1;
                nstars +=2;
                k++;
            }
            else{
                nspaces +=1;
                nstars -=2;
                k--;
            
            }
        }

    }
}
