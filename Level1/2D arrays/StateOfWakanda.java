import java.io.*;
import java.util.*;

public class StateOfWakanda {
public static void input(int[][] a,Scanner scn){
    for(int r=0;r<a.length;r++){
        for(int c=0;c<a[0].length;c++){
            a[r][c]=scn.nextInt();
        }
    }
}  

public static void stateOfWakanda(int[][]a){
    for(int c=0;c<a[0].length;c++){
        if(c%2==0){
            for(int r=0;r<a.length;r++){
                System.out.println(a[r][c]);
            }
        }else{
            for(int r=a.length-1;r>=0;r--){
                System.out.println(a[r][c]);
            }
        }

    }
}  

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n =scn.nextInt();
    int m =scn.nextInt();
    int a[][]=new int[n][m];
    input(a,scn);

    stateOfWakanda(a);

 }

}
