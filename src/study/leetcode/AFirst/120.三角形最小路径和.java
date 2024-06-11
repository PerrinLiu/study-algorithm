/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution120 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        Collections.addAll(list, list1, list2, list3, list4);
        Collections.addAll(list1, 2);
        Collections.addAll(list2, 3, 4);
        Collections.addAll(list3, 6, 5, 7);
        Collections.addAll(list4, 4, 1, 8, 3);

        System.out.println(new Solution120().minimumTotal(list));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> list3 = new ArrayList<>();
        for (List<Integer> triangle2 : triangle) {
            List<Integer> arrayList = new ArrayList<>();
            triangle2.forEach(a -> {
                arrayList.add(a);
            });
            list3.add(arrayList);
        }
        int index = 0;
        while (index < triangle.size() - 1) {
            List<Integer> list1 = triangle.get(index);
            List<Integer> list2 = triangle.get(index + 1);
            List<Integer> list4 = list3.get(index + 1);
            for (int i = 0; i < list1.size(); i++) {
                for (int j = i; j <= i + 1; j++) {
                    int number = 0;
                    if (i != 0 && list2.get(j) != list4.get(j)) {
                        number = (Math.min(list1.get(i), list1.get(i - 1)) + list2.get(j)) - list1.get(i - 1);
                    } else {
                        number = list1.get(i) + list2.get(j);
                    }
                    list2.set(j, number);
                }
            }

            index++;
        }
        Collections.sort(triangle.get(triangle.size() - 1));
        return triangle.get(triangle.size() - 1).get(0);
    }
}
// @lc code=end
