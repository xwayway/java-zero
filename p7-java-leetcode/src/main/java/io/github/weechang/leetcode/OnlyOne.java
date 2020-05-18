package io.github.weechang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 出数组中唯一一个出现一次的元素
 * @author zhangwei
 * date 2020/5/15
 * time 0:46
 */
public class OnlyOne {

    public static void main(String[] args) {
        int[] a = {1, 2, 2};
        System.out.println(onlyone(a));
        System.out.println(onlyone2(a));
    }

    public static Integer onlyone(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        int res = a[0];
        for (int i = 1; i < a.length; i++) {
            res = res ^ a[i];
        }
        return res;
    }

    public static Integer onlyone2(int[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i])) {
                map.remove(a[i]);
            } else {
                map.put(a[i], null);
            }
        }
        if (map.keySet().size() == 1) {
            for (Integer res : map.keySet()) {
                return res;
            }
        }
        return null;
    }
}
