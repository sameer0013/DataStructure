import java.io.*;
import java.util.*;

public class RingRoatate  {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] a= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                a[i][j]=scn.nextInt();
            }
        }
        int shell=scn.nextInt();
        int k=scn.nextInt();
        ringrotate(a,shell,k);
        display(a);
    }
    public static void ringrotate(int [][] a,int s,int r){
        // Integer[] a1=fill1d(a,s);
        int [] a1=fill1d(a,s);
        rotate(a1,r);
        fill2d(a,s,a1);

    }
    public static int[] fill1d(int[][] a,int shell){
        int rmin=shell-1;
        int rmax=a.length-shell;
        int cmin=shell-1;
        int cmax=a[0].length-shell;
        // int size=(rmax-rmin)*2+(cmax-cmin)*2;
        // int arr[]=new int[size];
        ArrayList<Integer> list=new ArrayList<>();
        //int idx=0;
  
        for(int r=rmin;r<=rmax;r++){
            // arr[idx]=a[r][cmin];
            // idx++;
            list.add(a[r][cmin]);
        }
        for(int c=cmin+1;c<=cmax;c++){
            // arr[idx]=a[rmax][c];
            // idx++;
            list.add(a[rmax][c]);
        }
        for(int r=rmax-1;r>=rmin;r--){
            // arr[idx]=a[r][cmax];
            // idx++;
            list.add(a[r][cmax]);
        }
        for(int c=cmax-1;c>=cmin+1;c--){
            // arr[idx]=a[rmin][c];
            // idx++;
            list.add(a[rmin][c]);
        }

        int[] arr=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }


        
        return arr;
        //return list.toArray(new Integer[list.size()]); // for this we have to convert all int to Integer where we mention our 1darr
    }
    public static void fill2d(int[][]a ,int shell,int[] arr){
        int rmin=shell-1;
        int rmax=a.length-shell;
        int cmin=shell-1;
        int cmax=a[0].length-shell;
       
        int idx=0;
        for(int r=rmin;r<=rmax;r++){
            a[r][cmin]=arr[idx];
            idx++;
        }
        for(int c=cmin+1;c<=cmax;c++){
            a[rmax][c]=arr[idx];
            idx++;
        }
        for(int r=rmax-1;r>=rmin;r--){
            a[r][cmax]=arr[idx];
            idx++;
        }
        for(int c=cmax-1;c>cmin;c--){
            a[rmin][c]=arr[idx];
            idx++;
        }
        
    }
    public static void rotate(int[] a,int r){
        r=r%a.length;
        if(r<0){
            r=r+a.length;
        }
        reverse(a,0,a.length-1-r);
        reverse(a,a.length-r,a.length-1);
        reverse(a,0,a.length-1);

    }
    public static void reverse(int[] a,int li,int ri){
        while(li<ri){
            int temp=a[li];
            a[li]=a[ri];
            a[ri]=temp;
            li++;
            ri--;
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
