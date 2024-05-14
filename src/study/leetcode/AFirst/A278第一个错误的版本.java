package study.leetcode.AFirst;
/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class A278第一个错误的版本 extends VersionControl {
    public static void main(String[] args) {
        int firstBadVersion = new A278第一个错误的版本().firstBadVersion(2126753390);
        System.out.println(firstBadVersion);
    }

    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * 278.第一个错误的版本
 */
class VersionControl {

    public boolean isBadVersion(int version) {
        int bad = 1702766719;
        return version >= bad;
    }
}
// @lc code=end
