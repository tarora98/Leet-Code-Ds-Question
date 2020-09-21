import java.util.*;
class PathPair{
	PathPair(String path, int length)
	{
		path="";
		length=0;
}
}
public class Pair{  
    static int[][] dir={{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static String[] dirS={"D", "L", "U", "R"};
    static int count = 0;
    static int printPath(int[][] m, int n, int[][] vis) 
    {
        return floodfill(m,n,0,0,n,n,"",vis);
    }
    static int floodfill(int[][] m,int n,int sr, int sc, int er, int ec, String ans, int vis[][]){
    if (sr == er && sc == ec)
    {   
        System.out.print(ans);
        return 0 ;
    }
    vis[sr][sc] = 1;
    for (int d = 0; d < dir.length; d++)
    {
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];
        if (r >= 0 && c >= 0 && r < vis.length && c < vis[0].length && vis[r][c] == 0)
        {
            count +=((floodfill(m,n,r, c, er, ec, ans + dirS[d],vis))+1);
        }
    }
    vis[sr][sc] = 0;
    return count;
}
public static void main(String[] args){
    int n=3;
    int[][] maze=new int[n][n];
    int[][] vis=new int[n][n];
    System.out.print(printPath(maze, n, vis));
}
}