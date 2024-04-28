package study.leetcode.simple;

import study.TimingTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
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
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    source = nums[i] + nums[j] + nums[k];
                    int num = source > target ? source - target : target - source;
                    if (num > tab) continue;
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
        int target = (int) params.get(1);
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int tab = Integer.MAX_VALUE;
        int i = 0;
        while ((i+2)<nums.length){
            int count1=1;
            int count2=2;
            while(nums[i]==nums[i+count1] && i+count1+1<nums.length){
                count1++;
            }
            while(nums[i]==nums[i+count2] && i+count2+1<nums.length){
                count2++;
            }
            int source = nums[i] + nums[i+count1] + nums[i+count2];
            int num = source >target? source - target :target-source;
            if(tab<=num){
                break;
            }
            tab = num;
            res = source;
            i++;
        }
        return res;
    }
}
