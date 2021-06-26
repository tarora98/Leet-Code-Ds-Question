class GfG
{
    int max_sum(int arr[], int n)
    {
	// Your code here
	    int sum = 0, sumwithIndex = 0, maxSum = 0;
	    
	    for(int i=0;i<n;i++) {
	        sum += arr[i];
	        sumwithIndex +=arr[i]*i;
	    }
	    
	    maxSum = sumwithIndex;
	    
	    for(int i=1;i<n;i++){
	        sumwithIndex =sumwithIndex - sum + arr[i-1]*n;
	        maxSum = Math.max(maxSum, sumwithIndex);
	    }
	    
	    return maxSum;
    }	
}