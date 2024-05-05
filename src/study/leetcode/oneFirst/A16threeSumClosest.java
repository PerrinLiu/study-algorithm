package study.leetcode.oneFirst;

import study.TimingTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 16最接近三和
 *
 * @author llpy
 * @date 2024/04/28
 */
public class A16threeSumClosest {
    //    16. 最接近的三数之和
//    给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
//
//    返回这三个数的和。
//
//    假定每组输入只存在恰好一个解。
//
//
//
//    示例 1：
//
//    输入：nums = [-1,2,1,-4], target = 1
//    输出：2
//    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//    示例 2：
//
//    输入：nums = [0,0,0], target = 1
//    输出：0
//
//
//    提示：
//
//            3 <= nums.length <= 1000
//            -1000 <= nums[i] <= 1000
//            -104 <= target <= 104
    public static void main(String[] args) {
        List<Object> param = new ArrayList<>();
        int[] nums = {-5, -5, -4, 0, 0, 3, 3, 4};
        int target = -2;
        param.add(nums);
        param.add(target);
        TimingTemplate timingTemplate = new threeSumClosest();
        timingTemplate.run(param);
        TimingTemplate timingTemplate2 = new threeSumClosest2();
        timingTemplate2.run(param);
    }

}

class threeSumClosest extends TimingTemplate {

    @Override
    protected Object method(Object obj) {
        List<Object> params = (List<Object>) obj;
        int[] nums = (int[]) params.get(0);
        int target = (int) params.get(1);

        int res = Integer.MAX_VALUE;
        int tab = Integer.MAX_VALUE;
        int source;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    source = nums[i] + nums[j] + nums[k];
                    int num = source > target ? source - target : target - source;
                    if (num > tab) {
                        continue;
                    }
                    tab = Math.min(tab, num);
                    res = tab == num ? source : res;
                    if (tab == 0) {
                        break;
                    }
                }
            }
        }
        return res;
    }
}

class threeSumClosest2 extends TimingTemplate {

    @Override
    protected Object method(Object obj) {
        List<Object> params = (List<Object>) obj;
        int[] nums = (int[]) params.get(0);
        int target = (int) params.get(1);   //{-5,-5,-4,-3,0,0,3,3,4};{-5,-5,-4,-3,0,0,3,3,4};{-5,-5,-4,-3,0,0,3,3,4};
        Arrays.sort(nums);
        int len = nums.length;
        int res = Integer.MAX_VALUE;
        int difference = Integer.MAX_VALUE;
        // 枚举 a
        for (int i = 0; i < len; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值来更新答案
                int num = sum > target ? sum - target : target - sum;
                if (difference > num) {
                    res = sum;
                    difference = num;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                    continue;
                }
                // 如果和小于 target，移动 b 对应的指针
                int j0 = j + 1;
                // 移动到下一个不相等的元素
                while (j0 < k && nums[j0] == nums[j]) {
                    ++j0;
                }
                j = j0;
            }
        }
        return res;
    }
}
