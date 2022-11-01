import java.util.*;
public class Main{

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int nr =9;
        int nc =9;
        int mat[][] = new int[nr][nc];
        for(int i=0;i<nr;i++){
            for(int j=0;j<nc;j++){
                mat[i][j] = scn.nextInt();
            }
        }
        boolean res = isValidSudoku(mat);
        System.out.println(res);
        sudoku(mat,0,0);
    }
    private static boolean isValidSudoku(int[][] mat){
        
        for(int i=0;i<9;i++){
            boolean[] vis = new boolean[9+1];
            for(int j=0;j<9;j++){
                int vl = mat[i][j];
                if(vl<1||vl>9||vis[vl]) return false;
                vis[vl]=true;
            }
        } 
        //col wise  
        for(int j=0;j<9;j++){
            boolean[] vis = new boolean[9+1];
            for(int i=0;i<9;i++){
                int vl = mat[i][j];
                if(vl<1||vl>9||vis[vl]) return false;
                vis[vl]=true;
            }
        } 
        //block wise
        for(int  block =0;block<9;block++){
            int sr = (block/3)*3,sc=(block%3)*3;
            boolean[] vis = new boolean[9+1];
            for(int i=0;i<=2;i++){
                for(int j=0;j<=2;j++){
                    int vl = mat[sr+i][sc+j];
                if(vl<1||vl>9||vis[vl]) return false;
                vis[vl]=true;
                }
            }
        } 
        return true; 
        }
        public static boolean isValidSudoku(int[][] mat,int r,int c,int num){
            //row wise
            
            for(int j=0;j<9;j++){
                int vl = mat[r][j];
                if(vl == num) return false;
            }
            // column wise
            
            for(int i=0;i<9;i++){
                int vl = mat[i][c];
                if(vl == num) return false;
                
            }
            // block wise
           
            int sr = (r/3)*3,sc=(c/3)*3;
            for(int i=0;i<=2;i++){
                for(int j=0;j<=2;j++){
                    int vl = mat[sr+i][sc+j];
                    if(vl==num) return false;
                }
            }
            return true ;
        }
        public static void sudoku(int[][] board , int r,int c){
            if(r==9){
                for(int i=0;i<9;i++){
                    for(int j=0;j<9;j++){
                        System.out.print(board[i][j]+" ");
                    }
                    System.out.println();
                }
                System.out.print(isValidSudoku(board));
                return;
            }
            int nr=0,nc=0;
            if(c==8){
                nr = r+1;
                nc = 0;
            }else{
                nr = r;
                nc = c+1;
            }
            int vl = board[r][c];
            if(vl!=0){
                sudoku(board, nr, nc);
            }else{
                for(int num =1;num<=9;num++){
                    if(isValidSudoku(board,r,c,num)){
                        board[r][c] = num;
                        sudoku(board,nr,nc);
                        board[r][c]=0;
                    }
                }
            }
        }
        
}