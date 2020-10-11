public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    public void wallsAndGates(int[][] rooms) {
    if(rooms.length==0 || rooms.length==1){
        return;
    }
    int n=rooms.length;
    int m=rooms[0].length;
    int level=0;
	int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
	LinkedList<Integer> queu=new LinkedList<>();
	for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
		    if(rooms[i][j]==0){
			   queu.addLast(i*m+j);
		    }
		}
	}
	while(queu.size()!=0){
        int size=queu.size();
		while(size-->0){
		    int vtx=queu.removeFirst();
		    int r=vtx/m;
			int c=vtx%m;
			for(int d=0;d<4;d++){
				int x=r+dir[d][0];
				int y=c+dir[d][1];
				if(x>=0 && y>=0 && x<rooms.length && y<rooms[0].length && rooms[x][y]==2147483647){
				    rooms[x][y]=level+1;
				    queu.addLast(x*m+y);
		}
		}
	    }
     	level++;
    }
    }
}