class LeetCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> small=new ArrayList<>();
        result.add(new ArrayList<>());
        subsets(nums,0,result,small,true);
        return result;
    }
    // Faith: 
    public void subsets(int nums[],int offset,List<List<Integer>> result, List<Integer> small,boolean isPicked){
        //base case
        if(offset>=nums.length){
            return;
        }
        //pick
        int val=nums[offset];
        if(offset==0 || isPicked ==true || nums[offset-1]!=nums[offset] ){
            small.add(val);
            subsets(nums,offset+1, result,small,true);
            result.add(new ArrayList<>(small));
            small.remove(small.size()-1);
        }
        // not picked
        subsets(nums,offset+1,result,small,false);
    }
}