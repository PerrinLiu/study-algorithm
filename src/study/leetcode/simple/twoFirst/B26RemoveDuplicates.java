package study.leetcode.simple.twoFirst;

import java.util.*;

/**
 * 删除重复项
 *
 * @author llpy
 * @date 2024/04/20
 */
public class B26RemoveDuplicates {
//    26. 删除有序数组中的重复项
//            简单
//    相关标签
//            相关企业
//    提示
//    给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
//
//    考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
//
//    更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
//    返回 k 。
//    判题标准:
//
//    系统会用下面的代码来测试你的题解:
//
//    int[] nums = [...]; // 输入数组
//    int[] expectedNums = [...]; // 长度正确的期望答案
//
//    int k = removeDuplicates(nums); // 调用
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//        assert nums[i] == expectedNums[i];
//    }
//    如果所有断言都通过，那么您的题解将被 通过。
    public static void main(String[] args) {

        int[] nums = {-3,-1,0,0,0,3,3};
        System.out.println(removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (nums[index] !=num ) {
                nums[++index] = num;
            }
        }
        return index + 1;
    }
}
