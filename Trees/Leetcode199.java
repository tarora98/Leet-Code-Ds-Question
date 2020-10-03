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
    public List<Integer> rightSideView(TreeNode root) {
       
        LinkedList<TreeNode> que=new LinkedList<>();
        que.addLast(root);
        List<Integer> ans=new ArrayList<>();
         if(root==null){
            return ans;
        }
        while(que.size()!=0){
            int size=que.size();
            int prev=-1;
            while(size--> 0){
            TreeNode vtx=que.removeFirst();
            if(vtx.left!=null){
                que.addLast(vtx.left);
            }
            if(vtx.right!=null){
                que.addLast(vtx.right);
            }
            prev=vtx.val;// for right view
        }
        ans.add(prev);
    }
        return ans;
}
}