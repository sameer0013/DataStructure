// 1
// 1       1
// 1       2       1
// 1       3       3       1
// 1       4       6       4       1
import java.util.*;
public class Pattern13 {
    // public static int factorial(int n){
    //     int res=1;
    //     for(int i=1;i<=n;i++){
    //         res =res*i;
    //     }
    //     return res;
    // }
    // public static int ncr(int n,int r){
    //     return factorial(n)/(factorial(n-r)*factorial(r));
    // }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int num =scn.nextInt();
        // for(int i=0;i<num;i++){
        //     
        //     for(int j=0;j<=i;j++){
               
        //         int icj=ncr(i,j);
        //         System.out.print(icj+"\t");
        //         
        //     }
        //     System.out.println();
        // }
        //write your code here
        for(int row=0;row<num;row++){
            int ncr=1;
            for(int col=0;col<=row;col++){
                System.out.print(ncr+"\t");
                int n=row,r=col;
                int ncrp1=((n-r)*ncr)/(r+1);
                ncr=ncrp1;
                
            }
            System.out.println();
        }

    }
}
