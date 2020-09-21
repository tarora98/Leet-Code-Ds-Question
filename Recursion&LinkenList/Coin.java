class Coin{
public static int coinpair(int[] coin, int idx,int tar,String ans){
	if(tar==0 || idx>=coin.length){
	if(tar==0){
	System.out.println(ans);
	return 1;
	}
	return 0;
	}
	int count =0;
	if(tar-coin[idx]>=0){
	count+= coinpair(coin, idx+1,tar-coin[idx],ans+coin[idx]);
	}
	count+= coinpair(coin, idx+1,tar,ans);
	return count;
}



// isme index nhi ha permutation
public static int coinpairperm(int[] coin, int tar,String ans,boolean[] vis){
	// if(tar==0 || idx>=coin.length){
	if(tar==0){
	System.out.println(ans);
	return 1;
}
int count=0;
for(int i=0;i<coin.length;i++){
	if(!vis[i] && tar-coin[i]>=0){
		vis[i]=true;
		count+=coinpairperm(coin,tar-coin[i],ans+coin[i],vis);
		vis[i]=false;
	}
}
return count;
}




public static void main(String []args){
	int [] coin={2,3,5,7};
	boolean[] vis=new boolean[4];
	System.out.println(coinpair(coin,0,10,""));
	System.out.print("=============================================");
	System.out.println(coinpairperm(coin,10,"",vis));
}
}