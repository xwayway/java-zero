package io.github.weechang.leetcode;

import java.util.TreeMap;

/**
 *  一千万个数求最大的100个数
 *
 * @author zhangwei
 * date 2020/5/15
 * time 0:01
 */
public class TopK {

    public static void main(String[] args) {
        int[] a = new int[10000000];
        int n = 100;
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        int[] topk = topk(a, n);
        for (int i = 0; i < topk.length; i++) {
            System.out.println(topk[i]);
        }
    }

    public static int[] topk(int[] source, int n) {
        if (source == null || source.length == 0 || n <= 0) {
            return null;
        }
        int len = source.length;
        n = Math.min(len, n);
        int[] topk = new int[n];
        TreeMap<Integer, Object> res = new TreeMap<Integer, Object>();
        for (int i = 0; i < len; i++) {
            int temp = source[i];
            if (i < n) {
                res.put(temp, null);
            } else {
                int min = res.firstKey();
                if (min < temp) {
                    res.remove(min);
                    res.put(temp, null);
                }
            }
        }
        int i = res.keySet().size() - 1;
        for (Integer v : res.keySet()) {
            topk[i] = v;
            i--;
        }
        return topk;
    }
}
