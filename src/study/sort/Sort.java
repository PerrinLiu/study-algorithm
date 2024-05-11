package study.sort;

import static study.sort.SortCode.bubbleSort;
import static study.sort.SortCode.countSort;
import static study.sort.SortCode.insertSort;
import static study.sort.SortCode.mergeSort;
import static study.sort.SortCode.quickSort;
import static study.sort.SortCode.selectSort;
import static study.sort.SortCode.shellSort;

import java.util.Random;

/**
 * 排序
 *
 * @author llpy
 * @date 2023/12/15
 */
public class Sort {
    // 开始时间
    private static long start;
    // 结束时间
    private static long end;
    private static final int ARR_LEN = 20000;
    private static final int MAX_INT = 1000000;

    private static int[] arr;

    public static void main(String[] args) {

        // 冒泡
        generateArray(ARR_LEN);// 生成数组
        start = getTimeMillis(); // 获取开始时间
        bubbleSort(arr);
        end = getTimeMillis(); // 结束时间
        printResult(SortType.Bubble.getCnName()); // 打印结果

        // 选择排序
        generateArray(ARR_LEN);// 重新生成数组
        start = getTimeMillis();
        selectSort(arr);
        end = getTimeMillis();
        printResult(SortType.Select.getCnName());

        // 插入排序
        generateArray(ARR_LEN);
        start = getTimeMillis();
        insertSort(arr);
        end = getTimeMillis();
        printResult(SortType.Insertion.getCnName());

        // 希尔排序
        generateArray(ARR_LEN);
        start = getTimeMillis();
        shellSort(arr);
        end = getTimeMillis();
        printResult(SortType.Shell.getCnName());

        // 归并排序
        generateArray(ARR_LEN);
        start = getTimeMillis();
        mergeSort(arr, 0, arr.length - 1);
        end = getTimeMillis();
        printResult(SortType.Merge.getCnName());

        // 快速排序
        generateArray(ARR_LEN); // 重新生成数组
        start = getTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        end = getTimeMillis();
        printResult(SortType.Quick.getCnName());

        // 堆排序

        // 计数排序
        generateArray(ARR_LEN);
        start = getTimeMillis();
        countSort(arr);
        end = getTimeMillis();
        printResult(SortType.Counting.getCnName());

        // 桶排序

        // 基数排序

    }

    /**
     * 打印结果
     *
     * @param sortType 排序类型
     */
    private static void printResult(String sortType) {
        System.out.println("数组长度为:" + ARR_LEN + "," + sortType + "耗时为:" + (end - start) + "ms");
    }

    /**
     * 获取时间毫秒
     *
     * @return long
     */
    private static long getTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * 生成数组
     *
     * @param length 长
     */// 生成随机数组
    public static void generateArray(int length) {
        int[] randomArray = new int[length];
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            // 生成 minValue 到 maxValue 之间的随机整数
            int randomValue = random.nextInt(MAX_INT + 1);
            randomArray[i] = randomValue;
        }
        arr = randomArray;
    }

}
