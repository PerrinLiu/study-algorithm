package study.sort;


/**
 * 排序代码
 *
 * @author llpy
 * @date 2024/04/20
 */
public class SortCode {
    /**
     * 计数排序
     *
     * @param arr arr
     */
    public static void countSort(int[] arr) {
        int max = arr[0];
        //找到最大值
        for (int i : arr) {
            max = Math.max(max, i);
        }
        //创建一个长度为最大的值的数组
        int[] temp = new int[max+1];
        for (int i : arr) {
            temp[i] = temp[i]+1;
        }
        int count = 0;
        for (int i = 0; i < temp.length; i++) {
            while(temp[i]!=0){
                arr[count] = i;
                count++;
                temp[i]--;
            }
        }
    }


    /**
     * 归并排序
     *
     * @param arr arr
     */
    // 归并排序
    public static void mergeSort(int[] arr, int left, int right) {
        //当数组长度不为1时
        if(left < right){
            int mid = (right+left)/2;
            //拆分数组继续排序
            mergeSort(arr,left,mid);
            mergeSort(arr,mid+1,right);
            //合并
            merge(arr,left,mid,right);
        }
    }

    private static void merge(int[] arr,int left,int mid,int right){
        //创建一个临时数组
        int[] tempArr = new int[right-left+1];
        int k = 0;  //数组下标
        int i = left;
        int j = mid+1; //中间下标

        while(i<=mid && j <=right){
            //判断谁更小,小的放前面
            if(arr[i]<arr[j]){
                tempArr[k++] = arr[i++];
            }else{
                tempArr[k++] = arr[j++];
            }
        }

        while(i<=mid){
            tempArr[k++] = arr[i++];
        }
        while(j<=right){
            tempArr[k++] = arr[j++];
        }
        // 把临时数组复制到原数组
        for (i = 0; i < k; i++) {
            arr[left++] = tempArr[i];
        }
    }


    /**
     * shell排序
     *
     * @param arr arr
     */
    public static void shellSort(int[] arr) {

        int n = arr.length;
        // 对每组间隔为 h的分组进行排序，刚开始 i = n / 2;
        for (int i = n / 2; i > 0; i /= 2) {
            //对各个局部分组进行插入排序
            for (int j = i; j < n; j++) {
                // 将arr[j] 插入到所在分组的正确位置上,arr[j]
                //i表示当前分组的间隔,j为需要插入的元素的下标
                shellInsert(arr, i, j);
            }
        }
    }

    /**
     * 外壳插入件
     *
     * @param arr arr
     * @param i   当前分组的间隔
     * @param j   需要插入的元素的下标
     */
    private static void shellInsert(int[] arr, int i, int j) {
        //将当前子序列中的第 j 个元素暂存到 temp 中
        int temp = arr[j];
        //计算子序列中相邻元素的间隔
        int k = j - i;

        //在子序列中进行插入排序，向前比较并移动元素，直到找到合适的位置插入 temp
        while (k >= 0 && temp < arr[k]) {
            //将较大的元素向后移动
            arr[k + i] = arr[k];
            // 更新 k，继续比较
            k = k - i;
        }
        //将 temp 插入到正确的位置，完成一次插入排序
        arr[k + i] = temp;
    }

    /**
     * 插入排序
     *
     * @param arr arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //基准值,从第二位开始拿,因为第一位作为比较位
            int temp = arr[i];
            //i-1是开始比较的位置
            int key = i - 1;
            //上一位比temp大时,key-1,继续比较
            while (key >= 0 && arr[key] >= temp) {
                key--;  //最小值为负1
            }


            //为了防止下标越界,key+1,
            key = key + 1;

            //作用:将数组当前下标开始的数组,后移一位
            //key发生过变化时,下面的循环才会执行,因为如果key没发生过变化,key是等于i的,j>k是不成立的
            for (int j = i; j > key; j--) {
                //这里是第前一位等于下一位,比如[2,1]变为了[ ,2,1]
                arr[j] = arr[j - 1];
            }
            //将下标key的值赋为temp,如果key没变化过,那么key+1等于i,值还是正确的
            arr[key] = temp;

        }
    }

    /**
     * 选择排序
     *
     * @param arr arr
     */
    public static void selectSort(int[] arr) {
        //遍历
        for (int i = 0; i < arr.length; i++) {
            //默认以下标i作为最小的值,从头开始比较
            int min = i;
            //遍历
            for (int j = i + 1; j < arr.length; j++) {
                //与下一位比较,直到遇到了比他小的数,将下标互换
                if (arr[min] > arr[j]) {
                    min = j;
                    //保存默认的值
                    int temp = arr[i];
                    //将下标i赋为最小值
                    arr[i] = arr[min];
                    //将下标为最小值的赋为默认值
                    arr[min] = temp;
                }
            }
        }
    }



    /**
     * 快速排序
     *
     * @param arr        arr
     * @param leftIndex  左索引
     * @param rightIndex 右侧索引
     */
    public static void quickSort(int[] arr, int leftIndex, int rightIndex) {
        //当左索引大于等于右索引证明有序,直接return
        if (leftIndex >= rightIndex) {
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        int key = arr[right]; //基准值   取最后一个值
        //当左索引小于右索引时循环
        while (left < right) {
            //左边,小于基准值,从left下标的位置开始比较
            while (left < right && arr[left] <= key) {
                //如果小于等于基准值,代表该值要留在此位置,左索引加1后,继续比较
                left++;
            }
            //当大于基准时时,互换位置
            arr[right] = arr[left];
            //右边,大于基准值,从最右开始比较
            while (left < right && arr[right] >= key) {
                //如果大于等于基准值,代表该值要留在此位置,右索引-1后继续比较
                right--;
            }
            //当小于基准值时,代表需要互换位置
            arr[left] = arr[right];
        }
        //因为上面把key覆盖了,结束后就要将key归位
        arr[right] = key;
        // 循环结束后,会基于基准值划分成两个新的数组,将其递归
        quickSort(arr, leftIndex, right - 1);
        quickSort(arr, right + 1, rightIndex);
    }

    /**
     * 冒泡排序
     *
     * @param arr arr
     */
    public static void bubbleSort(int[] arr) {
        //嵌套循环,一一比较
        for (int i = 0; i < arr.length; i++) {
            //标记循环有没有发生交换
            boolean isChange = false;
            //这里从i开始,因为从i之前的值都是有序的了,无需比较
            for (int j = i; j < arr.length; j++) {
                //当arr[i] > arr[j]时,代表需要交换值
                if (arr[i] > arr[j]) {
                    //临时存储arr[j]的值
                    int temp = arr[j];
                    //交换值
                    arr[j] = arr[i];
                    arr[i] = temp;
                    //交换过值,将值改为true
                    isChange = true;
                }
            }
            //如果一整轮都没发生变化,代表数组已经是有序的,直接结束循环
            if (!isChange) {
                break;
            }
        }
    }


}
