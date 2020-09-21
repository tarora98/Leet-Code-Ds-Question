public class wordplace{
	static boolean box[][]=new boolean[][];
	static boolean solve(String st,int idx){
	for(int i=0;i<box.length;i++){
		for(int j=0;j<box.length;j++){
			if(box[i][j]=='-' || box[i][j]==word[0]){
				if(canplacewordH(i,j,word)){
					int loc=placewordH(i,j,word);
					if(solve(st,idx+1)){
						return true;
					}
					unplacedwordH(i,j,word,loc);
				}
			}
			if(canplacewordV(i,j,word)){
				int loc=placewordV(i,j,word);
				if(solve(st,idx+1)){
					return true;
				}
				unplacedwordV(i,j,word,loc);
			}
    }
}
return false;
}
static boolean canplacewordV(int i,int j,String word){
if(box[i][j]!=word.charAt(i) ){
	return false;
}
}
static boolean canplacewordH(int i,int j,String word){
if(box[])
}
static int unplacedwordV(int i,int ){

}
static int unplacedwordH(){

}
static int 
public static void main(String[] args){

}
}