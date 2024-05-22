package study.leetcode.AFirst;

class A1281整数的各位积和之差 {
    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }
    public static int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        while(n>0){
            int i = n % 10;
            mul = mul *i;
            sum +=i;
            n = n/10;
        }
        return mul - sum;
    }
}