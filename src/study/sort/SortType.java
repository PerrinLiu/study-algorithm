package study.sort;

public enum SortType {
    Select("选择排序"),
    Insertion("插入排序") ,
    Bubble("冒泡排序") ,
    Shell("希尔排序") ,
    Merge("归并排序") ,
    Quick("快速排序") ,
    Heap("队排序") ,
    Counting("计数排序") ,
    Bucket("桶排序") ,
    Radix("基数排序") ,
    ;



    private String cnName;

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String name) {
        this.cnName = name;
    }

    SortType(String name) {
        this.cnName = name;
    }

}
