package study.leetcode.simple;


import study.StatisticsTime;

import java.util.Collections;
import java.util.HashMap;

/**
 * a12 int转罗马
 *
 * @author llpy
 * @date 2024/04/28
 */
public class A12IntToRoman {
//    罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//
//    字符          数值
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
//    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
//    数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
//    同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//    I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//    X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//    C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//    给你一个整数，将其转为罗马数字。
//
//
//
//    示例 1:
//
//    输入: num = 3
//    输出: "III"
//    示例 2:
//
//    输入: num = 4
//    输出: "IV"
//    示例 3:
//
//    输入: num = 9
//    输出: "IX"
//    示例 4:
//
//    输入: num = 58
//    输出: "LVIII"
//    解释: L = 50, V = 5, III = 3.
//    示例 5:
//
//    输入: num = 1994
//    输出: "MCMXCIV"
//    解释: M = 1000, CM = 900, XC = 90, IV = 4.
    public static void main(String[] args) {
        StatisticsTime intToRoman = new intToRoman();
        StatisticsTime intToRoman2 = new IntToRoman2();
        intToRoman.run(69999);
        intToRoman2.run(69999);
    }
}
class intToRoman extends StatisticsTime{

    @Override
    protected Object method(Object s) {
        int num = (int) s;
        HashMap<Integer,String> romanMap = new HashMap<>();
        romanMap.put(1,"I");romanMap.put(4,"IV");romanMap.put(5,"V");romanMap.put(9,"IX");romanMap.put(10,"X");
        romanMap.put(40,"XL");romanMap.put(50,"L"); romanMap.put(90,"XC");romanMap.put(100,"C");
        romanMap.put(400,"CD");romanMap.put(500,"D");romanMap.put(900,"CM");romanMap.put(1000,"M");
        int mul = 1;
        StringBuilder res = new StringBuilder();
        while(num > 0){
            int i = (num %10) * mul;
            if(mul>1000){
                mul =1000;
            }
            num = num/10;
            StringBuilder numToRoman= new StringBuilder();
            if(romanMap.get(i)!=null){
                numToRoman = new StringBuilder(romanMap.get(i));
            }else if(i >= 5*mul) {
                if(mul<1000){
                    i = i - 5*mul;
                }
                while(i > 0){
                    String s1 = romanMap.get(mul);
                    numToRoman.append(s1);
                    i=i-mul;
                }
                if(mul<1000){
                    numToRoman.insert(0, romanMap.get(5 * mul));
                }
            }else{
                while(i > 0){
                    String s1 = romanMap.get(mul);
                    numToRoman.append(s1);
                    i = i-mul;
                }
            }
            mul *=10;

            res.insert(0, numToRoman);
        }
        return res.toString();
    }
}

class IntToRoman2 extends StatisticsTime {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @Override
    protected Object method(Object s) {
        int num = (int) s;
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}
