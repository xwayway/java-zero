package io.github.weechang.leetcode;

/**
 * 判断一个数是否偶数
 *
 * 和 1 & 如果等于0 则是偶数
 *
 * @author zhangwei
 * date 2020/5/15
 * time 23:03
 */
public class IsOdd {

    public static void main(String[] args) {
        System.out.println(isOdd(2));
    }

    public static boolean isOdd(int a) {
        return (a & 1) == 0;
    }
}
