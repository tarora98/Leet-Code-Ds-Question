class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int sum=0;
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
         for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                sum=Math.max(sum,island(grid,i,j,dir));
                }
            }
        }
        return sum;
    }
    
    static int island(int[][] grid, int r, int c,int dir[][]){
        int count=0;
        grid[r][c]=0; //// Most important
        for(int i=0;i<4;i++){
           int x=r+dir[i][0];
           int y=c+dir[i][1];
           if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
               count+=island(grid,x,y,dir);
           }
       }
        return count+1;
    }
}