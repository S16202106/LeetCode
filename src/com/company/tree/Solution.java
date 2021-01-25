package com.company.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
// 二叉树的中序遍历
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack=new Stack<TreeNode>();
        TreeNode head=root;
        List<Integer> res=new LinkedList<>();
        // 入栈时 必须遍历根节点的左子树
        while(null != head){
            stack.push(head);
            head=head.left;
        }
        while(!stack.isEmpty()){
            // 出栈时 判断右子树 是否存在
            head=stack.pop();
            res.add(head.val);
            if(null != head.right){
                head=head.right;
                stack.push(head);
                head=head.left;
                while(null != head){
                    stack.push(head);
                    head=head.left;
                }
            }
        }
        return res;
    }
}
