package io.github.weechang.leetcode;

/**
 * 求 x 的 y 次方
 *
 * @author zhangwei
 * date 2020/5/18
 * time 20:50
 */
public class YPowerOfX {

    public static void main(String[] args) {
        System.out.println(yPowerOfx(2, 30));
    }

    public static int yPowerOfx(int x, int y) {
        if (x == 1) {
            return 1;
        }
        if (y == 0) {
            return 1;
        }
        return x * yPowerOfx(x, y - 1);
    }
}
