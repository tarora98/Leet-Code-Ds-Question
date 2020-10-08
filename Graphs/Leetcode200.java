class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    island(grid,i,j,dir);
                    count++;
                }
            }
        }
        return count;
    }
    static void island(char[][] grid, int r,int c,int[][] dir){
        grid[r][c]='0'; 
        for(int i=0;i<dir.length;i++){
            int x=r+dir[i][0];
            int y=c+dir[i][1];
            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='1'){
                island(grid,x,y,dir);
            }
        }
    }
}
