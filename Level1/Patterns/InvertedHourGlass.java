// *       *       *       *       *       *       *
//         *       *       *       *       *
//                 *       *       *
//                         *
//                 *               *
//         *                               *
// *       *       *       *       *       *       *
import java.io.*;
import java.util.*;

public class InvertedHourGlass 
{

public static void main(String[] args) throws Exception 
{
    // write your code here
    Scanner scn=new Scanner(System.in);
    int n =scn.nextInt();
    int nstars=n,nspaces=0;
    for(int r=1;r<=n;r++){
        for(int c=1;c<=nspaces;c++){
            System.out.print("\t");
        }
        for(int c=1;c<=nstars;c++){
            if(r>n/2+1&&r<n){
                if(c==1||c==nstars){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
            else{
                System.out.print("*\t");
            }
            
        }
        System.out.println();
        if(r<=n/2){
            nspaces +=1;
            nstars -=2;

        }
        else{
            nstars +=2;
            nspaces -=1;
        }
    }
}
}

