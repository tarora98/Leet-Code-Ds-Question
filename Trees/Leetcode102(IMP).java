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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        Queue<TreeNode> result=new ArrayDeque<>();
        
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> inside=new ArrayList<>();
        if(root==null){
            return res;
        }
        result.add(root);
        while(result.size()>0){
            int count=result.size();
            for(int i=0;i<count;i++){
                
                TreeNode node=result.remove();
                
                inside.add(node.val);
                
                if(node.left!=null)
                {
                    result.add(node.left);
                }
                if(node.right!=null){
                    result.add(node.right);
                }
                
            }
            res.add(inside);
            inside=new ArrayList<>();   //Most important   
        }
        return res;
    }
}