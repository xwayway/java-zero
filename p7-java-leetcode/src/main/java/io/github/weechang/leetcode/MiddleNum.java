package io.github.weechang.leetcode;

/**
 * 求中位数
 *
 * @author zhangwei
 * date 2020/5/15
 * time 22:51
 */
public class MiddleNum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int low = 0;
        int high = arr.length - 1;
        System.out.println(middle(arr, low, high));
    }

    public static int middle(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = tmp;
        return tmp;
    }
}
