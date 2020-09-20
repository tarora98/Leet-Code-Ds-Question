
863
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root==null){
            return null;
        }
        
        List<TreeNode> result=new ArrayList<>();
        
        result=NodeToRoot(root,target.val);
        List<Integer> ans = new ArrayList<>();
        TreeNode prev=null;
        
        
        for(int i=0;i<result.size();i++){
            Kdown(result.get(i),prev,K-i,ans);
            prev=result.get(i);   
        } 
        return ans;       
    }
    static List<TreeNode> NodeToRoot(TreeNode root,int data){
        if(root==null){
            return null;
        }
        if(root.val==data){
            List<TreeNode> base=new ArrayList<>();
            base.add(root);
            return base;
        }
        List<TreeNode> left=NodeToRoot(root.left,data);
        if(left!=null){
            left.add(root);
            return left;
        }
        List<TreeNode> right=NodeToRoot(root.right,data);
        if(right!=null){
            right.add(root);
            return right;
        }
        return null;
    }
    
    static void Kdown(TreeNode Node, TreeNode block,int k,List<Integer> ans){
        if(Node==null || Node==block || k<0){
            return ;
        }
        if(k==0){
            // List<Integer> base=new ArrayList<Integer>();
            ans.add(Node.val);
            return ;
        }
        
        Kdown(Node.left,block,k-1,ans);
        Kdown(Node.right, block,k-1,ans);
        
    }   
}