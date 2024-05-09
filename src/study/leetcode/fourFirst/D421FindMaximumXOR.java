package study.leetcode.fourFirst;

import java.util.HashSet;
import java.util.Set;

/**
 * 查找最大异或
 *
 * @author llpy
 * @date 2024/05/09
 */
public class D421FindMaximumXOR {
    //    给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
//
//    示例 1：
//
//    输入：nums = [3,10,5,25,2,8]
//    输出：28
//    解释：最大运算结果是 5 XOR 25 = 28.
//    示例 2：
//
//    输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//    输出：127
//    提示：
//
//            1 <= nums.length <= 2 * 105
//            0 <= nums[i] <= 231 - 1
//    Related Topics
//    位运算
//            字典树
//    数组
//            哈希表
    public static void main(String[] args) {
        int[] nums = {70, 14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66};
        int[] nums2 = {70, 14, 70, 53};

        System.out.println(findMaximumXOR(nums));
        System.out.println(findMaximumXOR2(nums2));
    }

    public static int findMaximumXOR(int[] nums) {
        int maxResult = 0;
        int mask = 0;

        // 从最高位开始遍历
        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> prefixes = new HashSet<>();

            // 将所有数字的前缀存储在集合中
            for (int num : nums) {
                prefixes.add(num & mask);
            }

            // 假设最大异或结果的第 i 位为 1
            int candidate = maxResult | (1 << i);

            // 检查是否存在两个前缀，它们的异或结果等于候选值
            for (int prefix : prefixes) {
                if (prefixes.contains(candidate ^ prefix)) {
                    maxResult = candidate;
                    break;
                }
            }
        }

        return maxResult;
    }


    public static int findMaximumXOR2(int[] nums) {
        int x = 0;
        for (int k = 30; k >= 0; --k) {
            Set<Integer> seen = new HashSet<Integer>();
            // 将所有的 pre^k(a_j) 放入哈希表中
            for (int num : nums) {
                // 如果只想保留从最高位开始到第 k 个二进制位为止的部分
                // 只需将其右移 k 位
                int i = num >> k;
                seen.add(i);
            }

            // 目前 x 包含从最高位开始到第 k+1 个二进制位为止的部分
            // 我们将 x 的第 k 个二进制位置为 1，即为 x = x*2+1
            int xNext = x * 2 + 1;
            boolean found = false;

            // 枚举 i
            for (int num : nums) {
                int i = num >> k;
                int i1 = xNext ^ i;
                if (seen.contains(i1)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                x = xNext;
            } else {
                // 如果没有找到满足等式的 a_i 和 a_j，那么 x 的第 k 个二进制位只能为 0
                // 即为 x = x*2
                x = xNext - 1;
            }
        }
        return x;

    }
}
