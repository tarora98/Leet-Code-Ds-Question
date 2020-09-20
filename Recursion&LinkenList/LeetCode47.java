import java.util.*;
class LeetCode47 {
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> small=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean isvis[]=new boolean[nums.length];
        permuteUnique(nums,0,isvis);
        return result;
    }
    public void permuteUnique(int[] nums,int count, boolean[] vis) {
        if(count==nums.length){
            List<Integer> smallAns=new ArrayList<Integer>(small);
            result.add(smallAns);
            return;
        }
        int prev=-(int)1e8;
        for(int i=0;i<nums.length;i++){
            if(!vis[i] && prev!=nums[i]){
                vis[i]=true;
                small.add(nums[i]);
                permuteUnique(nums,count+1,vis);
                small.remove(small.size()-1);
                vis[i]=false;
                prev=nums[i];
            }
        }
    }
}
        
