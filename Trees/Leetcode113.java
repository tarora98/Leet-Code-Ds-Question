/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> base=new ArrayList<>();
        pathSumm(root,sum,base,new ArrayList<>());
        return base;
        
    }
    public void pathSumm(TreeNode root,int sum,List<List<Integer>> result, List<Integer> ans){
     
        if(root==null){
            return ;
        }
        if(root.left==null && root.right==null && sum-root.val==0){ //leaf node condition
            List<Integer> base=new ArrayList<>(ans);
            base.add(root.val);
            result.add(base);
            return;
        }
        ans.add(root.val);
        pathSumm(root.left,sum-root.val,result,ans);
        pathSumm(root.right,sum-root.val,result,ans);
        ans.remove(ans.size()-1);
        
    }
}