import java.util.*;

public class Main {

  
  // ~~~~~~~~~~~~~User Section~~~~~~~~~~~~~
  public static int[][] transpose(int[][] matrix) {
    // write your code here

    int n = matrix.length,m= matrix[0].length;
    if(m!=n){
      return rectTranspose(matrix,n,m);
    }else{
      for(int i=0;i<n;i++){
        for(int j=i+1;j<m;j++){
          int tmp= matrix[i][j];
          matrix[i][j]=matrix[j][i];
          matrix[j][i] = tmp;
        }
      }
      return matrix;
    }
  
  }

  public static int[][] rectTranspose(int[][] matrix,int n,int m){
    int[][] ans = new int[m][n];
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        ans[i][j] = matrix[j][i]; 
      }
    }
    return ans;
  }


  // ~~~~~~~~~~~Input Management~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    int[][] matrix = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        matrix[i][j] = scn.nextInt();
      }
    }

    int[][] res = transpose(matrix);

    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < res[0].length; j++) {
        System.out.print(res[i][j] + " ");
      }
      System.out.println();
    }
  }
}