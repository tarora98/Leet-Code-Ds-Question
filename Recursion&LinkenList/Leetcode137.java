
//137
class Solution {
    public int singleNumber(int[] nums) {
        int k=3;
        int ans=0;
        for(int i=0;i<32;i++){
            int count=0;
            int mask=(1<<i);
            for(int ele:nums){
                if((ele&mask)!=0){
                    count++;
                }
            }
            if(count%k!=0){
                ans|=mask;
            }
        }
        return ans;
    }
}