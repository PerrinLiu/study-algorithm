package study.leetcode.IFirst;
/*
 * @lc app=leetcode.cn id=979 lang=java
 *
 * [979] 在二叉树中分配硬币
 */

// @lc code=start

import study.entity.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class I979在二叉树中分配硬币 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(0), new TreeNode(0));
        int distributeCoins = new I979在二叉树中分配硬币().distributeCoins(treeNode);
        System.out.println(distributeCoins);
    }

    int move = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return move;
    }

    public int dfs(TreeNode root) {
        int moveleft = 0;
        int moveright = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            moveleft = dfs(root.left);
        }
        if (root.right != null) {
            moveright = dfs(root.right);
        }
        move += Math.abs(moveleft) + Math.abs(moveright);
        return moveleft + moveright + root.val - 1;
    }

}
// @lc code=end
