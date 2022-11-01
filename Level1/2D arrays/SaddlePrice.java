//least number along the row and maximum number along the column


import java.util.*;

public class SaddlePrice 
 {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[][] a=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=scn.nextInt();
            }
        }
        int sad=saddleprice(a);
        if(sad==-1){
            System.out.println("Invalid input");
        }
        else{
            System.out.println(sad);
        }
        
    }
    public static int saddleprice(int[][] a){
        
        int saddle=-1;
        
        for(int i=0;i<a.length;i++){
            int min=a[i][0];
            int idx=0;
            for(int j=0;j<a[0].length;j++){
                if(min>a[i][j]){
                    min=a[i][j];
                    idx=j;
                }
            }
            int max=a[0][idx];
            for(int r=0;r<a.length;r++){
                if(max<a[r][idx]){
                    max=a[r][idx];
                }
            }
            if(min==max){
                saddle=max;
                return saddle;
                
            }

        }
        return saddle;
    
    }

}
