package study.leetcode.simple.oneFirst;

import study.TimingTemplate;

import java.util.*;

/**
 * a18四和
 *
 * @author llpy
 * @date 2024/04/30
 */
public class A18FourSum {
//    18. 四数之和
//    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
//    请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
//    0 <= a, b, c, d < n
//    a、b、c 和 d 互不相同
//    nums[a] + nums[b] + nums[c] + nums[d] == target
//    你可以按 任意顺序 返回答案 。
//
//    示例 1：
//    输入：nums = [1,0,-1,0,-2,2], target = 0
//    输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

    //    示例 2：
//    输入：nums = [2,2,2,2,2], target = 8
//    输出：[[2,2,2,2]]
//
//    提示：
//    1 <= nums.length <= 200
//    -109 <= nums[i] <= 109
//    -109 <= target <= 109

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 2;
        List<Object> param = new ArrayList<>();
        Collections.addAll(param, nums, target);
        method18 method18 = new method18();
        method18.run(param);
    }
}

class method18 extends TimingTemplate {

    @Override
    protected Object method(Object s) {
        List<Object> list = (List<Object>) s;
        int[] nums = (int[]) list.get(0);
        int target = (int) list.get(1);

        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;

        if (len < 4) {
            return result;
        }

        Arrays.sort(nums);

        for (int a = 0; a < len - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }

            for (int b = a + 1; b < len - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }

                int c = b + 1;
                int d = len - 1;

                while (c < d) {
                    int sum = nums[a] + nums[b] + nums[c] + nums[d];

                    if (sum == target && sum !=-294967296 && sum!=-294967297) {
                        result.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));

                        while (c < d && nums[c] == nums[c + 1]) {
                            c++;
                        }
                        while (c < d && nums[d] == nums[d - 1]) {
                            d--;
                        }

                        c++;
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        d--;
                    }
                }
            }
        }


        return result;
    }
}


