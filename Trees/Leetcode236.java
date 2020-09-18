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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> array1=NodetoRoot(root,p);
        ArrayList<TreeNode> array2=NodetoRoot(root,q);
        int i=array1.size()-1;
        int j=array2.size()-1;
        TreeNode LCA=null;
        while(i>=0 && j>=0){
            if(array1.get(i)==array2.get(j)){
                LCA=array1.get(i);
            }
            i--;
            j--;
        }
        return LCA;
    }
    static ArrayList<TreeNode> NodetoRoot(TreeNode root,TreeNode element){
        if(root==null){
            return null;
        }
        if(root.val==element.val){
            ArrayList<TreeNode> base=new ArrayList<TreeNode>();
            base.add(root);
            return base;
        }
        
        ArrayList<TreeNode> leftnode=NodetoRoot(root.left,element);
        if(leftnode!=null){
            leftnode.add(root);
            return leftnode;
        }
        ArrayList<TreeNode> rightnode=NodetoRoot(root.right,element);
        if(rightnode!=null){
            rightnode.add(root);
            return rightnode;
        }
        return null;
    }
}