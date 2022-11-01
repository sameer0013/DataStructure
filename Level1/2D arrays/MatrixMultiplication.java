import java.io.*;
import java.util.*;

public class MatrixMultiplication {

public static void input(int[][] a,Scanner scn){
    for(int r=0;r<a.length;r++)
    {
        for(int c=0;c<a[0].length;c++){
            a[r][c]=scn.nextInt();
        }
    }
}
public static void display(int[][]a){

    for(int r=0;r<a.length;r++)
    {
        for(int c=0;c<a[0].length;c++){
            System.out.print(a[r][c]+" ");
        }
        System.out.println();
    }
}
public static int[][] matrixMultiplication(int[][] a1,int[][] a2){
    int[][] res=null;
    int nr1=a1.length,nc1=a1[0].length;
    int nr2=a2.length,nc2=a2[0].length;
    if(nc1==nr2){
        res=new int[nr1][nc2];
        for(int r=0;r<res.length;r++){
            for(int c=0;c<res[0].length;c++){
                for(int k=0;k<nc1;k++){
                    res[r][c] += a1[r][k]*a2[k][c];
                } 
            }
        }
    }
    else{
        System.out.println("Invalid input");
    }    
    return res;
    
    
}

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn= new Scanner(System.in);
    int n1=scn.nextInt();
    int m1=scn.nextInt();
    int [][] a1=new int[n1][m1];
    input(a1,scn);

    int n2=scn.nextInt();
    int m2=scn.nextInt();
    int [][] a2=new int[n2][m2];
    input(a2,scn);
    int res[][]=matrixMultiplication(a1,a2);
    if(res!=null)
    {    display(res);
    }
}

}
