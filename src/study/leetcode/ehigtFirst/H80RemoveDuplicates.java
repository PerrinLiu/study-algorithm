package study.leetcode.ehigtFirst;

import java.util.*;

/**
 * h80删除重复项
 *
 * @author llpy
 * @date 2024/05/08
 */
public class H80RemoveDuplicates {
    //80. 删除有序数组中的重复项 II  中等
//    给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
//
//    不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
//

    //
//
//    示例 1：
//
//    输入：nums = [1,1,1,2,2,3]
//    输出：5, nums = [1,1,2,2,3]
//    解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3。 不需要考虑数组中超出新长度后面的元素。
//    示例 2：
//
//    输入：nums = [0,0,1,1,1,1,2,3,3]
//    输出：7, nums = [0,0,1,1,2,3,3]
//    解释：函数应返回新长度 length = 7, 并且原数组的前七个元素被修改为 0, 0, 1, 1, 2, 3, 3。不需要考虑数组中超出新长度后面的元素。
//
//
//    提示：
//            1 <= nums.length <= 3 * 104
//            -104 <= nums[i] <= 104
//    nums 已按升序排列
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3};
        int i = removeDuplicates2(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        for (int num : nums) {
            if (!hashMap.containsKey(num)) {
                hashMap.put(num, 1);
                continue;
            }
            if (hashMap.get(num) < 2) {
                hashMap.put(num, 2);
            }
        }
        int index = 0;
        for (Integer num : hashMap.keySet()) {
            Integer number = hashMap.get(num);
            for (int i = 0; i < number; i++) {
                nums[index++] = num;
            }
        }

        return index;
    }

    public static int removeDuplicates2(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (result < 2 || num > nums[result - 2]) {
                nums[result++] = num;
            }
        }
        return result;
    }
}
