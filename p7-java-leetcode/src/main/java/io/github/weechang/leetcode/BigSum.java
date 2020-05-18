package io.github.weechang.leetcode;

import java.util.Scanner;

/**
 * 两个大数相加
 *
 * @author zhangwei
 * date 2020/5/14
 * time 6:27
 */
public class BigSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = "15";
        String s2 = "8";
        System.out.println(sum(s1, s2));
    }

    public static String sum(String s1, String s2) {
        if (s1 == null || s1.length() == 0
                || s2 == null || s2.length() == 0) {
            return null;
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int max = Math.max(l1, l2);
        StringBuffer rst = new StringBuffer();
        int up = 0;
        for (int i = 0; i < max; i++) {
            int i1 = l1 - i - 1;
            int i2 = l2 - i - 1;
            int v1 = 0;
            int v2 = 0;
            if (i1 >= 0) {
                v1 = Integer.parseInt(s1.charAt(i1) + "");
            }
            if (i2 >= 0) {
                v2 = Integer.parseInt(s2.charAt(i2) + "");
            }
            int sum = v1 + v2 + up;
            rst.append(sum % 10);
            up = sum / 10;
        }
        if (up > 0) {
            rst.append(up);
        }
        return rst.reverse().toString();
    }
}
