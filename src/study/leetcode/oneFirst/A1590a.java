package study.leetcode.oneFirst;
/*
 * @lc app=leetcode.cn id=1590 lang=java
 *
 * [1590] 使数组和能被 P 整除 中等
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// @lc code=start
public class A1590a {
    public static void main(String[] args) {
        int[] nums = { 3,6,8,1};
        int p = 8;
        System.out.println(minSubarray1(nums, p));
        System.out.println(minSubarray2(nums, p));
    }

    public static  int minSubarray2(int[] nums,int p ){
        long sum = 0;
        for (long num : nums) {
            sum += num;
        }
        if (sum < p) {
            return -1;
        }
        if( sum % p == 0) {
            return 0;
        }
        int res = 1;
        while(res<nums.length){
            for (int i = 0; i < nums.length; i++) {
                int tabSum = nums[i];
                for (int j = i + 1; j < res+i && j!=nums.length; j++) {
                    tabSum += nums[j];
                }
                if ((sum - tabSum) % p == 0) {
                    return i+1;
                }
            }
            res++;

        }
        return -1;
    }

    public static int minSubarray1(int[] nums, int p) {
        int length = nums.length;
        int res = 0;
        long sum = 0;
        HashMap<Long, Integer> has = new HashMap<>();
        for (long num : nums) {
            has.put(num, has.get(num) == null ? 1 : has.get(num) + 1);
            sum += num;
        }
        if (sum < p) {
            return -1;
        }
        long d = sum % p;
        if (d == 0) {
            return res;
        }
        int count = 0;
        long target = d;
        List<Long> list = new ArrayList<>();
        while (count < length) {
            HashMap<Long, Integer> temp = new HashMap<>(has);
            for (long i = target; i > 0; i--) {
                int num = temp.getOrDefault(i, 0);
                if (num == 0) {
                    continue;
                }
                if (list.contains(i)) {
                    continue;
                }
                list.add(i);
                temp.put(i, num--);
                target = (target - i);
                i = target + 1;
                res++;
                if (target == 0) {
                    return res;
                }
            }
            target = d;
            res = 0;
            count++;
        }
        return -1;
    }
}
