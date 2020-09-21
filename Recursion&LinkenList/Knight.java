public class Knight{
	static int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2}; 
    static int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1}; 
    public static boolean KnightSolver(int[][] board, int sr,int sc,int steps){
    	board[sr][sc]=steps;
    	if(steps==63){
    		return true;
    	}
    }