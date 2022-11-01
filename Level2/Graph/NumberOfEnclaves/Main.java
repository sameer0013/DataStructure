class Solution {
    public int numEnclaves(int[][] grid) {
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(r==0||c==0||r==grid.length-1||c==grid[0].length-1){
                    if(grid[r][c]==1){
                        dfs(grid,r,c);
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid,int r,int c){
        if(grid[r][c]==0){
            return;
        }
        grid[r][c]=0;
        if(r-1>=0 && grid[r-1][c]==1){
            dfs(grid,r-1,c);
        }
        if(c-1>=0 && grid[r][c-1]==1){
            dfs(grid,r,c-1);
        }
        if(c+1<grid[0].length && grid[r][c+1]==1){
            dfs(grid,r,c+1);
        }
        if(r+1<grid.length && grid[r+1][c]==1){
            dfs(grid,r+1,c);
        }
        
    }
}