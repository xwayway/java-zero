package io.github.weechang.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 一千万个数求最大的100个数
 *
 * @author zhangwei
 * date 2020/5/15
 * time 0:01
 */
public class TopK {

    public static void main(String[] args) {
        int[] a = new int[10000];
        int n = 100;
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        int[] topk = topkQueue(a, n);
        for (int i = 0; i < topk.length; i++) {
            System.out.println(topk[i]);
        }
    }

    public static int[] topkQueue(int[] source, int n) {
        if (source == null || source.length == 0 || n <= 0) {
            return null;
        }
        int len = source.length;
        n = Math.min(len, n);
        int[] topk = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < len; i++) {
            int temp = source[i];
            if (i < n) {
                queue.add(temp);
            } else {
                int min = queue.peek();
                if (min < temp) {
                    queue.poll();
                    queue.add(temp);
                }
            }
        }
        int i = n - 1;
        while (queue.size() > 0) {
            topk[i] = queue.poll();
            i--;
        }
        return topk;
    }

    public static int[] topkMap(int[] source, int n) {
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
