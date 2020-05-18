package io.github.weechang.leetcode;

/**
 * 判断一个字符串，是否是IPv4
 *
 * @author zhangwei
 * date 2020/5/18
 * time 20:43
 */
public class IsIPV4 {

    public static void main(String[] args) {
        System.out.println(isIpv4("123.123.123.256"));
    }

    public static boolean isIpv4(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String[] ipArray = str.split("\\.");
        if (ipArray.length != 4) {
            return false;
        }
        for (String item : ipArray) {
            try {
                if (item.length() != 1 && item.charAt(0) == '0') {
                    return false;
                }
                int ip = Integer.parseInt(item);
                if (ip < 0 || ip > 255) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }
}
