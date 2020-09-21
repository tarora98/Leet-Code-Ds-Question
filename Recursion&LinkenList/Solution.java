import java.util.*;
class Solution {
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> small=new ArrayList();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return subset(nums,0);
    }
    public void subset(int[] nums,int n){
      int[] freq=new int[nums.length];
      for(int i=0;i<nums.length;i++){
        freq[nums[i]]++;
      }
      if(nums.length==n){
        List<Integer> base=new ArrayList<Integer>(small);
        result.add(small);
        return;
      }
      int multiple=0;
      for(int i=0;i<freq.length;i++){
        small.add(subset(nums,n+1,freq[i]+1));
        multiple+=subset(nums,n+1,freq[i]+1);
      }
      System.out.print(multiple);
    }
  }

