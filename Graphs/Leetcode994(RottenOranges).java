class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid.length==0 || grid[0].length==0){
            return 0;
        }
        int freshOranges=0;
        int n=grid.length;
        int m=grid[0].length;
        int rottenOranges=0;
        int direct[][]={{-1,0},{1,0},{0,1},{0,-1}};
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.addLast(i*m+j);
                    rottenOranges++;
                }
                if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges==0){
            return 0;
        }
        if(rottenOranges==0){
            return -1;
        }
        int level=0;
        while(queue.size()!=0){
            int size=queue.size();
            while(size-->0){
                int vtx=queue.removeFirst();
                int r=vtx/m;
                int c=vtx%m;
                for(int dir=0;dir<4;dir++){
                    int x=r+direct[dir][0];
                    int y=c+direct[dir][1];
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                        grid[x][y]=2;
                        queue.addLast(x*m+y);
                        freshOranges--;
                        if(freshOranges==0){
                            return level+1;                            
                        }
                    }
                }
            }
            level++; //level means time;
        }
        return -1;
    }
}