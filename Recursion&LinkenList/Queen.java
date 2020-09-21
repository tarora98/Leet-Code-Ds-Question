public class Queen {

// static boolean isSafePlace(boolean[][] box,int r,int c){
// 	int [][]dirA={{0,-1},{-1,0},{-1,-1},{0,-1}};
// }
static int Queen(boolean[][] box,int idx,int qpfs,int tnq,String ans){
      if(qpfs == tnq){
        System.out.println(ans);
        return 1;
      } 
      int count = 0;
      int n=box.length;
      for(int i =idx;i<n*n;i++){
      int r=i/n;
      int c=i%n;
      if(!box[r][c]){
      	box[r][c]=true;
        count+=Queen(box,i+1,qpfs+1,tnq,ans+"("+r+","+c+") ");
        box[r][c]=false;
    }
  }
      return count;
    }
	public static void main(String[] args){
	// Scanner sc=new Scanner(System.in);
    boolean[][] box=new boolean[4][4];
    int tnq=4;
    System.out.println(Queen(box,0,0,tnq,""));
	}
}
// public static int queenCombination(boolean,int idxint qsfc,int tnq,String asn){

// }
