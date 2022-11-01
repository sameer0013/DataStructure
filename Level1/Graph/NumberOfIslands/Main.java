package NumberOfIslands;

import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int m = Integer.parseInt(br.readLine());
      int n = Integer.parseInt(br.readLine());
      int[][] arr = new int[m][n];

      for (int i = 0; i < arr.length; i++) {
         String parts = br.readLine();
         for (int j = 0; j < arr[0].length; j++) {
            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
         }
      }

      // write your code here
      int num =numberOfIslands(arr);
      System.out.println(num);
   }

   public static int numberOfIslands(int[][] arr){
      int[][] vis = new int[arr.length][arr[0].length];
      int count=0;
      for(int i=0;i<arr.length;i++){
         for(int j=0;j<arr[0].length;j++){
            if(arr[i][j]==0&&vis[i][j]!=3){
               getcomp(arr,i,j,vis);
               count++;
            }
         }
      }
      return count;
   }

   public static void getcomp(int[][] arr,int i,int j,int[][] vis){
      if(i<0||j<0||i>=arr.length||j>=arr[0].length||arr[i][j]==1||vis[i][j]==3){
         return;
      }

      vis[i][j]=3;
      getcomp(arr,i-1,j,vis);
      getcomp(arr,i,j+1,vis);
      getcomp(arr,i,j-1,vis);
      getcomp(arr,i+1,j,vis);
   }
}
