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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] dia=diameter(root);
        return dia[0];
    }
    static int[] diameter(TreeNode root){
        if(root==null){
            return new int[]{0,-1};
        }
        int[] lres=diameter(root.left);
        int[] rres=diameter(root.right);
        int dia=Math.max(Math.max(lres[0],rres[0]),lres[1]+rres[1]+2);
        int hei=Math.max(lres[1],rres[1])+1;
        return new int[]{dia,hei};
    }
}