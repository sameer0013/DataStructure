import java.io.*;
import java.util.*;

public class SpiralDisplay{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n= scn.nextInt();
        int m= scn.nextInt();
        int[][] a=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=scn.nextInt();
            }
        }
        int r=0,c=0;
        int rmin=0,rmax=n-1;
        int cmin=0,cmax=m-1;
        int count=0;
        while(count<n*m){
            //left wall
            for(r=rmin;r<=rmax&&count<n*m;r++){
                count++;
                System.out.println(a[r][cmin]);
            }
            //bottom wall
            cmin=cmin+1;
            for(c=cmin;c<=cmax&&count<n*m;c++){
                count++;
                System.out.println(a[rmax][c]);
            }
            //right wall
            rmax -=1;
            for(r=rmax;r>=rmin&&count<n*m;r--){
                count++;
                System.out.println(a[r][cmax]);
            }
            //top wall
            cmax -=1;
            for(c=cmax;c>=cmin&&count<n*m;c--){
                count++;
                System.out.println(a[rmin][c]);

            }
            rmin +=1;


        }
    }

}