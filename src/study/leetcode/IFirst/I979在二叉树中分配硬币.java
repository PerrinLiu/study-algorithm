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

    public int distributeCoins(TreeNode root) {
        return 0;
    }
}
// @lc code=end
