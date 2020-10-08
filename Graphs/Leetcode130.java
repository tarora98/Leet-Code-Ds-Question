class Solution {
    public void solve(char[][] board) {
        int dir[][]={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
            if(i==0 || j==0 || i==board.length-1 || j==board[0].length-1){ // boarding condition
                if(board[i][j]=='O'){
                   solved(board,i,j,dir);
                }
            }
        }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O')
                {
                    board[i][j]='X';
                }
                if(board[i][j]=='$')
                {
                    board[i][j]='O';
                }
            }
        }
    }
    static void solved(char[][] board, int r,int c,int dir[][]){
        board[r][c]='$';
        for(int i=0;i<4;i++){
            int x=r+dir[i][0];
            int y=c+dir[i][1];
            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y] == 'O'){
                solved(board,x,y,dir);
            }
        }
    }
}