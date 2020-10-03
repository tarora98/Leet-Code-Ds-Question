/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

 450
class Solution {
public:
    int maxValue(TreeNode* root){
        while(root->right!=nullptr){
            root=root->right;
        }
        return root->val;
    }
    TreeNode* deleteNode(TreeNode* root, int key) {
        if(root==nullptr){
            return root;
        }
        if(key<root->val){
            root->left=deleteNode(root->left,key);
        }
        else if(key>root->val){
            root->right=deleteNode(root->right,key);
        }
        else{
        if(root->left==nullptr || root->right==nullptr){
            return root->left!=nullptr?root->left:root->right;
        }
        int maxVal=maxValue(root->left);
        root->val=maxVal;
        root->left=deleteNode(root->left,maxVal);
        }
        return root;
    }
    
};