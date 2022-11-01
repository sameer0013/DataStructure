
import java.io.*;
import java.util.*;

public class ExitPointOfaMatrix 
{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int m =scn.nextInt();
        int[][] a= new int[n][m];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j]=scn.nextInt();
            }
        }
        int dir=0;
        
        int r=0,c=0;
        while(r>=0&&r<n&&c>=0&&c<m){
            dir=(dir+a[r][c])%4;
            if(dir==0) { //east
                c +=1;
            }else if(dir==1){  //south
                r +=1;
            }else if(dir==2){  //west
                c -=1;
            }else if(dir==3){   //north 
                r -=1;
            }
        }
        if(dir==0){
                c -=1;
            }else if(dir==1){
                r -=1;
            }else if(dir==2){
                c +=1;
            }else if(dir==3){
                r +=1;
            }
        System.out.println(r);
        System.out.println(c);
    }

}
