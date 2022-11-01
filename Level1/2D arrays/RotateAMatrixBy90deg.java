import java.io.*;
import java.util.*;

public class RotateAMatrixBy90deg 
{

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn =new Scanner(System.in);
        int n=scn.nextInt();
        int[][] a= new int[n][n];
        for (int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                a[i][j]=scn.nextInt();
            }
        }
        transpose(a);
        
        for(int[] i:a){
            reverse(i);
        }
        
        display(a);
    }
    public static void transpose(int[][]a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<=i;j++){
                int temp=a[i][j];
                a[i][j]=a[j][i];
                a[j][i]=temp;
            }
        }
    }
    public static void reverse(int [] a){
        
            int left=0;
            int right=a.length-1;
            while(left<right)
            {
                int temp=a[left];
                a[left]=a[right];
                a[right]=temp;
                left++;
                right--;
            }    
        
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
