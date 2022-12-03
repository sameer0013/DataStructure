import java.io.*;
import java.util.*;

public class Main {
    
    static int colInfo,ldiaInfo,rdiaInfo;

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        colInfo = rdiaInfo = ldiaInfo =0;
        // int[][] chess = new int[n][n];
        printNQueens(n,"",0);
    }
    

    public static void printNQueens(int n, String qsf, int row) {
        if(row==n){
            System.out.println(qsf+".");
            return;
        }
        for(int col =0;col<n;col++){
            
            int rdiaPosMask =(1 << (row+col));
            int ldiaPosMask = (1<<(row-col+n-1));
            int colPosMask = (1<<col);
            
            boolean isSafe = (colInfo & colPosMask)==0&&(rdiaInfo & rdiaPosMask)==0 && (ldiaInfo & ldiaPosMask)==0;
            if(isSafe){
                // mark bit 1(block)
               colInfo = (colInfo ^ colPosMask);
               ldiaInfo = (ldiaInfo ^ ldiaPosMask);
               rdiaInfo = (rdiaInfo ^ rdiaPosMask);
               
               printNQueens(n,qsf+row+"-"+col+", ",row+1);
               
               // unmark bit 0(unblock)
               colInfo = (colInfo ^ colPosMask);
               ldiaInfo = (ldiaInfo ^ ldiaPosMask);
               rdiaInfo = (rdiaInfo ^ rdiaPosMask);
            }
        }
    }
}