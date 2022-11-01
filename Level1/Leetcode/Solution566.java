import java.util.Scanner;

class Solution566 {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
       int[][] ans = new int[r][c];
        int n=mat.length;
        int m =mat[0].length;
        
        if(r*c!=mat.length*mat[0].length) return mat;
        
        for(int i =0;i<r*c;i++){
            ans[i/c][i%c] = mat[i/m][i%m] ;}
        return ans;  
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] mat =new int[3][4];
        for(int i =0;i<3*4;i++){
            mat[i/4][i%4]=scn.nextInt();
        }
        int[][] ans=matrixReshape(mat,2,6);
        for(int i =0;i<2*6;i++){
            System.out.println(ans[i/6][i%6]);
        }
        System.out.println("row length "+ans.length);
        System.out.println("column length "+ans[0].length);
    }
}