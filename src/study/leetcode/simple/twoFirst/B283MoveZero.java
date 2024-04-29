package study.leetcode.simple.twoFirst;

import java.util.Arrays;

/**
 * 移动零点
 *
 * @author llpy
 * @date 2024/04/20
 */
public class B283MoveZero {
//    283.移动零
//            简单
//    相关标签
//? 提示8 相关企业随
//    给定-个数组 nums编写一个函数将所有 0移动到数组的末尾，同时保持非零元素的相对顺序。
//    请注意，必须在不复制数组的情况下原地对数组进行操作。
//    示例 1:
//    输入:nums =[0,1,0,3,12]
//    输出:[1,3,12,0,0]
//    示例 2:
//    输入:nums =[0]
//    输出:[@]
//    提示:
//            1<= nums.length <= 104
//            ，-231<=nums[i]<= 231-1
//    进阶:你能尽量减少完成的操作次数吗?




    public static void main(String[] args){
        int[] nums = {0, 1, 0, 3, 12};
        moveZero(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZero(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i=nums.length-1;i>=index;i--){
            nums[i] = 0;
        }
    }
}
