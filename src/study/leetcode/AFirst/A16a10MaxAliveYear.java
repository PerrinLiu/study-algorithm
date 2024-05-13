package study.leetcode.AFirst;

import java.util.ArrayList;
import java.util.List;

/**
 * a16a10最大生存年
 * a16a10
 *
 * @author llpy
 * @date 2024/05/09
 */
public class A16a10MaxAliveYear {
    // 给定 N 个人的出生年份和死亡年份，第 i 个人的出生年份为 birth[i]，死亡年份为 death[i]，实现一个方法以计算生存人数最多的年份。
    // 中等
    // 你可以假设所有人都出生于 1900 年至 2000 年（含 1900 和 2000 ）之间。
    // 如果一个人在某一年的任意时期处于生存状态，那么他应该被纳入那一年的统计中。
    // 例如，生于 1908 年、死于 1909 年的人应当被列入 1908 年和 1909 年的计数。
    //
    // 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
    //
    // 示例：
    //
    // 输入：
    // birth = [1900, 1901, 1950]
    // death = [1948, 1951, 2000]
    // 输出： 1901
    // 提示：
    //
    // 0 < birth.length == death.length <= 10000
    // birth[i] <= death[i]
    // Related Topics
    // 数组
    // 计数

    public static void main(String[] args) {
        int[] birth = { 1927, 1954, 1903, 1928, 1956, 1929, 1929, 1928, 1958, 1902, 1953, 1912, 1923, 1937, 1915, 1942,
                1964, 1954, 1924, 1936, 1963, 1950, 1904, 1931, 1951, 1953, 1922, 1970, 1986, 1947, 1911, 1965, 1913,
                1920, 1947, 1962, 1903, 1905, 1978, 1974, 1950, 1921, 1929, 1901, 1925, 1929, 1951, 1944, 1945 };

        int[] death = { 1987, 1992, 1967, 1997, 1963, 1970, 1944, 1986, 1997, 1937, 1971, 1982, 1980, 1992, 1995, 1992,
                1991, 1964, 1985, 1938, 1975, 1964, 1975, 1961, 1995, 1985, 1946, 1989, 1999, 1994, 1956, 1984, 1999,
                1966, 1950, 1993, 1960, 1939, 1990, 1975, 1982, 1921, 1964, 1998, 1969, 1970, 1965, 1973, 1958 };
        System.out.println(maxAliveYear(birth, death));
    }

    public static int maxAliveYear(int[] birth, int[] death) {
        int res = 0;
        int sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int year : birth) {
            if (list.contains(year)) {
                continue;
            }
            list.add(year);
            int indexSum = 0;
            for (int j = 0; j < death.length; j++) {
                int cs = birth[j];
                int dead = death[j];
                if (year >= cs && dead >= year) {
                    indexSum++;
                }
            }
            if (indexSum > sum) {
                res = year;
                sum = indexSum;
            }
            if (indexSum == sum) {
                res = Math.min(res, year);
            }
        }
        return res;
    }

    public static int maxAliveYear1(int[] birth, int[] death) {
        // 先统计每年的人口数变化
        int[] change = new int[102];
        for (int i = 0; i < birth.length; i++) {
            // eg:1900年出生的人导致1900年变化人数加1，存储在change[0]
            change[birth[i] - 1900]++;
            // eg:1900年死亡的人导致1901年变化人数减1，存储在change[1]
            change[death[i] - 1899]--;
        }
        int maxAlive = 0;
        int curAlive = 0;
        int theYear = 1900;
        // 再根据每年变化人数求一个最大值
        for (int i = 0; i < 101; i++) {
            curAlive += change[i];
            if (curAlive > maxAlive) {
                maxAlive = curAlive;
                theYear = 1900 + i;
            }
        }
        return theYear;
    }
}
