public class kandane {
	static int maxSubarra(int arr[]) {
		int max_so_far =  Integer.MIN_VALUE;
		int ending_here = 0;
		for(int i=0 ;i <arr.length ;i++){

			ending_here = ending_here + arr[i];
			if(max_so_far < ending_here) {
				max_so_far = ending_here;
			}

			if(ending_here < 0) {
				ending_here = 0;
			}
		}

		return max_so_far;
	}
public static void main(String[] args) {
	int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
	System.out.println("MAX" + maxSubarra(a));
}
}