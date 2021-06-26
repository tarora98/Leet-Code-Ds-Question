public class equilibrium {
	static int requi(int arr[], int n){
		int leftsum = 0;
		int rightsum = 0;
		for(int i=0;i<n ;i++) {
			leftsum = left(0,i, arr);
			rightsum = right(i,n, arr);
			if(leftsum == rightsum){
				return i;
			}
		}
		return -1;
	}
	static int left(int n ,int m, int arr[]) {
		int sum =0;
		for(int i=n; i<m ;i++){
			sum+=arr[i];
		}
		return sum;
	} 
	static int right(int n, int m, int arr[]){
		int sum =0;
		for(int i=n+1; i<m ;i++){
			sum+=arr[i];
		}
		return sum;
	}
	public static void main(String[] args) {
		int a[] = new int[10];
		a[0]=-7;//initialization  
		a[1]=1;  
		a[2]=5;  
		a[3]=2;  
		a[4]=-4;
		a[5]=3;
		a[6]=0; 
		int n = a.length;
		System.out.print(requi(a, n));
	}
}