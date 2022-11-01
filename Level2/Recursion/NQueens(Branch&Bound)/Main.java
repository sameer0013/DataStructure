import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    boolean[] rdia = new boolean[n+(n-1)];
    boolean[] ldia = new boolean[n+(n-1)];
    boolean[] col = new boolean[n];
    placeQueen(board,rdia,ldia,col,0,"",n);
    
  }
  
  public static void placeQueen(boolean[][]board,boolean[] rdia,boolean[]ldia,boolean[] col,int r,String asf,int n){
      if(r==board.length){
         
          System.out.println(asf+ ".");
          return ;
      }
      
      
         for(int c=0;c<board[0].length;c++){
              if(rdia[r+c]==false && ldia[r-c+n-1]==false && col[c]==false){
                  board[r][c] =true;
                  rdia[r+c] = true;
                  ldia[r-c+n-1] = true;
                  col[c] = true;
                  placeQueen(board,rdia,ldia,col,r+1,asf+r+"-"+c+", ",n);
                  board[r][c] =false;
                  rdia[r+c] = false;
                  ldia[r-c+n-1] = false;
                  col[c] = false;
              }
          }
      
  }

}