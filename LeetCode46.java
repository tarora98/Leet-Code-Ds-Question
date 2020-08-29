import java.util.*;
class LeetCode46 {
   List<List<Integer>> result=new ArrayList<>();
    List<Integer> small=new ArrayList<>();
 public List<List<Integer>> permute(int[] nums) {
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
        for(int i=0;i<nums.length;i++){
            if(!vis[i]){
                vis[i]=true;
                small.add(nums[i]);
                permuteUnique(nums,count+1,vis);
                small.remove(small.size()-1);
                vis[i]=false;
            }
        }
    }
}
   