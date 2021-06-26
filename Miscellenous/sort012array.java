class sort012array
{
    public static void sort012(int a[], int n)
    {
        int pt1 = -1, itr= 0, pt2 = n - 1;
        
        while(itr <= pt2) {
            
            if(a[itr] == 0) {
                swap(a, itr++, ++pt1);
            }
            else if(a[itr] == 2){
                swap(a, itr, pt2--);
            } 
            else {
                itr++;
            }
        }
    }
    
    static void swap(int a[], int m, int n) {
        int temp = a[m];
        a[m]= a[n];
        a[n]= temp;
    }
}