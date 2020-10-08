class Solution {
    public int islandPerimeter(int[][] grid) {
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        int countOne=0;
        int countngh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   countOne++;
                    for(int d=0;d<4;d++){
                        int r=i+dir[d][0];
                        int c=j+dir[d][1];
                        if(r>=0 && c>=0 && r<grid.length && c<grid[0].length && grid[r][c]==1){
                            countngh++;
                        }
                    }
            }
        }
    }
        return (4*countOne)-countngh;
}
}