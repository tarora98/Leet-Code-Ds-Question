class Solution {
    public TreeNode MostRightNode(TreeNode right_,TreeNode curr){
        while(right_.right!=null && right_.right!=curr){
            right_=right_.right;
        }
        return right_;
    }
    public int kthSmallest(TreeNode root, int k) {
        TreeNode curr=root;
        while(curr!=null){
            TreeNode LeftNode=curr.left;
            if(LeftNode==null){ //Left null check kar rhe ha 
                if(--k==0){
                    break;
                }
                curr=curr.right;
            }else{
                TreeNode RightNode=MostRightNode(LeftNode,curr);
                if(RightNode.right==null){  // Thread Creation
                    RightNode.right=curr;
                    curr=curr.left;                   
                }else{ //Thread Break
                    RightNode.right=null;
                    if(--k==0){
                        break;
                    }
                    curr=curr.right;
                }
            }
        }
        return curr.val;
        }