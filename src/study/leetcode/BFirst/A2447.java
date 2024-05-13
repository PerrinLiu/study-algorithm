package study.leetcode.BFirst;
/*
 * @lc app=leetcode.cn id=2447 lang=java
 *
 * [2447] 最大公因数等于 K 的子数组数目
 */

// @lc code=start
public class A2447 {
    public static void main(String[] args) {
        int[] nums = { 128761, 2346412 };
        int k = 3;
        A2447Solution a2447Solution = new A2447Solution();
        int res = a2447Solution.subarrayGCD(nums, k);
        System.out.println(res);
    }
}

class A2447Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (dp[i] == k) {
                count++;
            }
            for (int j = i - 1; j >= 0; j--) {
                dp[j] = gcd(dp[j], nums[i]);
                if (dp[j] == k) {
                    count++;
                }
                if (dp[j] < k) {
                    break;
                }
            }
        }

        return count;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

// @lc code=end

class Solution {
    public int subarrayGCD(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, f = nums[r], c = 0;
        while (r < n) {
            int e = gcd(f, nums[r]);
            if (e % k != 0) {
                r++;
                if (r == n)
                    break;
                l = r;
                f = nums[r];
                continue;
            } else if (e == k) {
                int p = r, d = nums[r];
                while (p >= l) {
                    int g = gcd(nums[p], d);
                    if (g == k) {
                        c += p - l + 1;
                        break;
                    }
                    d = g;
                    p--;
                }
            }
            f = e;
            r++;
        }
        return c;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        return a % b == 0 ? b : gcd(b, a % b);
    }
}
