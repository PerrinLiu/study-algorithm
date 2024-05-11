package study.entity;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        String s1 = left == null ? "" : left.toString();
        String s2 = right == null ? "" : right.toString();
        if (s1 == "" && s2 == "") {
            return "{" +
                    val +
                    "}";
        } else if (s1 == "") {
            return "{" +
                    val +
                    ", " + s2 +
                    "}";
        } else if (s2 == "") {
            return "{" +
                    val +
                    ", " + s1 +
                    "}";
        }

        return "{" +
                val +
                ", " + s1 +
                ", " + s2 +
                "}";

    }
}