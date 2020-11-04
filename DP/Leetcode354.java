//Sort only one dimension, Complexity :- O(2*n^2)

class Solution {
    public:
        int maxEnvelopes(vector<vector<int>>& arr) {
            int n=arr.size();
            vector<int> dp(n,0);
            sort(arr.begin(),arr.end(),[](auto a,auto b){
                return a[1]<b[1];            
            });
            int maxStack=0;
            for(int i=0;i<n;i++){
                dp[i]=1;
                for(int j=i-1;j>=0;j--){
                    if(arr[i][0]>arr[j][0] &&arr[i][1]>arr[j][1]){
                        dp[i]=max(dp[i],dp[j]+1);
                    }
                }
                    maxStack=max(maxStack,dp[i]);
            }
            return maxStack;
            
        }
    };


    /// Sort only one dimension Another method when height is same then we will sort opposite in width, Complexity :- O(n^2)
    class Solution {
        public:
            int maxEnvelopes(vector<vector<int>>& arr) {
                int n=arr.size();
                vector<int> dp(n,0);
                sort(arr.begin(),arr.end(),[](auto a,auto b){
                    if(a[1]==b[1]){
                        return b[0]<a[0]; /// When height is same 
                    }
                    return a[1]<b[1];            
                });
                int maxStack=0;
                for(int i=0;i<n;i++){
                    dp[i]=1;
                    for(int j=i-1;j>=0;j--){
                        if(arr[i][0]>arr[j][0] ){
                            dp[i]=max(dp[i],dp[j]+1);
                        }
                    }
                        maxStack=max(maxStack,dp[i]);
                }
                return maxStack;
                
            }
        };