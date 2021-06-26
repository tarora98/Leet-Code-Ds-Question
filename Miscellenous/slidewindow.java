public class slidewindow{
	static int slide(int arr[], int K) {
		
		if(arr.length < K) {
			System.out.println("INVLAID");
			return -1;
		}
		int j = 0;

		int max = 0;
		for(int i=0;i<K;i++) {
			max+=arr[i];
		}
		j = max;

		for(int i=K;i<arr.length;i++){
			j += arr[i] -arr[i -K];
			max = Math.max(j, max);
		}
		return max;
	}
public static void main(String[] args) {
	int arr[]= { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
	int k = 4;
	System.out.println(slide(arr, k));
}
}
