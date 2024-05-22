package study.leetcode.AFirst;

import java.util.ArrayList;
import java.util.List;

class Solution1542 {
    public static void main(String[] args) {
        System.out.println(new Solution1542().longestAwesome("3242415"));
    }
    public int longestAwesome(String s) {
        int res = 0;
        int length = s.length();
        List<Integer> charList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            charList.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }
        for (int i = 0; i < length-1; i++) {
            int number = 1;
            ArrayList<Integer> objects = new ArrayList<>(charList.subList(i+1,charList.size()-1));
            int c =Integer.parseInt(String.valueOf(s.charAt(i+number)));
            int i2 = objects.indexOf(c);
            int i1 = objects.lastIndexOf(c);
            int i3 = objects.indexOf(i);
            boolean contains = objects.contains(Integer.parseInt(String.valueOf(s.charAt(i))));
            while(contains || (i1!=-1 && i2 !=i1)){
                if(contains && (i1!=-1 && i2 !=i1)){
                    number += 3;
                    objects.remove(i1);
                    objects.remove(i2);
                    objects.remove(i3);
                }else if((i1!=-1 && i2 !=i1)){
                    number +=2;
                    objects.remove(i1);
                    objects.remove(i2);
                }else{
                    number +=1;
                    objects.remove(i3);
                }
                contains = objects.contains(Integer.parseInt(String.valueOf(s.charAt(i+number))));
                c =Integer.parseInt(String.valueOf(s.charAt(i+number)));
                i2 = objects.indexOf(c);
                 i1 = objects.lastIndexOf(c);
                 i3 = objects.indexOf(i);
            }
            res = Math.max(number,res);
        }
        return res;
    }
}
