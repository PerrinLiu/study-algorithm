package study.leetcode.DFirst;
/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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
class Solution437 {
    public static void main(String[] args) {
        // TreeNode treeNode = new TreeNode(
        // 10,
        // new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(2)),
        // new TreeNode(2, null, new TreeNode(1))),
        // new TreeNode(-3, null, new TreeNode(11)));
        TreeNode treeNode = new TreeNode(
                0, new TreeNode(1),
                new TreeNode(1));
        System.out.println(new Solution437().pathSum(treeNode, 1));
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<Long, Integer>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

    // public int pathSum(TreeNode root, long targetSum) {
    // if (root == null) {
    // return 0;
    // }

    // int ret = rootSum(root, targetSum);
    // ret += pathSum(root.left, targetSum);
    // ret += pathSum(root.right, targetSum);
    // return ret;
    // }

    // public int rootSum(TreeNode root, long targetSum) {
    // int ret = 0;

    // if (root == null) {
    // return 0;
    // }
    // int val = root.val;
    // if (val == targetSum) {
    // ret++;
    // }

    // ret += rootSum(root.left, targetSum - val);
    // ret += rootSum(root.right, targetSum - val);
    // return ret;
    // }

    // int res = 0;
    // List<TreeNode> list = new ArrayList<>();

    // public int pathSum(TreeNode root, int targetSum) {
    // dfs(root, targetSum, 0);
    // return res;
    // }

    // private void dfs(TreeNode root, int targetSum, int num) {
    // if (root == null) {
    // return;
    // }
    // num += root.val;
    // if (num == targetSum && !list.contains(root)) {
    // list.add(root);
    // res++;
    // }
    // if (root.left != null) {
    // dfs(root.left, targetSum, num);
    // dfs(root.left, targetSum, 0);
    // }
    // if (root.right != null) {
    // dfs(root.right, targetSum, num);
    // dfs(root.right, targetSum, 0);
    // }

    // }

}
// @lc code=end
